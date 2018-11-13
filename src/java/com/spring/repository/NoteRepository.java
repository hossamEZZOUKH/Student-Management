/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repository;

import com.spring.entities.Note;
import java.util.List;

/**
 *
 * @author crazy
 */
public class NoteRepository extends Repository<Note, Integer> {
    public NoteRepository() {
        super(Note.class);
    }
    
    public List<Note> findBySn(Double value) {
        return this.findBy("Sn", value);
    }
   
    public List<Note> findBySr(Double value) {
        return this.findBy("Sr", value);
    }
    
    
}
