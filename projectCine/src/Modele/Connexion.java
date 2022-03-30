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
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.LabelView;

/**
 * 
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le tunnel SSH
 * 
 * @author segado
 */
public class Connexion {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private final Connection conn;
    private final Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    /**
    
    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        //Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
       // String urlDatabase = "jdbc:mysql://localhost:3308/jps?characterEncoding=latin1";

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }


    /**
     * Méthode qui execute une requete de MAJ en parametre
     * @param requeteMaj
     * @throws java.sql.SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }
    
    public boolean verif(String username , String password) throws SQLException
    {
        boolean vf = false;
        String sql = "Select * from Member where Mail ='"+username+"'and Password ='"+password+"'";
        rset = stmt.executeQuery(sql);
        if (rset.next())
        {
            vf = true;
        }
        return vf;
        
    }
    
    public void inscr(int id, String mail, String prenom, String nom, String password, int age, double reduc, String CardNo, int CVC, int balance) throws SQLException
    {
        String sql = "INSERT INTO Member (idMember, Mail, Surname, Name, Password, Age, Reduction, CardNo, CVC, balance) VALUES ("+id+",'"+mail+"','"+prenom+"','"+nom+"','"+password+"',"+age+","+reduc+",'"+CardNo+"',"+CVC+","+balance+")";
        stmt.executeUpdate(sql);
           
    }
    
    public void Ticket(int id, int idme, int idmo, double price, String seance) throws SQLException
    {
        String sql = "INSERT INTO Ticket (idTicket, idMember, idMovie, Price, seance) VALUES ("+id+","+idme+","+idmo+","+price+",'"+seance+"')";
        stmt.executeUpdate(sql);    
    }
    
    public void affTicket(JLabel idme, JLabel idmo, JLabel price, JLabel seance, int i) throws SQLException
    {
        String sql = "Select * from Ticket where idTicket= "+i+"";
        rset = stmt.executeQuery(sql);
        
        if(rset.next())
        {
           idme.setText(rset.getString(2));
           idmo.setText(rset.getString(3));
           price.setText(rset.getString(4)+" €");
           seance.setText(rset.getString(5));
        }
    }
    
    public double Prixmembre(String username) throws SQLException
    {
        double pm = 0;
        String sql = "Select Reduction from Member where  Mail= '"+username+"'";
        rset = stmt.executeQuery(sql);
        
        if(rset.next())
        {
            pm = rset.getDouble(1);
        }
        return pm; 
    }
    
     public double balance(String username) throws SQLException
    {
        double pm = 0;
        String sql = "Select balance from Member where  Mail= '"+username+"'";
        rset = stmt.executeQuery(sql);
        
        if(rset.next())
        {
            pm = rset.getDouble(1);
        }
        return pm; 
    }
     public boolean vcard(String username, String CardNo, int CVC) throws SQLException
    {
        boolean b = false;
        String sql = "Select * from Member where  Mail= '"+username+"'and CardNo = '"+CardNo+"'and CVC = "+CVC+"";
        rset = stmt.executeQuery(sql);
        
        if(rset.next())
        {
           b=true;
        }
        return b;
    }
    

    public int Film(JLabel titre, JLabel time, JLabel genre, JLabel img, int id) throws SQLException
    {
        String sql = "Select * from Movie where idMovie = "+id+"";
        rset = stmt.executeQuery(sql);
       
            if(rset.next())
            {
            titre.setText(rset.getString(2));
            time.setText(rset.getString(3));
            genre.setText(rset.getString(5));
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
    
    public int recupIdMe(String username) throws SQLException
    {
        int id = 0;
        String sql = "Select idMember from Member where Mail = '"+username+"'";
        rset = stmt.executeQuery(sql);
        if(rset.next())
        {
            id=rset.getInt(1);
        }
        return id;
    }
    
    public void FilmInfo(JLabel titre,JLabel real, JLabel Seance1, JLabel Seance2, JLabel Seance3, JLabel time, JLabel genre, JLabel img, int id) throws SQLException
    {
        String sql = "Select * from Movie where idMovie = "+id+"";
        rset = stmt.executeQuery(sql);
       
            if(rset.next())
            {
            real.setText(rset.getString(4));
            Seance1.setText(rset.getString(6));
            Seance2.setText(rset.getString(8));
            Seance3.setText(rset.getString(9));
            titre.setText(rset.getString(2));
            time.setText(rset.getString(3));
            genre.setText(rset.getString(5));
            byte[] image = rset.getBytes("Image");
            ImageIcon ima = new ImageIcon(image);
            Image im = ima.getImage();
            Image myImg = im.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon NewImage = new ImageIcon(myImg);
            img.setIcon(NewImage);
            }}
   
    public double res(JLabel place1, JLabel place2, JLabel place3, JLabel prix, int id) throws SQLException
    {
        double p = 0;
        String sql = "Select * from Movie where idMovie = "+id+"";
        rset = stmt.executeQuery(sql);
       
            if(rset.next())
            {
                place1.setText(rset.getString(11));
                place2.setText(rset.getString(12));
                place3.setText(rset.getString(13));
                prix.setText(rset.getString(10)+" €");
                p=rset.getDouble(10);
            }
        return p;
    }
    
    public void Recap(JLabel titre,JLabel real, JLabel time, JLabel genre, JLabel img, int id) throws SQLException
    {
        String sql = "Select * from Movie where idMovie = "+id+"";
        rset = stmt.executeQuery(sql);
       
            if(rset.next())
            {
            real.setText(rset.getString(4));
            titre.setText(rset.getString(2));
            time.setText(rset.getString(3));
            genre.setText(rset.getString(5));
            byte[] image = rset.getBytes("Image");
            ImageIcon ima = new ImageIcon(image);
            Image im = ima.getImage();
            Image myImg = im.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon NewImage = new ImageIcon(myImg);
            img.setIcon(NewImage);
            }
    }
    
    public void updatePrice(double prix,String username) throws SQLException
    {
        String sql = "UPDATE Member SET balance = balance-"+prix+"where Mail = '"+username+"'";
        stmt.executeUpdate(sql);
          
    }
    
    public void updateplaces(int place,int id, int nb) throws SQLException
    {
    if(place==1)
        {
        String sql2 = "UPDATE Movie SET PlacesRestantes = PlacesRestantes-1-"+nb+" where idMovie ="+id+"";
        stmt.executeUpdate(sql2);
        }
        
        if(place==2)
        {
        String sql2 = "UPDATE Movie SET PlacesRestantes2 = PlacesRestantes2-1-"+nb+" where idMovie ="+id+"";
        stmt.executeUpdate(sql2);
        }
        
        if(place==3)
        {
        String sql2 = "UPDATE Movie SET PlacesRestantes3 = PlacesRestantes3-1-"+nb+" where idMovie ="+id+"";
        stmt.executeUpdate(sql2);
        }
    }
    
    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
