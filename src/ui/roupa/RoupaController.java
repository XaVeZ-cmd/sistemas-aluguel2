/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.roupa;


import Dados.Entidades.Roupa;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import servicos.RoupaServicos;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class RoupaController implements Initializable {

  
    @FXML
    private JFXTextField textFieldTipoDaRoupa;
    @FXML
    private JFXTextField textFieldCor;
    @FXML
    private JFXTextField textFieldTamanho;
    @FXML
    private JFXTextField TextFieldGenero;
    @FXML
    private TableColumn colTipoDaRoupa;
    @FXML
    private TableColumn colCor;
    @FXML
    private TableView<Roupa> tabelaRoupa;

  
    @FXML
    private JFXTextField textFieldIdRoupa;
    @FXML
    private TextArea textFieldCaracteristica;
    @FXML
    private TableColumn colIdRoupa;
    private Roupa selecionado;
    
    //atributo para representar serviço
    private final RoupaServicos servico = new RoupaServicos();
    
    //Atributo que representa os dados para tabela
    //import javafx.collections.FXCollections;
    //import javafx.collections.ObservableList;
    private ObservableList<Roupa> dados
            = FXCollections.observableArrayList();

    /**
     * Initializes the controller class. Tudo que é feito ao inicializar a
     * Janela
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          // TODO
        
        //configure a tabela
        
       configurarTabelaRoupa();
        
        // configure a lista de roupa
      listarRoupaTabela();  
                       

       
    }

    @FXML
    private void salvar(ActionEvent event) {
        
            //Verificar se está atualizando ou inserindo
        if(textFieldIdRoupa.getText().isEmpty()){ //inserindo
            //Pega os dados do fomulário
            //e cria um objeto roupa
            Roupa a = new Roupa(textFieldTipoDaRoupa.getText(),textFieldCor.getText(),
                    textFieldTamanho.getText(),textFieldCaracteristica.getText(),
                    TextFieldGenero.getText());
                  

            //Mandar a roupa para a camada de servico
            servico.salvar(a);
            
            //Exibindo mensagem
            mensagemSucesso("Roupa salvo com sucesso!");
            
            //Chama o metodo para atualizar a tabela
            listarRoupaTabela();
            
        }else{ //atualizando o roupa
           
            //Pegando a resposta da confirmacao do usuario
           Optional<ButtonType> btn = 
               mensagemDeConfirmacao("Deseja mesmo salvar as alterações?",
                     "EDITAR");
            
            //Se o botão OK foi pressionado
            if(btn.get() == ButtonType.OK){
                //Pegar os novos dados do formulário e
                //atualizar o meu roupa
                selecionado.setTipoRoupa(textFieldTipoDaRoupa.getText());
                selecionado.setCor(textFieldCor.getText());
                selecionado.setTamanho(textFieldTamanho.getText());
                selecionado.setDetalhes(textFieldCaracteristica.getText());
                selecionado.setGenero(TextFieldGenero.getText());
                
                
                //Mandando pra camada de serviço salvar as alterações
                servico.editar(selecionado);
                
                //Exibindo mensagem
                mensagemSucesso("Cliente atualizado com sucesso!"); 
                
                //Chama o metodo para atualizar a tabela
                 listarRoupaTabela();
            }
            
        }

        
        //Limpando o form
        textFieldIdRoupa.setText("");
         textFieldTipoDaRoupa.setText("");
        
            textFieldCor.setText("");
            textFieldTamanho.setText("");
            textFieldCaracteristica.setText("");
            TextFieldGenero.setText("");
          
        
    }

    public void mensagemSucesso(String m) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("SUCESSO!");
        alerta.setHeaderText(null);
        alerta.setContentText(m);
        alerta.showAndWait();
    }
    
    /**
     * Exibe uma mensagem de erro
     * @param m 
     */
    public void mensagemErro(String m) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("ERRO!");
        alerta.setHeaderText(null);
        alerta.setContentText(m);
        alerta.showAndWait();
    }

    /**
     * Fazendo configuração das colunas da tabeça
     */
    private void configurarTabelaRoupa() {

        //Dizer de onde a coluna vai pegar o valor para
        //exibir, basta dizer o nome do metodo get
        //que deve ser chamado para cada coluna
        // A string entre parênteses é o nome do atributo
        // que vc deseja chamar o get (quase sempre)
        //import javafx.scene.control.cell.PropertyValueFactory;
       colIdRoupa.setCellValueFactory(
                new PropertyValueFactory("idRoupa"));
       colTipoDaRoupa.setCellValueFactory(
                new PropertyValueFactory("tipoRoupa"));
       colCor.setCellValueFactory(
               new PropertyValueFactory("cor"));
              

    }//configurarTabela

    /**
     * Responsável por carregar a lista de roupas na tabela
     */
    private void listarRoupaTabela() {
        //Limpando quaisquer dados anteriores
        dados.clear();

        //Solicitando a camada de servico a lista de roupas
        List<Roupa> Roupa = servico.listar();

        //Transformar a lista de roupas no formato que a tabela
        //do JavaFX aceita
        dados = FXCollections.observableArrayList(Roupa);

        //Jogando os dados na tabela
        tabelaRoupa.setItems(dados);

        
        
    }

        
    
    @FXML
    private void editar(ActionEvent event) {
         //Pegar o roupa que foi selecionado na tabela
        selecionado = tabelaRoupa.getSelectionModel()
                .getSelectedItem();

        //Se tem algum roupa selecionado
        if (selecionado != null) { //tem clienteonado
            //Pegar os dados do roupa e jogar nos campos do
            //formulario
            textFieldIdRoupa.setText(
                    String.valueOf( selecionado.getIdRoupa() ) );
           
            
            textFieldTipoDaRoupa.setText(selecionado.getTipoRoupa());
                    textFieldCor.setText(selecionado.getCor());
                    textFieldTamanho.setText(selecionado.getTamanho());
                    textFieldCaracteristica.setText(selecionado.getDetalhes());
                    TextFieldGenero.setText(selecionado.getGenero());
          
            
            
        }else{ //não tem roupa selecionado na tabela
            mensagemErro("Selecione um cliente.");
        }

    }
    
    /**
     * Mostra uma caixa com uma mensagem de confirmação
     * onde a pessoa vai poder responder se deseja realizar
     * uma ação
     */
    private Optional<ButtonType> mensagemDeConfirmacao(
            String mensagem, String titulo) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        return alert.showAndWait();


    }

    @FXML
    private void excluir(ActionEvent event) {
        
         //Pegar o roupa que foi selecionado na tabela
        selecionado = tabelaRoupa.getSelectionModel()
                .getSelectedItem();
        
        //Verifico se tem cliente selecionado
        if(selecionado != null){ //existe roupa selecionado
            
            //Pegando a resposta da confirmacao do usuario
            Optional<ButtonType> btn = 
                mensagemDeConfirmacao("Deseja mesmo excluir?",
                      "EXCLUIR");
            
            //Verificando se apertou o OK
            if(btn.get() == ButtonType.OK){
                
                //Manda para a camada de serviço excluir
                servico.excluir(selecionado);
                
                //mostrar mensagem de sucesso
                mensagemSucesso("Roupa excluído com sucesso");
                
                //Atualizar a tabela
                listarRoupaTabela();  
    }
        }}}

 