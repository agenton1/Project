/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import Vue.accueil;
import Modele.Connexion;
import java.awt.event.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Fenetre extends JFrame implements ActionListener, ItemListener {

    /*
     * Attribut privés : objets de Connexion, AWT et Swing
     * 
     */

    Connexion maconnexion ;
    
    
    /**
     * Constructeur qui initialise tous les objets graphiques de la fenetre
     */
   
    
    
    public Fenetre(boolean visi) throws SQLException, ClassNotFoundException {
        
        accueil acceuilframe = new accueil();
        acceuilframe.setVisible(visi);
        this.maconnexion = new Connexion("project","root","root");
    }
    
   
    /**
     * Méthode privée qui initialise la liste des tables
     */
    public boolean veri(String username,String password) throws SQLException
    {
        return maconnexion.verif(username, password);
    }
    
     public boolean veriE(String password,String username) throws SQLException
    {
        return maconnexion.verifE(password, username);
    }
    
    public void insc(int id,String mail, String prenom, String nom, String password, int age, double reduc, String CardNo, int CVC, int balance) throws SQLException
    {
        maconnexion.inscr(id,mail,prenom,nom,password,age,reduc,CardNo,CVC,balance);
    }
    
    public void inscE(int id,String mail, String password) throws SQLException
    {
        maconnexion.inscrE(id,mail,password);
    }
    
    public int Film(JLabel titre, JLabel time, JLabel genre, JLabel img, int id) throws SQLException
    {
        maconnexion.Film(titre, time, genre, img,id);
        return id;
    }
    
    public void FilmInfo(JLabel titre,JLabel real, JLabel Seance1, JLabel Seance2, JLabel Seance3, JLabel time, JLabel genre, JLabel img, int id) throws SQLException
    {
        maconnexion.FilmInfo(titre, real, Seance1, Seance2, Seance3, time, genre, img, id);
       
    }
   
    public double res(JLabel place1, JLabel place2, JLabel place3, JLabel prix, int id) throws SQLException
    {
        
        return maconnexion.res(place1, place2, place3, prix, id);
    }
    
    public double prixm(String username) throws SQLException
    {
        return maconnexion.Prixmembre(username);
    }
    
     public void Recap(JLabel titre,JLabel real, JLabel time, JLabel genre, JLabel img, int id) throws SQLException
     {
         maconnexion.Recap(titre, real, time, genre, img, id);
     }
     
     public boolean vcard(String username, String CardNo, int CVC) throws SQLException
     {
         return maconnexion.vcard(username, CardNo, CVC);
     }
     
      public double balance(String username) throws SQLException
      {
          return maconnexion.balance(username);
        
      }
      
      public void Ticket(int id, String u, int idmo, double price, String seance) throws SQLException
      {
          maconnexion.Ticket(id, u, idmo, price, seance);
      }
      
    
      public void affTicket(JLabel idme, JLabel idmo, JLabel price, JLabel seance, int i) throws SQLException
      {
          maconnexion.affTicket(idme, idmo, price, seance, i);
      }   

      public void updatePrice(double prix, String username) throws SQLException
      {
          maconnexion.updatePrice(prix,username);
      }
      
      public void updateplaces(int place,int id,int nb) throws SQLException
      {
        maconnexion.updateplaces(place,id,nb);
      }
      
      public void ajoutbal(double i,String u) throws SQLException
      {
        maconnexion.ajoutbal(i, u);
      }
      
      public void MAJFilm(String titre, int time, String real, String genre, String seance1, String img,String seance2, String seance3, double prix, int PlacesR1, int PlacesR2, int PlacesR3, int id) throws SQLException, FileNotFoundException
      {
          maconnexion.MAJFilm(img, time, real, genre, seance1, titre, seance2, seance3, prix, PlacesR1, PlacesR2, PlacesR3, id);
      }
    
  @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void itemStateChanged(ItemEvent evt) {
        // sélection d'une requete et afficher ses résultats
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

    


   
    


