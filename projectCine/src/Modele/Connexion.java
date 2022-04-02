/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author arthur
 */
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * Connexion a votre BDD locale ou à distance sur le serveur localhost via le
 * tunnel SSH
 *
 * @author arthur
 */
public class Connexion {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private final Connection conn;
    private final Statement stmt;
    private ResultSet rset;

    /**
     *
     * /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */

    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"

        String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }

    //méthode permettant de vérifier l'identifiant et mot de passe saisit par le membre lors de sa connexion
    //retourne true si les identifiants saisis sont dans la bdd
    public boolean verif(String username, String password) throws SQLException {
        boolean vf = false;
        //requête permettant de selectionner les données du memebre si les identifiants de la bdd sont égaux à ceux saisis en paramètre
        String sql = "Select * from Member where Mail ='" + username + "'and Password ='" + password + "'";
        //execution de la requête
        rset = stmt.executeQuery(sql);

        if (rset.next()) {
            vf = true;
        }
        //retourner le booléen
        return vf;

    }

    //méthode permettant de mettre à jour le mail et le password d'un membre 
    public void NMember(String username, String Nusername, String Npassword) throws SQLException {
        //requête sql permettant de mettre à jour le mail et le password d'un membre 
        String sql = "Update Member set Mail = '" + Nusername + "', Password = '" + Npassword + "'where Mail = '" + username + "'";
        //execution de la requête
        stmt.executeUpdate(sql);
    }

    //méthode permettant de vérifier l'identifiant et mot de passe saisit par l'employé lors de sa connexion
    //retourne true si les identifiants saisis sont dans la bdd
    public boolean verifE(String password, String username) throws SQLException {
        boolean vf = false;
        //requête permettant de selectionner les données de l'employé si les identifiants de la bdd sont égaux à ceux saisis en paramètre
        String sql = "Select * from Employee where Password ='" + password + "' and Name ='" + username + "'";
        //execution requête
        rset = stmt.executeQuery(sql);
        if (rset.next()) {
            vf = true;
        }
        //retourner le booléen
        return vf;

    }

    //méthode permettant d'ajouter un nouveau membre à la table Membre dans la bdd 
    public void inscr(int id, String mail, String prenom, String nom, String password, int age, double reduc, String CardNo, int CVC, int balance) throws SQLException {
        //création d'une nouvelle ligne dans la table Membre avec les valeurs rentrées en paramètre
        String sql = "INSERT INTO Member (idMember, Mail, Surname, Name, Password, Age, Reduction, CardNo, CVC, balance) VALUES (" + id + ",'" + mail + "','" + prenom + "','" + nom + "','" + password + "'," + age + "," + reduc + ",'" + CardNo + "'," + CVC + "," + balance + ")";
        //execution requête
        stmt.executeUpdate(sql);

    }

    //méthode permettant d'ajouter un nouvel employé à la table Employee dans la bdd
    public void inscrE(int id, String password, String mail) throws SQLException {
        //création d'une nouvelle ligne dans la table Employee avec les valeurs rentrées en paramètre
        String sql = "INSERT INTO Employee (idEmployee, Password, Name) VALUES (" + id + ",'" + password + "','" + mail + "')";
        //execution de la requête
        stmt.executeUpdate(sql);

    }

    //fonction premettant de créer un nouveau ticket dans la bdd 
    public void Ticket(int id, String u, int idmo, double price, String seance) throws SQLException {
        //création d'une nouvelle ligne dans la table ticket
        String sql = "INSERT INTO Ticket (idTicket, idMember, idMovie, Price, seance) VALUES (" + id + ", (Select idMember from Member where Mail = '" + u + "')," + idmo + "," + price + ",'" + seance + "')";
        //execution requète
        stmt.executeUpdate(sql);
    }

    //fonction permettant d'afficher le ticket 
    public void affTicket(JLabel idme, JLabel idmo, JLabel price, JLabel seance, int i) throws SQLException {
        //requete sql selectionnant toute la ligne du ticket selectionné dans la bdd
        String sql = "Select * from Ticket where idTicket= " + i + "";
        //execution requête
        rset = stmt.executeQuery(sql);

        if (rset.next()) {
            //les jlabel prenne les veleur du ticket selectionné
            idme.setText(rset.getString(2));
            idmo.setText(rset.getString(3));
            price.setText(rset.getString(4) + " €");
            seance.setText(rset.getString(5));
        }
    }

    //fonction permettant de récupérer la réduction du memebre entrée en paramètre
    public double Prixmembre(String username) throws SQLException {
        double pm = 0;
        //requete sql selectionnant la reduction du membre dont le mail est = à la string rentrée en paramètre
        String sql = "Select Reduction from Member where  Mail= '" + username + "'";
        //execution de la requête
        rset = stmt.executeQuery(sql);

        if (rset.next()) {
            pm = rset.getDouble(1);
        }
        return pm;
    }

    //fonction d'affichage de la balance des membres
    public double balance(String username) throws SQLException {
        double pm = 0;
        //requete sql selectionnant la balance du membre dont le mail est = à la string rentrée en paramètre
        String sql = "Select balance from Member where  Mail= '" + username + "'";
        //execution de la requête
        rset = stmt.executeQuery(sql);

        if (rset.next()) {
            //le double prend la valeur de la balance dans la bdd de donnée 
            pm = rset.getDouble(1);
        }

        //retourner cette valeur
        return pm;
    }

    //fonction permetant de verifier les information d'une carte bancaire au moment du payement. Elle renvoit true si les données sont bonnes et false sinon 
    public boolean vcard(String username, String CardNo, int CVC) throws SQLException {
        boolean b = false;
        //requête sql permettant de comparer les données saisies et les données dans la base de données afin de verifier si celles si sont correctes
        String sql = "Select * from Member where  Mail= '" + username + "'and CardNo = '" + CardNo + "'and CVC = " + CVC + "";
        rset = stmt.executeQuery(sql);

        //si la requete trouve une correspondance dans la bdd alors b = true
        if (rset.next()) {
            b = true;
        }
        //retourner b
        return b;
    }

    //fonction permettant d'afficher une selection d'infos d'un film
    public int Film(JLabel titre, JLabel time, JLabel genre, JLabel img, int id) throws SQLException {
        String sql = "Select * from Movie where idMovie = " + id + "";
        rset = stmt.executeQuery(sql);

        if (rset.next()) {
            //association des jlabel et des données sélectionées de le la ligne de la base de données dont l'id est égale à 'id'.    
            titre.setText(rset.getString(2));
            time.setText(rset.getString(3));
            genre.setText(rset.getString(5));

            //process permettant d'afficher une image BLOB sur un Jlabel
            byte[] image = rset.getBytes("Image");
            ImageIcon ima = new ImageIcon(image);
            Image im = ima.getImage();
            Image myImg = im.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon NewImage = new ImageIcon(myImg);
            img.setIcon(NewImage);
            return id;
        }
        return 0;

    }

    //fonction permettant d'afficher toutes les infos d'un film
    public void FilmInfo(JLabel titre, JLabel real, JLabel Seance1, JLabel Seance2, JLabel Seance3, JLabel time, JLabel genre, JLabel img, int id) throws SQLException {
        //requète sql permettant de selecitonné toute la ligne de la table où le l'id correspond à celui passé en paramètre
        String sql = "Select * from Movie where idMovie = " + id + "";
        rset = stmt.executeQuery(sql);

        if (rset.next()) {
            //association des jlabel et des donnée de le la ligne de la base de données donct l'id est égale à 'id'.
            real.setText(rset.getString(4));
            Seance1.setText(rset.getString(6));
            Seance2.setText(rset.getString(8));
            Seance3.setText(rset.getString(9));
            titre.setText(rset.getString(2));
            time.setText(rset.getString(3));
            genre.setText(rset.getString(5));

            //process permettant d'afficher une image BLOB sur un Jlabel
            byte[] image = rset.getBytes("Image");
            ImageIcon ima = new ImageIcon(image);
            Image im = ima.getImage();
            Image myImg = im.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon NewImage = new ImageIcon(myImg);
            img.setIcon(NewImage);
        }
    }

    //fonction permettant d'afficher les séance du film selectionné qui retourn le prix de celle-ci
    public double res(JLabel place1, JLabel place2, JLabel place3, JLabel prix, int id) throws SQLException {
        double p = 0;
        //requète sql permettant de selecitonné toute la ligne de la table où le l'id correspond à celui passé en paramètre
        String sql = "Select * from Movie where idMovie = " + id + "";
        rset = stmt.executeQuery(sql);

        if (rset.next()) {
            //les jlabel affiche les horaires des 3 seances 
            place1.setText(rset.getString(11));
            place2.setText(rset.getString(12));
            place3.setText(rset.getString(13));
            prix.setText(rset.getString(10) + " €");
            //le double créer prend la valeur du prix de la place 
            p = rset.getDouble(10);
        }
        //retour du double 
        return p;
    }

    //fonction permettant d'afficher le recapitulatif du film selectionné par le client
    public void Recap(JLabel titre, JLabel real, JLabel time, JLabel genre, JLabel img, int id) throws SQLException {
        //requète sql permettant de selecitonné toute la ligne de la table où le l'id correspond à celui passé en paramètre
        String sql = "Select * from Movie where idMovie = " + id + "";
        rset = stmt.executeQuery(sql);

        if (rset.next()) {
            //affichage sur les différents jlabel des donnés du film séléctionné    
            real.setText(rset.getString(4));
            titre.setText(rset.getString(2));
            time.setText(rset.getString(3));
            genre.setText(rset.getString(5));

            //process permettant d'afficher une image BLOB sur un Jlabel
            byte[] image = rset.getBytes("Image");
            ImageIcon ima = new ImageIcon(image);
            Image im = ima.getImage();
            Image myImg = im.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon NewImage = new ImageIcon(myImg);
            img.setIcon(NewImage);
        }
    }

    //fonction permettant de mettre à jour la balance du membre en focntion de ce qu'il a depensé en achetant la place de cinema
    public void updatePrice(double prix, String username) throws SQLException {
        //requête sql mettant à jour la balance du membre 'username' en soustrayant à celle ci le prix du ticket de cinema passé en paramètre 
        String sql = "UPDATE Member SET balance = balance-" + prix + " where Mail = '" + username + "'";
        //execution de la requête
        stmt.executeUpdate(sql);

    }

    //fonction permettant de mettre à jour un film à l'affiche par un employé
    public void MAJFilm(String titre, int time, String real, String genre, String seance1, String img, String seance2, String seance3, double prix, int PlacesR1, int PlacesR2, int PlacesR3, int id) throws SQLException, FileNotFoundException {
        //requête sql permttant de modifier un des qutres films et de la remplacé par un nouveau
        String sql = "UPDATE Movie SET  Image =?, Time = " + time + ", Authors = '" + real + "', Genre = '" + genre + "', Seance1 = '" + seance1 + "',Title ='" + titre + "' ,Seance2 = '" + seance2 + "',Seance3 = '" + seance3 + "', Prix = " + prix + ", PlacesRestantes = " + PlacesR1 + ", PlacesRestantes2 = " + PlacesR2 + ", PlacesRestantes3 = " + PlacesR3 + " where idMovie = " + id + ";";
        PreparedStatement stmt2 = conn.prepareStatement(sql);

        //process permettant de charger une image à l'emplacement '?' de la requête et ainsi avoir une nouvelle image associées au nouveau film
        File theFile = new File("/Users/arthur/Downloads/" + img + "");
        FileInputStream input = new FileInputStream(theFile);
        stmt2.setBinaryStream(1, input);
        stmt2.executeUpdate();
    }

    //fonction permetant de mettre à jour le nombre de place restante par seance pour un film dont l'id est passé en paramètre 
    public void updateplaces(int place, int id, int nb) throws SQLException {
        //exection des requête sql mettant à jour la seance selectionné en fonction de entienr place passé en paramètre    
        if (place == 1)//séance 1
        {
            String sql2 = "UPDATE Movie SET PlacesRestantes = PlacesRestantes-1-" + nb + " where idMovie =" + id + "";
            stmt.executeUpdate(sql2);
        }

        if (place == 2)//seance 2
        {
            String sql2 = "UPDATE Movie SET PlacesRestantes2 = PlacesRestantes2-1-" + nb + " where idMovie =" + id + "";
            stmt.executeUpdate(sql2);
        }

        if (place == 3)//seance 3
        {
            String sql2 = "UPDATE Movie SET PlacesRestantes3 = PlacesRestantes3-1-" + nb + " where idMovie =" + id + "";
            stmt.executeUpdate(sql2);
        }
    }

    //fonction permettant au membre de rajouter de l'argent sur sa balance 
    public void ajoutbal(double i, String u) throws SQLException {
        //requête sql permettant de mettre à jour la balance du memebre en fonction de son username/mail
        String sql = "UPDATE Member SET balance = balance + " + i + " where Mail = '" + u + "'";
        //execution de la requête
        stmt.executeUpdate(sql);
    }

    //fonction permettant de récupérer l'offre appliquée par un employé 
    public int RecupOffre(String u, JLabel Offre) throws SQLException {
        int o = 0;
        //requête sql pour récupérer l'offre appliqué par l'employé en fonction de son username
        String sql = "SELECT Offre from Employee where Name = '" + u + "'";
        //execution requete
        rset = stmt.executeQuery(sql);
        if (rset.next()) {
            //affichage de l'offre sur le jlabel Offre
            Offre.setText(rset.getString(1) + " %");
            //l'entier o prend la valeur du resultat de la requête
            o = rset.getInt(1);
        }
        //retourner l'entier
        return o;
    }

    //Fonction premettant d'appliquer une offre en tant qu'employer
    public void Offre(int offre, String u) throws SQLException {
        //requete sql permettant de mettre à jour le prix des seance de cinema 
        String sql = "UPDATE Movie Set Prix = (Prix * " + offre + ")/100";
        //requete sql mettant à jour l'offre que chaque employé a effectué et ainsi associé cette offre à l'employé l'ayant fait
        String sql2 = "UPDATE Employee Set Offre = " + offre + " where Name = '" + u + "'";
        //execution des 2 requête sql
        stmt.executeUpdate(sql);
        stmt.executeUpdate(sql2);
    }

    //fonction permettant de trier les films ayant le plus de tickets (les plus vus)
    public ArrayList filmPoP() throws SQLException {
        //création d'une requête sql pour trier par odre décroissant les film avec le plus de ticket
        String sql = "select idMovie, Count(*) as nb From Ticket group by idMovie order by nb DESC";
        //execution de la requête sql
        rset = stmt.executeQuery(sql);

        //création d'une arraylist d'entier afin d'y inserer les ID de nos films une fois triés
        ArrayList<Integer> liste;
        liste = new ArrayList<>();

        //tant qu'il reste un Ticket dans la table nous continuons à l'ajouter à l'arraylist
        while (rset.next()) {

            // ajouter le champ de la ligne sélectionné dans l'ArrayList
            liste.add(rset.getInt(1));
        }

        // Retourner l'ArrayList
        return liste;
    }

    //fonction pour afficher les film populaire triés dans la fonction précédente 
    public String affFilmPOP(int a) throws SQLException {

        String titre = null;
        //requête sql permettant de récupérer le titre du film en fonction de l'id  
        String sql = "Select Title From Movie where idMovie = " + a + "";
        //execution de la requête
        rset = stmt.executeQuery(sql);

        if (rset.next()) {
            //la chaine de caractère prend comme valeur le titre du film 
            titre = rset.getString(1);
        }

        //retourner la chaine de caractère 
        return titre;

    }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
