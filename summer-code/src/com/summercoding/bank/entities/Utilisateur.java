/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.summercoding.bank.entities;
import java.time.LocalDate;
import com.summercoding.bank.utils.JDBC;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LECAUCHY
 */
public class Utilisateur {

    private static String result;
    int iduser;
    String login;
    String password;
    String nom;
    String prenom;
    Date datenaiss;
    boolean genre;
    int idadmin ;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public boolean isGenre() {
        return genre;
    }

    public void setGenre(boolean genre) {
        this.genre = genre;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    
    public void save(String login,String password,String nom,String prenom,LocalDate datenaiss,boolean genre,int idadmin) throws SQLException{
        PreparedStatement addstmt =null;
        
            String command ="INSERT INTO `utilisateur` ( `login`, `password`, `nom`,`prenom`,`datenaiss`,`genre`,`idadmin`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            addstmt = JDBC.getConnexion().prepareStatement(command);
            addstmt.setObject(1,login);
            addstmt.setObject(2,password);
            addstmt.setObject(3,nom);
            addstmt.setObject(4,prenom);
            addstmt.setObject(5,datenaiss);
            addstmt.setObject(6,genre);
            addstmt.setObject(7,idadmin);
            addstmt.execute();
      
    
    }
      public void update (int iduser,String login,String password,String nom,String prenom,LocalDate datenaiss,boolean genre,int idadmin) throws SQLException{
         
        
            String command ="UPDATE utilisateur SET login = ? , password = ? , nom = ? ,prenom = ? , datenaiss = ? , genre = ? , idadmin = ? WHERE utilisateur.iduser = ? ";
            PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
            addstmt.setObject(1,login);
            addstmt.setObject(2,password);
            addstmt.setObject(3,nom);
            addstmt.setObject(4,prenom);
            addstmt.setObject(5,datenaiss);
            addstmt.setObject(6,genre);
            addstmt.setObject(7,idadmin);
            addstmt.setObject(8,iduser);
            addstmt.execute();
        
    }
     
    public void delete(int iduser) throws SQLException{

        
 
            String command = "DELETE FROM utilisateur WHERE `utilisateur` `iduser` = ?" ;
            PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
            addstmt.setObject(1,iduser);
            addstmt.execute();
        
    }
     
    public Utilisateur getOne (int iduser) throws SQLException{//ressort un administrateur
        String cmd="select * from utilisateur where iduser = ?";
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);
        stmt.setObject(1, iduser);
        ResultSet rs=stmt.executeQuery();
        while (rs.next()){
            return new Utilisateur (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6) ,rs.getBoolean(7),rs.getInt(8));
        }
        return null;
    }
    public Utilisateur getByLoginAndPassword (String login,String password) throws SQLException{//ressort le moet de pass et le login d un administrateur administrateur
        String cmd="select * from utilisateur where login = ? and password = ?";
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);
        stmt.setObject(1, login);
        stmt.setObject(2,password);
        ResultSet rs=stmt.executeQuery();
        while (rs.next()){
             return new Utilisateur (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6) ,rs.getBoolean(7),rs.getInt(8));
        }
        return null;
    }
 
    public List<Utilisateur> getAllUtilisateur () throws SQLException{
        String cmd="select * from utilisateur ";
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);
        ResultSet rs=stmt.executeQuery();
        List<Utilisateur> listUtilisateur = new ArrayList<>();
        while (rs.next()){
             listUtilisateur.add(new Utilisateur(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getBoolean(7),rs.getInt(8)));
        }
        return listUtilisateur;
    }
    public Utilisateur () {
    }

    public Utilisateur(int iduser, String login, String password, String nom, String prenom, Date datenaiss, boolean genre, int idadmin) {
        this.iduser = iduser;
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.genre = genre;
        this.idadmin = idadmin;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "iduser=" + iduser + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", datenaiss=" + datenaiss + ", genre=" + genre + ", idadmin=" + idadmin + '}';
    }



 
   
    
    
    public static void main(String arg[]){
       
        try {
            Utilisateur utilisateur=new Utilisateur();
            //String result =utilisateur.getOne(2).toString();
            //System.out.println(result);
            //utilisateur.save("cauchy", "cauchy", "cauchy", "cauchy", LocalDate.of(2003,Month.APRIL, 20), true, 4);
            //result = utilisateur.getByLoginAndPassword("cauchy","cauchy").toString();
            //System.out.println(result);
             String result = utilisateur.getAllUtilisateur().toString();
            System.out.println(result);
            utilisateur.update(10,"user5","noiro","marcel","junior",LocalDate.of(2002, Month.MARCH, 7), true ,3);
            
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}

