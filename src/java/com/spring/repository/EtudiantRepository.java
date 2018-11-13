/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repository;

import com.spring.entities.Etudiant;
import java.util.List;

/**
 *
 * @author hunter
 */
public class EtudiantRepository extends Repository<Etudiant, String> {

    public EtudiantRepository() {
        super(Etudiant.class);
    }

    public List<Etudiant> findByNom(String value) {
        return this.findBy("Nom", value);
    }
    
    public List<Etudiant> findByPrenom(String value) {
        return this.findBy("Prenom", value);
    }
    
    public List<Etudiant> findByCne(String value) {
        return this.findBy("Cne", value);
    }
    
    public List<Etudiant> findByPassword(String value) {
        return this.findBy("Password", value);
    }
    
    public List<Etudiant> findByEtatcompte(String value) {
        return this.findBy("Etatcompte", value);
    }
    
    public List<Etudiant> findByCin(String value) {
        return this.findBy("Cin", value);
    }
    
    public List<Etudiant> findByDatenaissance(String value) {
        return this.findBy("Datenaissance", value);
    }
    
    public List<Etudiant> findByAdresse(String value) {
        return this.findBy("Adresse", value);
    }
    
    public List<Etudiant> findByVille(String value) {
        return this.findBy("Ville", value);
    }
    
    public List<Etudiant> findByPays(String value) {
        return this.findBy("Pays", value);
    }
}
