/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.entities;

import com.summercoding.bank.utils.JDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author LECAUCHY
 */
public class Compte {int idcompte;
    double solde;
    int iduser;
    int idadmin;

   // private Compte(int aInt, double aDouble, int aInt0, int aInt1) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    public int getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(int idcompte) {
        this.idcompte = idcompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }
    public void save(double solde,int iduser,int idadmin) throws SQLException{
         
       
            String command ="INSERT INTO `compte` (  `solde`, `iduser`, `idadmin`) VALUES (?, ?, ?)";
            PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
            
            addstmt.setObject(1,solde);
            addstmt.setObject(2,iduser);
            addstmt.setObject(3,idadmin);
            addstmt.execute();
        
    
    }
    public void update (int compte,double solde,int iduser,int idadmin) throws SQLException{
         
        
            String command ="UPDATE `compte` SET `solde` = ? , `iduser` = ? , `idadmin` = ?  WHERE `compte`.`idcompte` = ? ";
            PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
            addstmt.setObject(1,solde);
            addstmt.setObject(2,iduser);
            addstmt.setObject(3,idadmin);
            addstmt.setObject(4,idcompte);
            addstmt.execute();
        
    }
     
    public void delete(int idcompte) throws SQLException{

        
 
            String command = "DELETE FROM compte WHERE `compte` `idcompte` = ?" ;
            PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
            addstmt.setObject(1,idcompte);
            addstmt.execute();
        
    }
     
    public Compte getOne (int idcompte) throws SQLException{//ressort un administrateur
        String cmd="select * from compte where idcompte = ?";
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);
        stmt.setObject(1, idcompte);
        ResultSet rs=stmt.executeQuery();
        while (rs.next()){
            return new Compte (rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getInt(4));
        }
        return null;
    }
    public Compte getBySoldeAndIduser (double solde,int iduser) throws SQLException{//ressort le moet de pass et le login d un administrateur administrateur
        String cmd="select * from compte where solde = ? and iduser = ?";
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);
        stmt.setObject(1, solde);
        stmt.setObject(2,iduser);
        ResultSet rs=stmt.executeQuery();
        while (rs.next()){
            return new Compte (rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getInt(4));
        }
        return null;
    }
 
    public List<Compte> getAllCompte () throws SQLException{
        String cmd="select * from compte ";
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);
        ResultSet rs=stmt.executeQuery();
        List<Compte> listCompte = new ArrayList<>();
        while (rs.next()){
            listCompte.add(new Compte(rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getInt(4)));
        }
        return listCompte;
    }
    
    public Compte () {
    }

    public Compte (int idcompte, double solde, int iduser, int idadmin) {
        this.idcompte = idcompte;
        this.solde = solde;
        this.iduser = iduser;
        this.idadmin = idadmin;
    }

    @Override
    public String toString() {
        return "Compte{" + "idcompte=" + idcompte + ", solde=" + solde + ", iduser=" + iduser + ", idadmin=" + idadmin + '}';
    }
   
    
    public static void main(String arg[]){
        try {
            Compte compte = new Compte();
            compte.save(5.0, 4, 7);
             String result = compte.getOne(3).toString();
            System.out.println(result);
            result = compte.getBySoldeAndIduser(300,2).toString();
            System.out.println(result);
            result = compte.getAllCompte().toString();
            System.out.println(result);
            compte.update(7, 6000, 4, 5);
            
        } catch (SQLException ex) {
            Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
    

