/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import Dados.Entidades.Cliente;
import Dados.daos.ClienteDAO;
import java.util.List;

/**
 *
 * @author Michael
 */
public class ClienteServicos {
    

    //Atributo para representar a camada de dados
    private ClienteDAO dao = new ClienteDAO();
    
    public void salvar(Cliente a){
        //Fazer qualquer regra de negócio
        
        //Mandar o cliente para a camada de dados
        //para ser salvo no banco de dados
        dao.salvar(a);
    }
    
    /**
     * Solicita a camada DAO para buscar os atores
     * cadastrados
     * @return 
     */
    public List<Cliente> listar(){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Pedir a DAO para listar e retornar
        return dao.listar();
        
    }
    
    /**
     * Recebe um ator e manda para a camada DAO atualizar 
     */
    public void editar(Cliente a){
        
        //Qualquer regra de negócio (se aplicável)
        
        
        //Mandar a DAO atualizar os dados no BD
        dao.editar(a);
        
    }
    
    /**
     *  Recebe um ator para passar para a DAO excluir no BD
     */
    public void excluir(Cliente a){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Mandar para a DAO excluir
        dao.excluir(a);
    }
 
    
      public List<Cliente> buscarPeloNome(String nome){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Mandar para a DAO buscar os filmes pelo nome
        return dao.buscarPeloNome(nome);
}}

