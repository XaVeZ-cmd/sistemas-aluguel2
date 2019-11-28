/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.aluguel;

import Dados.Entidades.Aluguel;
import Dados.Entidades.Cliente;
import Dados.Entidades.Roupa;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import servicos.ClienteServicos;
import servicos.RoupaServicos;
import util.AlertaUtil;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class AluguelController implements Initializable {

    @FXML
    private DatePicker textFieldDataDevolucao;
    @FXML
    private Tab tabCliente;
    @FXML
    private Tab tabRoupa;
    @FXML
    private JFXTextField textFieldRoupa;
    @FXML
    private TableView<Roupa> tabelaRoupaAluguel;
    @FXML
    private TableColumn<?, ?> colTipoRoupa;
    @FXML
    private TableColumn<?, ?> colCaracteristica;
    @FXML
    private Tab tabAluguel;
    @FXML
    private DatePicker textFieldDataRetirada;
    @FXML
    private TableView<Cliente> tabelaCliente;
    @FXML
    private TableColumn<?, ?> colNomeClienteAluguel;
    @FXML
    private TableColumn<?, ?> colRoupaTabelaAluguel;
    @FXML
    private TableColumn<?, ?> colDataRetirada;
    @FXML
    private TableColumn<?, ?> colDataDevolucao;
    @FXML
    private TableColumn<?, ?> colValorAluguel;
    
    //Atributos que representam os Serviços que serão utilizados
    
     private ClienteServicos clienteServico = new ClienteServicos();
     private RoupaServicos roupaServico = new RoupaServicos();
     
       //Atributos que representam os dados das tabelas
    private ObservableList<Aluguel> dadosTabelaAluguel
            = FXCollections.observableArrayList();
    
    private ObservableList<Roupa> dadosTabelaRoupa
            = FXCollections.observableArrayList();
    
       private ObservableList<Cliente> dadosTabelaCliente
            = FXCollections.observableArrayList();
       
       private Cliente clienteSelecionado; //na tabela cliente
        private List<Roupa> roupaSelecionado; //na tabela roupa
    private Aluguel aluguelSelecionado; //na tabela aluguel
   
       
    @FXML
    private JFXTextField textFieldNome;
    @FXML
    private TableColumn<?, ?> colNomeClienteCliente;
    @FXML
    private TableColumn<?, ?> ruaCliente;
    @FXML
    private TableColumn<?, ?> NumeroCasa;
    @FXML
    private JFXTabPane tabPaneAluguel;
    @FXML
    private TableView<?> tabelaAluguel;
    @FXML
    private JFXTextField textFieldClienteSelecionado;
    @FXML
    private JFXTextField textFieldValor;
    @FXML
    private JFXTextField textFieldIdAluguel;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     configurarTabelas();
      
      
        // TODO
    }  
    
    private void configurarTabelas(){
        //Tabela Cliente
        colNomeClienteCliente.setCellValueFactory(
                new PropertyValueFactory("nome"));
        
        ruaCliente.setCellValueFactory(
               new PropertyValueFactory("rua"));
       NumeroCasa.setCellValueFactory(
               new PropertyValueFactory("numeroCasa"));
        // tabela roupa
        
         colCaracteristica.setCellValueFactory(
               new PropertyValueFactory("detalhes"));
         
          colTipoRoupa.setCellValueFactory(
               new PropertyValueFactory("tipoRoupa"));
          
          // tabela aluguel
         
        
        
        
    }

    @FXML
    private void salvarAluguel(ActionEvent event) {
        
        //Verificar se está atualizando ou inserindo
        if(textFieldIdAluguel.getText().isEmpty()){ //inserindo
           //Pega os dados do fomulário
            //e cria um objeto aluguel
            Aluguel a = new Aluguel();
           a.setDataAluguel(textFieldDataRetirada.getValue());
                    a.setDataDevolucao(textFieldDataDevolucao.getValue());
                    a.setCliente(clienteSelecionado);
                    a.setValor(new BigDecimal(textFieldValor.getText()));
                    a.setRoupas(roupaSelecionado);                              
                            
                    }
    }

    @FXML
    private void confirmarClienteSelecionado(ActionEvent event) {
        
        
        //Pega o cliente que estiver selecionado na tabela
        clienteSelecionado = tabelaCliente.getSelectionModel().getSelectedItem();
        
        //Se tem algum cliente selecionado na tabela
        if(clienteSelecionado != null){
            
            //Habilita o Tab de cliente
            ativarTab(tabCliente, true);
                        
            //Seleciona automaticamente o Tab de cliente
            selecionarTab(tabCliente);
                        
            //Carrega o nome do cliente no campo filme selecionado
          textFieldClienteSelecionado.setText(clienteSelecionado.getNome());
            
        }else{
            AlertaUtil.mensagemErro("Selecione um Cliente primeiro.");
        
        
                        
            
        
        }}
    

    @FXML
    private void confirmarRoupaSelecionada(ActionEvent event) {
        
        
        
        //Pega o roupa que estiver selecionado na tabela
        roupaSelecionado = tabelaRoupaAluguel.getSelectionModel().getSelectedItems();
        
        //Se tem algum roupa selecionado na tabela
        if(roupaSelecionado != null){
            
            //Habilita o Tab de roupa
            ativarTab(tabRoupa, true);
                        
            //Seleciona automaticamente o Tab de roupa
            selecionarTab(tabRoupa);
                        
           
            
        }else{
            AlertaUtil.mensagemErro("Selecione uma roupa primeiro.");
        
        }}

    @FXML
    private void pesquisarClientePeloNome(ActionEvent event) {
        
        
        //Limpar os dados da tabela cliente
        dadosTabelaCliente.clear();
        
        //Pegando o nome que o usuario deseja pesquisar
        String nome = textFieldNome.getText();
        
        
        //Solicitando a camada de servico a lista de clientes pelo nome
        List<Cliente> cliente = clienteServico.buscarPeloNome(nome);
        
        //Transformar a lista de clientes no formato que a tabela
        //do JavaFX aceita
        dadosTabelaCliente = FXCollections.observableArrayList(cliente);
        
        //Jogando os dados na tabela
        tabelaCliente.setItems(dadosTabelaCliente);     
    }

    @FXML
    private void pesquisarRoupaPeloNome(ActionEvent event) {            
         
        //Limpar os dados da tabela cliente
        dadosTabelaRoupa.clear();
        
        //Pegando o nome que o usuario deseja pesquisar
        String nome = textFieldRoupa.getText();
        
        
        //Solicitando a camada de servico a lista de roupas pelo nome
        List<Roupa> roupa = roupaServico.buscarPelaRoupa(nome);
        
        //Transformar a lista de clientes no formato que a tabela
        //do JavaFX aceita
        dadosTabelaRoupa = FXCollections.observableArrayList(roupa);
        
        //Jogando os dados na tabela
      tabelaRoupaAluguel.setItems(dadosTabelaRoupa);
        
        
        
    }
        
        
    /**
     * Método para selecionar uma Tab
     * no Tab Pane dessa janela
     *  
     */
    private void selecionarTab(Tab tab) {
        tabPaneAluguel.getSelectionModel().select(tab);
    }
    
    /**
     * Método para ativar ou desativar uma tab
     */
    private void ativarTab(Tab tab, boolean ativar){
        tab.setDisable(!ativar);
    }

    /**
     * Esse método é chamado toda vez que um tab é seleciconado
     * Aqui ele vai limpar os dados das tabelas
     */
    private void mudouDeTab(Event event) {
        
        dadosTabelaCliente.clear();
        dadosTabelaRoupa.clear();
        dadosTabelaAluguel.clear();
        
    }
    
}

   

    


 