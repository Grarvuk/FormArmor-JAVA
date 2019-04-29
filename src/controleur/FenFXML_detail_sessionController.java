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
import javafx.scene.control.Label;
import modele.Session;

/**
 * FXML Controller class
 *
 * @author Rabelais
 */
public class FenFXML_detail_sessionController implements Initializable {

    private Session laSession;
    
    @FXML
    Label
    txtLib, txtDate, txtNBplace, txtNBinscrits, txtNBabsents, txtTaux, txtRevient, txtCA, txtMarge;      
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        remplirGrid();
    }   

    public FenFXML_detail_sessionController(Session pLaSession)
    {
        this.laSession = pLaSession;
    }

    public Session getLaSession()
    {
        return laSession;
    }

    public void setLaSession(Session pLaSession)
    {
        this.laSession = pLaSession;
    }

    public void remplirGrid()
    {
        txtLib.setText(laSession.getLibelle());
        txtDate.setText(String.valueOf(laSession.getDate_debut()));
        
        txtNBinscrits.setText(String.valueOf(laSession.getNb_inscrits()));
        txtNBplace.setText(String.valueOf(laSession.getNb_places()));
        
        /*
        txtRevient.setText("rien");
        txtTaux.setText("rien");
        
        txtCA.setText("rien");
        txtMarge.setText("rien");
        txtNBabsents.setText("rien");
        */
        
    }
}
