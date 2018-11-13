/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repository;

import com.spring.entities.Enseignant;
import java.util.List;

/**
 *
 * @author hunter
 */
public class EnseignantRepository extends Repository<Enseignant, String> {

    public EnseignantRepository() {
        super(Enseignant.class);
    }
    
    public List<Enseignant> findByNom(String value) {
        return this.findBy("Nom", value);
    }
    
    public List<Enseignant> findByPrenom(String value) {
        return this.findBy("Prenom", value);
    }
    
    public List<Enseignant> findByCne(String value) {
        return this.findBy("Cne", value);
    }
    
    public List<Enseignant> findByPassword(String value) {
        return this.findBy("Password", value);
    }
    
    public List<Enseignant> findByEtatcompte(String value) {
        return this.findBy("Etatcompte", value);
    }
    
    public List<Enseignant> findByCin(String value) {
        return this.findBy("Cin", value);
    }

    public List<Enseignant> findByDatenaissance(String value) {
        return this.findBy("Datenaissance", value);
    }
    
    public List<Enseignant> findByAdresse(String value) {
        return this.findBy("Adresse", value);
    }
    
    public List<Enseignant> findByVille(String value) {
        return this.findBy("Ville", value);
    }
    
    public List<Enseignant> findByPays(String value) {
        return this.findBy("Pays", value);
    }
}
