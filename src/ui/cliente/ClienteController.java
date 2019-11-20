
package ui.cliente;

import Dados.Entidades.Cliente;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.control.cell.PropertyValueFactory;
import servicos.ClienteServicos;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class ClienteController implements Initializable {

    @FXML
    private JFXTextField textfieldNome;
    @FXML
    private TableColumn ColNome;
    @FXML
    private JFXTextField textFieldEmail;
    @FXML
    private TableColumn colNumeroCliente;
    @FXML
    private TableColumn ColCpf;
    @FXML
    private JFXTextField textFieldNumeroCliente;
    @FXML
    private JFXTextField textFieldCpf;
    @FXML
    private JFXTextField textFieldRg;
    @FXML
    private JFXDatePicker textFieldDataDeNascimento;
    @FXML
    private JFXTextField textFieldRua;
    
    @FXML
    private JFXTextField textFieldBairro;
    @FXML
    private JFXTextField textFieldCidade;
    @FXML
    private JFXTextField textFieldTelefone1;
    @FXML
    private JFXTextField textFieldTelefone2;
    @FXML
    private TableView<Cliente> tabelaCliente;

   //atributo para representar serviço
    private final ClienteServicos servico = new ClienteServicos();
    
    //Atributo que representa os dados para tabela
    //import javafx.collections.FXCollections;
    //import javafx.collections.ObservableList;
    private ObservableList<Cliente> dados
            = FXCollections.observableArrayList();
    
    //Atributo que vai armazenar qual o cliente 
    //foi selecionado na tabela
    private Cliente selecionado;
    @FXML
    private JFXTextField textFieldCep;
    @FXML
    private JFXTextField textFieldNumeroCasa;

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
        
       configurarTabelaCliente();
        
        // configure a lista de cliente
      listarClienteTabela();  
                       
    }   
    @FXML
    private void salvar(ActionEvent event) {     
        
        //Verificar se está atualizando ou inserindo
        if(textFieldNumeroCliente.getText().isEmpty()){ //inserindo
            //Pega os dados do fomulário
            //e cria um objeto cliente
            Cliente a = new Cliente(textfieldNome.getText(),textFieldCpf.getText(),
                    textFieldRg.getText(),textFieldDataDeNascimento.getValue(),
                    textFieldRua.getText(),textFieldNumeroCasa.getText(),
                   textFieldBairro.getText(), textFieldCidade.getText(),
                    textFieldTelefone1.getText(),textFieldTelefone2.getText(),
                    textFieldEmail.getText(),textFieldCep.getText());

            //Mandar o cliente para a camada de servico
            servico.salvar(a);
            
            //Exibindo mensagem
            mensagemSucesso("Cliente salvo com sucesso!");
            
            //Chama o metodo para atualizar a tabela
            listarClienteTabela();
            
        }else{ //atualizando o cliente
           
            //Pegando a resposta da confirmacao do usuario
            Optional<ButtonType> btn = 
                mensagemDeConfirmacao("Deseja mesmo salvar as alterações?",
                      "EDITAR");
            
            //Se o botão OK foi pressionado
            if(btn.get() == ButtonType.OK){
                //Pegar os novos dados do formulário e
                //atualizar o meu cliente
                selecionado.setNome(textfieldNome.getText());
                selecionado.setTelefone1(textFieldTelefone1.getText());
                selecionado.setTelefone2(textFieldTelefone2.getText());
                selecionado.setBairro(textFieldBairro.getText());
                selecionado.setCidade(textFieldCidade.getText());
                selecionado.setCpf(textFieldCpf.getText());
                selecionado.setNumeroCasa(textFieldNumeroCasa.getText());
                selecionado.setCep(textFieldCep.getText());
                selecionado.setEmail(textFieldEmail.getText());
                selecionado.setDataNascimemto(textFieldDataDeNascimento.getValue());
                selecionado.setRg(textFieldRg.getText());
                selecionado.setRua(textFieldRua.getText());
                
                //Mandando pra camada de serviço salvar as alterações
                servico.editar(selecionado);
                
                //Exibindo mensagem
                mensagemSucesso("Cliente atualizado com sucesso!"); 
                
                //Chama o metodo para atualizar a tabela
                 listarClienteTabela();
            }
            
        }

        
        //Limpando o form
        textFieldNumeroCliente.setText("");
         textfieldNome.setText("");
        
            textFieldEmail.setText("");
            textFieldCpf.setText("");
            textFieldRg.setText("");
            textFieldRua.setText("");
            textFieldCidade.setText("");
            textFieldBairro.setText("");
            textFieldNumeroCasa.setText("");
           textFieldDataDeNascimento.setValue(null);
            textFieldTelefone1.setText("");
            textFieldTelefone2.setText("");
            textFieldCep.setText("");
        
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
    private void configurarTabelaCliente() {

        //Dizer de onde a coluna vai pegar o valor para
        //exibir, basta dizer o nome do metodo get
        //que deve ser chamado para cada coluna
        // A string entre parênteses é o nome do atributo
        // que vc deseja chamar o get (quase sempre)
        //import javafx.scene.control.cell.PropertyValueFactory;
       colNumeroCliente.setCellValueFactory(
                new PropertyValueFactory("idCliente"));
       ColNome.setCellValueFactory(
                new PropertyValueFactory("nome"));
       ColCpf.setCellValueFactory(
               new PropertyValueFactory("cpf"));
              

    }//configurarTabela

    /**
     * Responsável por carregar a lista de clientes na tabela
     */
    private void listarClienteTabela() {
        //Limpando quaisquer dados anteriores
        dados.clear();

        //Solicitando a camada de servico a lista de clientes
        List<Cliente> clientes = servico.listar();

        //Transformar a lista de clientes no formato que a tabela
        //do JavaFX aceita
        dados = FXCollections.observableArrayList(clientes);

        //Jogando os dados na tabela
        tabelaCliente.setItems(dados);

        
        
    }

    @FXML
    private void editar(ActionEvent event) {
        
        //Pegar o Cliente que foi selecionado na tabela
        selecionado = tabelaCliente.getSelectionModel()
                .getSelectedItem();

        //Se tem algum cliente selecionado
        if (selecionado != null) { //tem clienteonado
            //Pegar os dados do cliente e jogar nos campos do
            //formulario
            textFieldNumeroCliente.setText(
                    String.valueOf( selecionado.getIdCliente() ) );
            textfieldNome.setText( selecionado.getNome() ); 
            textFieldEmail.setText(selecionado.getEmail());
            textFieldCpf.setText(selecionado.getCpf());
            textFieldRg.setText(selecionado.getRg());
            textFieldRua.setText(selecionado.getRua());
            textFieldCidade.setText(selecionado.getCidade());
            textFieldBairro.setText(selecionado.getBairro());
            textFieldNumeroCasa.setText(selecionado.getNumeroCasa());
            textFieldDataDeNascimento.setValue(selecionado.getDataNascimemto());
            textFieldTelefone1.setText(selecionado.getTelefone1());
            textFieldTelefone2.setText(selecionado.getTelefone2());
            textFieldCep.setText(selecionado.getCep());
            
            
            
        }else{ //não tem cliente selecionado na tabela
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
        
        
          //Pegar o cliente que foi selecionado na tabela
        selecionado = tabelaCliente.getSelectionModel()
                .getSelectedItem();
        
        //Verifico se tem cliente selecionado
        if(selecionado != null){ //existe cliente selecionado
            
            //Pegando a resposta da confirmacao do usuario
            Optional<ButtonType> btn = 
                mensagemDeConfirmacao("Deseja mesmo excluir?",
                      "EXCLUIR");
            
            //Verificando se apertou o OK
            if(btn.get() == ButtonType.OK){
                
                //Manda para a camada de serviço excluir
                servico.excluir(selecionado);
                
                //mostrar mensagem de sucesso
                mensagemSucesso("cliente excluído com sucesso");
                
                //Atualizar a tabela
                listarClienteTabela();              
                
            }
            
            
            
        }else{
            mensagemErro("Selecione um cliente.");
        }
        
    }

   
  

    
}
