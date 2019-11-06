/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.aluguel;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class AluguelController implements Initializable {

    @FXML
    private JFXTextField textFieldNumeroDoAluguel;
    @FXML
    private JFXTextField textFieldDataDeNascimento;
    @FXML
    private JFXTextField textFieldDataDevolucao;
    @FXML
    private JFXTextField textFieldCliente;
    @FXML
    private JFXTextField textFieldValor;

    /**
     * Initializes the controller class.
     */
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
