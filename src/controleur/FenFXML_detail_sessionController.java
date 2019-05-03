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
import modele.*;

/**
 * FXML Controller class
 *
 * @author Rabelais
 */
public class FenFXML_detail_sessionController implements Initializable {

    private Session laSession;
    
    @FXML
    Label
    txtLib, txtDate, txtNBplace, txtNBinscrits, txtNBabsents, txtTaux, txtRevient, txtCA, txtMarge, txtDiplomante;      
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        laSession.setLesAbsents(GestionSql.listeAbsents(laSession.getId()));
        laSession.setLesPresents(GestionSql.listePresents(laSession.getId()));
        
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
        txtRevient.setText(String.valueOf(laSession.getCout()));
        txtTaux.setText(String.valueOf(laSession.getTaux()));
        //txtCA.setText(String.valueOf(150.00));
        //txtMarge.setText(String.valueOf(laSession.getMarge()));
        txtDiplomante.setText(String.valueOf(laSession.getDiplomante()));
        txtNBabsents.setText(String.valueOf(laSession.getNbAbsents()));
    }
    
    public void getNbAbsent()
    {
    }
}
