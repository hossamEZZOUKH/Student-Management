/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repository;

import com.spring.entities.Module;
import java.util.List;

/**
 *
 * @author crazy
 */
public class ModuleRepository extends Repository<Module, String> {
    public ModuleRepository() {
        super(Module.class);
    }
    
    public List<Module> findByNom(String value) {
        return this.findBy("Nom", value);
    }
   
    public List<Module> findBySemestre(String value) {
        return this.findBy("Semestre", value);
    }
    
    
}
