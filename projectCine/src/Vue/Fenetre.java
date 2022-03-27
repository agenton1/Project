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
    private final JButton exec, local;
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
    

    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        // tester cas de la commande evenementielle
        if (source == local) {
            ArrayList<String> liste;
            try {
                try {
                    // tentative de connexion si les 4 attributs sont remplis
                    //maconnexion = new Connexion("jps", "root", "");
                    maconnexion = new Connexion(nameBDDTexte.getText(), "root", "root");

                    veri(null,null);
                    

                    // afficher les résultats de la requete selectionnee
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Connexion echouee : probleme de classe");
                    cnfe.printStackTrace();
                }
            } catch (SQLException e) {
                System.out.println("Connexion echouee : probleme SQL");
                e.printStackTrace();
            }
        } else if (source == exec) {
            String requeteSelectionnee = requeteTexte.getText(); // récupérer le texte de la requête

            // effacer les résultats
            fenetreRes.removeAll();

            }

        }

  @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void itemStateChanged(ItemEvent evt) {
        // sélection d'une requete et afficher ses résultats
    }

}

    


   
    


