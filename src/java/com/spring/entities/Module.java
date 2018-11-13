package com.spring.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.spring.entities.*;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author crazy
 */
@Entity
@Table(name = "Module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m")
    , @NamedQuery(name = "Module.findByNom", query = "SELECT m FROM Module m WHERE m.nom = :nom")
    , @NamedQuery(name = "Module.findByNs", query = "SELECT m FROM Module m JOIN m.enseignantNs e where e.ns = :ns")
    , @NamedQuery(name = "Module.findBySemestre", query = "SELECT m FROM Module m WHERE m.semestre = :semestre")})
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Semestre")
    private Integer semestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleNom")
    private Collection<Note> noteCollection;
    @JoinColumn(name = "Enseignant_Ns", referencedColumnName = "Ns")
    @ManyToOne(fetch=FetchType.LAZY)
    private Enseignant enseignantNs;

    public Module() {
    }

    public Module(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public void setSemestre(String semestre) {
        try {
            this.semestre = Integer.valueOf(semestre);
        } catch (Exception e) {
            
        }
    }

    @XmlTransient
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }

    public Enseignant getEnseignantNs() {
        return enseignantNs;
    }

    public void setEnseignantNs(Enseignant enseignantNs) {
        this.enseignantNs = enseignantNs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.entities.Module[ nom=" + nom + " ]";
    }

}
