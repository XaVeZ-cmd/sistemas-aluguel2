/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.cliente;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class ClienteController implements Initializable {

    @FXML
    private JFXTextField textfieldNome;
    @FXML
    private TableColumn<?, ?> ColNome;
    @FXML
    private JFXTextField textFieldEmail;
    @FXML
    private TableColumn<?, ?> colNumeroCliente;
    @FXML
    private TableColumn<?, ?> ColCpf;
    @FXML
    private JFXTextField textFieldNumeroCliente;
    @FXML
    private JFXTextField textFieldCpf;
    @FXML
    private JFXTextField textFieldRg;
    @FXML
    private JFXTextField textFieldDataDeNascimento;
    @FXML
    private JFXTextField textFieldRua;
    @FXML
    private JFXTextField textFieldNumeroRua;
    @FXML
    private JFXTextField textFieldBairro;
    @FXML
    private JFXTextField textFieldCidade;
    @FXML
    private JFXTextField textFieldTelefone1;
    @FXML
    private JFXTextField textFieldTelefone2;
    @FXML
    private TableView<?> tabelaCliente;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salvar(ActionEvent event) {
    }

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void excluir(ActionEvent event) {
    }

    
}
