/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.roupa;

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
public class RoupaController implements Initializable {

    @FXML
    private JFXTextField textFieldNumeroDaRoupa;
    @FXML
    private JFXTextField textFieldTipoDaRoupa;
    @FXML
    private JFXTextField textFieldCor;
    @FXML
    private JFXTextField textFieldTamanho;
    @FXML
    private JFXTextField TextFieldGenero;
    @FXML
    private TableColumn colNumeroDaRoupa;
    @FXML
    private TableColumn colTipoDaRoupa;
    @FXML
    private TableColumn colCor;
    @FXML
    private TableView<?> tabelaRoupa;

   

    /**
     * Initializes the controller class.
     * @param url
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
