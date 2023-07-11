/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.controlleur;

import com.summercoding.bank.entities.Admin;
import com.summercoding.bank.entities.Compte;
import com.summercoding.bank.entities.Utilisateur;
import com.summercoding.bank.gestionnaire.GestionnaireAdmin;
import com.summercoding.bank.gestionnaire.GestionnaireCompte;
import com.summercoding.bank.gestionnaire.GestionnaireUtilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LECAUCHY
 */
public class Controleur {
    GestionnaireAdmin gestionnaireAdmin = new GestionnaireAdmin();
    
    
            
    public Admin routeVersLogin(String login,String pwd) throws SQLException{
        return gestionnaireAdmin.login(login,pwd);
    }
    public void routeVersSaveAdmin(String login, String pwd, String nom ) throws SQLException{
            gestionnaireAdmin.saveAdmin(login, pwd, nom);
    }
    public List<Admin> routeVerslistAllAdmin() throws SQLException{
            return gestionnaireAdmin.listAllAdmin();
    }
    
    
    GestionnaireUtilisateur gestionnaireUtilisateur = new GestionnaireUtilisateur();
    
    public void routeVersSaveUtilisateur(String login, String password, String nom, String prenom, LocalDate datenaiss, boolean genre, int idadmin) throws SQLException{
        
        gestionnaireUtilisateur.saveUtilisateur(login, password, nom, prenom, datenaiss, genre, idadmin);
    }
    
    public List<Utilisateur> routeVersListAllUtilisateur() throws SQLException {
        return gestionnaireUtilisateur.listAllUtilisateur();
    
    }
    
    
    GestionnaireCompte gestionnaireCompte = new GestionnaireCompte();
    
    public void routeVersSaveCompte(double solde, int iduser, int idadmin ) throws SQLException{
            gestionnaireCompte.saveCompte(solde, iduser,  idadmin);
    }
    
            
    public Utilisateur routeVersLoginUtilisateur(String login,String pwd) throws SQLException{
        return gestionnaireUtilisateur.login(login,pwd);
    }

    public List<Admin> routeVersListAllAdmin() throws SQLException {
       return gestionnaireAdmin.listAllAdmin();
    
               }
    
        
    public List<Compte> routeVersListAllCompte() throws SQLException {
       return gestionnaireCompte.listAllCompte();
    
               }
    
    
}
