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
    public Fenetre(JButton b)
    {
        bouton=b;
        bouton.addActionListener(this);
        
    }
    
    
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
   
    

    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        // tester cas de la commande evenementielle
     
    
        if(evt.getSource() == bouton)
        {
            System.out.println(bouton+"pressed");
            
        }
        
    }

        

  @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void itemStateChanged(ItemEvent evt) {
        // sélection d'une requete et afficher ses résultats
    }

}

    


   
    


