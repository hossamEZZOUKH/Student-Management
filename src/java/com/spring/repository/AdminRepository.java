/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repository;

import com.spring.entities.Admin;
import java.util.List;

/**
 *
 * @author hunter
 */
public class AdminRepository extends Repository<Admin, String> {

    public AdminRepository() {
        super(Admin.class);
    }
    
    public List<Admin> findByNom(String value) {
        return this.findBy("Nom", value);
    }
    
    public List<Admin> findByPrenom(String value) {
        return this.findBy("Prenom", value);
    }
    
    public List<Admin> findByPassword(String value) {
        return this.findBy("Password", value);
    }
    
    public List<Admin> findByCin(String value) {
        return this.findBy("Cin", value);
    }
}
