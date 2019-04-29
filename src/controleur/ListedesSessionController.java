/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.*;

/**
 * FXML Controller class
 *
 * @author morgaf
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
    
    private final String Chemin=System.getProperty("user.home") + "\\Documents\\pdf\\pdfSession.pdf";
    
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        System.out.println("chemin : " + Chemin);
        
      tableSessionsAutorisees.setItems(GestionSql.getLesSessions());
      
       colonneId.setCellValueFactory(new PropertyValueFactory<Session, String>("id"));
       
       colonneNomFormation.setCellValueFactory(new PropertyValueFactory<Session, String>("libelle"));
       
        colonneDate_debut.setCellValueFactory(new PropertyValueFactory<Session, String>("date_debut"));
        
        colonneNb_places.setCellValueFactory(new PropertyValueFactory<Session, String>("nb_places"));
        
        colonneNb_inscrits.setCellValueFactory(new PropertyValueFactory<Session, String>("nb_inscrits"));
        
        colonneClose.setCellValueFactory(new PropertyValueFactory<Session, String>("Closes"));
        
          tableSessionsAutorisees.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);       
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

    
    }
