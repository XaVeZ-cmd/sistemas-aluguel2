
package servicos;

import Dados.Entidades.Aluguel;
import Dados.daos.AluguelDAO;
import java.util.List;


public class AluguelServicos {
    


    
    //Atributo para representar a camada de dados
    private AluguelDAO dao = new AluguelDAO();
    
    public void salvar(Aluguel a){
        //Fazer qualquer regra de negócio
        
        //Mandar o ator para a camada de dados
        //para ser salvo no banco de dados
        dao.salvar(a);
    }
    
    /**
     * Solicita a camada DAO para buscar os atores
     * cadastrados
     * @return 
     */
    public List<Aluguel> listar(){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Pedir a DAO para listar e retornar
        return dao.listar();
        
    }
    
    /**
     * Recebe um ator e manda para a camada DAO atualizar 
     */
    public void editar(Aluguel a){
        
        //Qualquer regra de negócio (se aplicável)
        
        
        //Mandar a DAO atualizar os dados no BD
        dao.editar(a);
        
    }
    
    /**
     *  Recebe um ator para passar para a DAO excluir no BD
     */
    public void excluir(Aluguel a){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Mandar para a DAO excluir
        dao.excluir(a);
    }
    
}

