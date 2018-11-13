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
import javax.persistence.Id;
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
@Table(name = "Enseignant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e")
    , @NamedQuery(name = "Enseignant.findByNs", query = "SELECT e FROM Enseignant e WHERE e.ns = :ns")
    , @NamedQuery(name = "Enseignant.findByPassword", query = "SELECT e FROM Enseignant e WHERE e.password = :password")
    , @NamedQuery(name = "Enseignant.findByCin", query = "SELECT e FROM Enseignant e WHERE e.cin = :cin")
    , @NamedQuery(name = "Enseignant.findByNom", query = "SELECT e FROM Enseignant e WHERE e.nom = :nom")
    , @NamedQuery(name = "Enseignant.findByPrenom", query = "SELECT e FROM Enseignant e WHERE e.prenom = :prenom")})
public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Ns")
    private String ns;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Password")
    private String password;
    @Size(max = 20)
    @Column(name = "Cin")
    private String cin;
    @Size(max = 20)
    @Column(name = "Nom")
    private String nom;
    @Size(max = 20)
    @Column(name = "Prenom")
    private String prenom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enseignantNs")
    private Collection<Module> moduleCollection;

    public Enseignant() {
    }

    public Enseignant(String ns) {
        this.ns = ns;
    }

    public Enseignant(String ns, String password) {
        this.ns = ns;
        this.password = password;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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

    @XmlTransient
    public Collection<Module> getModuleCollection() {
        return moduleCollection;
    }

    public void setModuleCollection(Collection<Module> moduleCollection) {
        this.moduleCollection = moduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ns != null ? ns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.ns == null && other.ns != null) || (this.ns != null && !this.ns.equals(other.ns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "   "+ ns + "   "+password+"   "+cin+"     "+nom+"    "+prenom;
    }
    
}
