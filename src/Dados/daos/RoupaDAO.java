/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.daos;

import Dados.Entidades.Roupa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

/**
 *
 * @author Michael
 */
public class RoupaDAO {
    

    /**
     * Salvar o ator no BD
     * @param a
     */
    public void salvar(Roupa a) {

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
    public List<Roupa> listar() {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Roupa a", Roupa.class);

        //Retornar a lista de atores
        return consulta.getResultList();

    }

    /**
     * Salva as alterações no BD
     * @param a
     */
    public void editar(Roupa a) {

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
     * Exclui o ator do BD
     * @param a
     */
    public void excluir(Roupa a){
        
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

}

