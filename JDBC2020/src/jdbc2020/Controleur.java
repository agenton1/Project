/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

import java.sql.*;

/**
 *
 * Contrôle l'interrogation de la BDD dans la Fenetre
 *
 * @author segado
 */
public class Controleur {

    /**
     *
     * une methode principal (main) pour lancer l'application
     *
     * @param s
     */
    public static void main(String[] s) throws SQLException, ClassNotFoundException {
        // creation de la fenetre
        Fenetre f = new Fenetre();
        Connexion C = new Connexion("test","root","root");
        
    }
}
