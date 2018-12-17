/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.*;

/**
 * FXML Controller class
 *
 * @author morga
 */
public class ListedesSessionController implements Initializable {
    @FXML
  private TableView<Session> tableSessionsAutorisees;
    @FXML
    private TableColumn<Session, String> colonneId;
    @FXML
    private TableColumn<Session, String> colonneNomFormation;
    @FXML
    private TableColumn<Session, String> colonneDate_debut;
    @FXML
    private TableColumn<Session, String> colonneNb_places;
    @FXML
    private TableColumn<Session, String> colonneNb_inscrits;
    @FXML
    private TableColumn<Session, String> colonneClose;
    @FXML
    private Button buttonGenerer;
    private String test;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      tableSessionsAutorisees.setItems(GestionSql.getLesSessions());
      
       colonneId.setCellValueFactory(new PropertyValueFactory<Session, String>("id"));
       
       colonneNomFormation.setCellValueFactory(new PropertyValueFactory<Session, String>("libelle"));
       
        colonneDate_debut.setCellValueFactory(new PropertyValueFactory<Session, String>("date_debut"));
        
        colonneNb_places.setCellValueFactory(new PropertyValueFactory<Session, String>("nb_places"));
        
        colonneNb_inscrits.setCellValueFactory(new PropertyValueFactory<Session, String>("nb_inscrits"));
        
        colonneClose.setCellValueFactory(new PropertyValueFactory<Session, String>("Closes"));
        
          tableSessionsAutorisees.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);       
    }    
    
}
