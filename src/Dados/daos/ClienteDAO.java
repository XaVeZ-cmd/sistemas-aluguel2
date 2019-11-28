
package Dados.daos;

import Dados.Entidades.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

/**
 *
 * @author Michael
 */
public class ClienteDAO {
    


    /**
     * Salvar o cliente no BD
     * @param a
     */
    public void salvar(Cliente a) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //Mandar persistir o ator
        gerenciador.persist(a);

        //Commit
        gerenciador.getTransaction().commit();

    }

    /**
     * Retorna uma lista com todos os atores que estejam cadastrados no banco de
     * dados
     *
     * @return
     */
    public List<Cliente> listar() {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Cliente a", Cliente.class);

        //Retornar a lista de atores
        return consulta.getResultList();

    }

    /**
     * Salva as alterações no BD
     * @param a
     */
    public void editar(Cliente a) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //Mandar sincronizar as alterações 
        gerenciador.merge(a);
        
        //Commit na transação
        gerenciador.getTransaction().commit();

    }
    
    /**
     * Exclui o cliente do BD
     * @param a
     */
    public void excluir(Cliente a){
        
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Iniciar a transação
        gerenciador.getTransaction().begin();
        
        //Para excluir tem que dar o merge primeiro para 
        //sincronizar o ator do BD com o ator que foi
        //selecionado na tela
        a = gerenciador.merge(a);

        //Mandar sincronizar as alterações 
        gerenciador.remove(a);
        
        //Commit na transação
        gerenciador.getTransaction().commit();
        
    }

    
      public List<Cliente> buscarPeloNome(String nome) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery<Cliente> consulta = gerenciador.createQuery(
                "Select a from Cliente a where a.nome like :nome",
                
                
                
                Cliente.class);

        //Substituindo o parametro :nome pelo valor da variavel n
        consulta.setParameter("nome", nome + "%");
        
        List<Cliente> lista = consulta.getResultList();

        //Retornar os dados
        return lista;
}}

