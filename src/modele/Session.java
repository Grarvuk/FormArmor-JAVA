/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Date;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Philippe
 */
public class Session
{
    private int id;
    private String libelle,niveau, diplomante;
    private Date date_debut;
    private int nb_places, nb_inscrits, Closes;
    
    
    private ObservableList<Client> lesAbsents;
    private ObservableList<Client> lesPresents;
    
    private double taux, cout, ca, marge;
    

    public Session(int id, boolean boolDiplomante, String libelle, String niveau, Date date_debut, int nb_places, int nb_inscrits, int Closes) {
        this.id = id;
        this.libelle = libelle;
        this.niveau = niveau;
        this.date_debut = date_debut;
        this.nb_places = nb_places;
        this.nb_inscrits = nb_inscrits;
        this.Closes = Closes;
        
        if(boolDiplomante)
        {
            diplomante = "oui";
        }
        else
        {
            diplomante = "non";
        }
        
        ca = 150;
    }

    public String getDiplomante()
    {
        return diplomante;
    }

    public void setDiplomante(String pDiplomante)
    {
        this.diplomante = pDiplomante;
    }

    
    
    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    
   public int getCloses() {
        return Closes;
    }

    public void setCloses(int Closes) {
        this.Closes = Closes;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }


    public Date getDate_debut()
    {
        return date_debut;
    }
    public void setDate_debut(Date date_debut)
    {
        this.date_debut = date_debut;
    }

    public int getNb_places()
    {
        return nb_places;
    }
    public void setNb_places(int nb_places)
    {
        this.nb_places = nb_places;
    }

    public int getNb_inscrits()
    {
        return 2;
    }
    public void setNb_inscrits(int nb_inscrits)
    {
        this.nb_inscrits = nb_inscrits;
    }

    @Override
    public String toString()
    {
        return "id : " + getId() + "\nLibelle : " + getLibelle() + "\nDate : " + getDate_debut() + "\nNombre d'inscris : " + getNb_inscrits() + "\nNombre de places : " + getNb_places(); //To change body of generated methods, choose Tools | Templates.
    }

    
    public ObservableList<Client> getLesAbsents()
    {
        return lesAbsents;
    }

    public void setLesAbsents(ObservableList<Client> pLesAbsents)
    {
        
        this.lesAbsents = pLesAbsents;
    }

    public int getNbAbsents()
    {
        return (lesAbsents.size());
    }
    
    public ObservableList<Client> getLesPresents()
    {
        return lesPresents;
    }

    public void setLesPresents(ObservableList<Client> pLesPresents)
    {
        this.lesPresents = pLesPresents;
    }


    public double getTaux()
    {
        return taux;
    }

    public void setTaux(double pTaux)
    {
        this.taux = pTaux;
    }

    public double getCout()
    {
        return cout;
    }

    public void setCout(double pCout)
    {
        this.cout = pCout;
    }

    public double getCa()
    {
        return ca;
    }

    public void setCa(double pCa)
    {
        this.ca = pCa;
    }

    public double getMarge()
    {
    return marge;
    }

    public void setMarge(double pMarge)
    {
        this.marge = pMarge;
    }
    

    
    
}
