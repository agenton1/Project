/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import Vue.accueil;
import Modele.Connexion;
import java.awt.event.*;
import java.awt.*;
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
    
    private final JLabel tab, req, res, lignes;
    private final JLabel nameBDD, requeteLabel;
    private final JTextField requeteTexte, nameBDDTexte;
    private JButton bouton;
    private final java.awt.List listeDeTables, listeDeRequetes;
    private final JTextArea fenetreLignes, fenetreRes;
    private final JPanel p0, p1, nord, p2, p3;
   
    
    
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
    
    public void insc(int id,String mail, String prenom, String nom, String password, int age, double reduc) throws SQLException
    {
        maconnexion.inscr(id,mail,prenom,nom,password,age,reduc);
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

    


   
    


