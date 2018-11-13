package com.spring.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.spring.entities.*;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author crazy
 */
@Entity
@Table(name = "Admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByCin", query = "SELECT a FROM Admin a WHERE a.cin = :cin"),
    @NamedQuery(name = "Admin.findByPassword", query = "SELECT a FROM Admin a WHERE a.password = :password"),
    @NamedQuery(name = "Admin.findByNom", query = "SELECT a FROM Admin a WHERE a.nom = :nom"),
    @NamedQuery(name = "Admin.findByPrenom", query = "SELECT a FROM Admin a WHERE a.prenom = :prenom")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Cin")
    private String cin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Password")
    private String password;
    @Size(max = 20)
    @Column(name = "Nom")
    private String nom;
    @Size(max = 20)
    @Column(name = "Prenom")
    private String prenom;

    public Admin() {
    }

    public Admin(String cin) {
        this.cin = cin;
    }

    public Admin(String cin, String password) {
        this.cin = cin;
        this.password = password;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cin != null ? cin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.cin == null && other.cin != null) || (this.cin != null && !this.cin.equals(other.cin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "<tr>"
                + "<td>" + nom + "</td>"
                + "<td>" + prenom + "</td>"
                + "<td>" + cin + "</th>"
                + "<td>" + password + "</td>"
                + "</tr>";
    }

}
