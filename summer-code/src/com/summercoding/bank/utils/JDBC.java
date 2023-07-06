/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.utils;
                                   
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LECAUCHY
 */
public class JDBC {
    private final static String URL ="jdbc:mysql://localhost:3306/summerbankdb";//adresse url,serveur et port qui abrite notre BD et notre BD 
    private final static String USER ="root";
    private final static String PASSWORD =""; 
    

public static Connection getConnexion(){
        try {
            Connection connexion =null;
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("fin chargement jdbc.jdbc.main()");
            return (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
return null;
         }
}