/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectcine;

import java.sql.SQLException;

/**
 *
 * @author arthur
 */
public class Controleur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Fenetre F = new Fenetre();
         Connexion C = new Connexion("test","root","root");
        // TODO code application logic here
    }
    
}
