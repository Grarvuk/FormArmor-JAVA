/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author morga
 */
public class AccueilController implements Initializable {
 Stage StageSport,stageqq;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     
    @FXML
    public void handleAjoutInscription()
    {
        try
        {
            StageSport= new Stage();
            StageSport.setTitle("Gérer les inscriptions");
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FenFXML_Inscription.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            StageSport.setScene(scene);
            StageSport.show();
        }
        catch (IOException e)
        {
            System.out.println("Erreur chargement seconde fenetre : " + e.getMessage());
        }
    }
    
    @FXML
    public void HandleListedesSession()
    {
        try
        {
           stageqq= new Stage();
            stageqq.setTitle(" Ajouter Un sport a une salle");
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/ListedesSession.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
           stageqq.setScene(scene);
            stageqq.show();
        }
        catch (IOException e)
        {
            System.out.println("Erreur chargement seconde fenetre : " + e.getMessage());
        }
    }
}
