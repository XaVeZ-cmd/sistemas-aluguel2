/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import Dados.Entidades.Roupa;
import Dados.daos.RoupaDAO;
import java.util.List;

/**
 *
 * @author Michael
 */
public class RoupaServicos {
    

    
    //Atributo para representar a camada de dados
    private  RoupaDAO dao = new RoupaDAO();
    
    public void salvar(Roupa a){
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
    public List<Roupa> listar(){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Pedir a DAO para listar e retornar
        return dao.listar();
        
    }
    
    /**
     * Recebe um ator e manda para a camada DAO atualizar 
     * @param a
     */
    public void editar(Roupa a){
        
        //Qualquer regra de negócio (se aplicável)
        
        
        //Mandar a DAO atualizar os dados no BD
        dao.editar(a);
        
    }
    
    /**
     *  Recebe um ator para passar para a DAO excluir no BD
     * @param a
     */
    public void excluir(Roupa a){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Mandar para a DAO excluir
        dao.excluir(a);
    }
    
}

