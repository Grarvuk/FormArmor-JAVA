/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modele.Client;
import modele.GestionSql;
import modele.Session;

/**
 * FXML Controller class
 *
 * @author Rabelais
 */
public class gestionRentabilite implements Initializable {

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
    
    Session precedentSession;
    
    Stage StageSport,stageqq;
    
    private final String Chemin=System.getProperty("user.home") + "\\Documents\\pdf\\pdfSession.pdf";     
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        buttonGenerer.setDisable(true);
        buttonGenerer.setVisible(false);
        
        System.out.println("chemin : " + Chemin);
        
      tableSessionsAutorisees.setItems(GestionSql.getLesSessionsInverses());
      
       colonneId.setCellValueFactory(new PropertyValueFactory<Session, String>("id"));
       
       colonneNomFormation.setCellValueFactory(new PropertyValueFactory<Session, String>("libelle"));
       
        colonneDate_debut.setCellValueFactory(new PropertyValueFactory<Session, String>("date_debut"));
        
        colonneNb_places.setCellValueFactory(new PropertyValueFactory<Session, String>("nb_places"));
        
        colonneNb_inscrits.setCellValueFactory(new PropertyValueFactory<Session, String>("nb_inscrits"));
        
        colonneClose.setCellValueFactory(new PropertyValueFactory<Session, String>("Closes"));
        
          tableSessionsAutorisees.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);     

       tableSessionsAutorisees.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Session>()
        {
            
            @Override
            public void changed(ObservableValue<? extends Session> observable, Session oldValue, Session newValue)
            {
                
                
            }
        });
    }   


    public void doubleClick()
    {
        if(tableSessionsAutorisees.getSelectionModel().getSelectedItem()==precedentSession)
        {
            HandleDetailSession();
        }           
        precedentSession=(Session) tableSessionsAutorisees.getSelectionModel().getSelectedItem();
    }
    
    
    
    
  public static PdfPTable premierTableau(int id) throws DocumentException
  {
       
      
      //On créer un objet table dans lequel on intialise ça taille.
      PdfPTable table = new PdfPTable(7);
 
       table.setWidthPercentage(100);
       table.addCell("id");       
      table.addCell("Nom");       
      table.addCell("Adresse");       
      table.addCell("Code Postal");       
      table.addCell("Ville");       
      table.addCell("email"); 
      table.addCell("Signature");
      
      ArrayList<Client> LesClients = GestionSql.getLaSessions(id);
     
       for(int i=0;i<LesClients.size();i++)
       {
           String lid=Integer.toString(LesClients.get(i).getId());        
      table.addCell(lid);
      table.addCell(LesClients.get(i).getNom());       
      table.addCell(LesClients.get(i).getAdresse());       
      table.addCell(LesClients.get(i).getCp());       
      table.addCell(LesClients.get(i).getVille());       
      table.addCell(LesClients.get(i).getEmail()); 
      table.addCell("");
           
       }
      
      return table;  
  }
    
    
    
    public void HandlePdf() throws IOException
    {
        
         
   
         File file = new File(System.getProperty("user.home") + "\\Documents\\pdf\\pdfSession.pdf");
         if(file.exists())
         {
             file.delete();
             Session LaSession=(Session) tableSessionsAutorisees.getSelectionModel().getSelectedItem();
           Document document = new Document();
        try 
        {
          PdfWriter.getInstance(document, new FileOutputStream(Chemin));
          document.open();

          document.add(new Paragraph("La session : "+LaSession.getLibelle()+"/"+LaSession.getNiveau()+" "+"Date Debut :"+LaSession.getDate_debut()));
          document.add(new Paragraph("\n\n"));
          document.add(premierTableau(LaSession.getId()));

        } catch (DocumentException de) {
         
        } catch (IOException ioe) {
        }

        document.close();
        Desktop.getDesktop().open(new File(System.getProperty("user.home") + "\\Documents\\pdf\\pdfSession.pdf")); 
         }else{
             
            Session LaSession=(Session) tableSessionsAutorisees.getSelectionModel().getSelectedItem();
           Document document = new Document();
        try 
        {
          PdfWriter.getInstance(document, new FileOutputStream(Chemin));
          document.open();

          document.add(new Paragraph("La session : "+LaSession.getLibelle()+"/"+LaSession.getNiveau()+" "+"Date Debut :"+LaSession.getDate_debut()));
          document.add(new Paragraph("\n\n"));
          document.add(premierTableau(LaSession.getId()));

        } catch (DocumentException de) {
         
        } catch (IOException ioe) {
        }

        document.close();
        Desktop.getDesktop().open(new File(System.getProperty("user.home") + "\\Documents\\pdf\\pdfSession.pdf")); 
             
         }

    }
    
    public void HandleDetailSession()
    {
        try
        {
            int idSession = precedentSession.getId();
            
            stageqq = new Stage();
            stageqq.setTitle("Détail de la session");
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FenFXML_detail_session.fxml"));
            
            FenFXML_detail_sessionController controller = new FenFXML_detail_sessionController(precedentSession);
            
            loader.setController(controller);
            
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
