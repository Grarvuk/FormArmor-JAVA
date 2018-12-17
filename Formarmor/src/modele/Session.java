/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Date;

/**
 *
 * @author Philippe
 */
public class Session
{
    private int id;
    private String libelle;
    private Date date_debut;
    private int nb_places, nb_inscrits,Closes;

 
    public Session(int id, String libelle, Date date_debut, int nb_places, int nb_inscrits, int Closes) {
        this.id = id;
        this.libelle = libelle;
        this.date_debut = date_debut;
        this.nb_places = nb_places;
        this.nb_inscrits = nb_inscrits;
        this.Closes = Closes;
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
        return nb_inscrits;
    }
    public void setNb_inscrits(int nb_inscrits)
    {
        this.nb_inscrits = nb_inscrits;
    }
}
