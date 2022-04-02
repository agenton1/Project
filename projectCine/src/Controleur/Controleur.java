/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controleur;

import Vue.Fenetre;
import Modele.Connexion;
import java.sql.SQLException;

/**
 *
 * @author arthur
 */
public class Controleur {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        //création des objets necéssaires au fonctionnement du programmme
        
        //Initialisation de la connexion à la bdd
        Connexion C = new Connexion("project", "root", "root");
        //Initialisation de la Fenetre d'affichage
        Fenetre F = new Fenetre(true);

    }

}
