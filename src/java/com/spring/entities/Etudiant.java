package com.spring.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.spring.entities.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author crazy
 */
@Entity
@Table(name = "Etudiant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByCne", query = "SELECT e FROM Etudiant e WHERE e.cne = :cne"),
    @NamedQuery(name = "Etudiant.findByPassword", query = "SELECT e FROM Etudiant e WHERE e.password = :password"),
    @NamedQuery(name = "Etudiant.findByNom", query = "SELECT e FROM Etudiant e WHERE e.nom = :nom"),
    @NamedQuery(name = "Etudiant.findByPrenom", query = "SELECT e FROM Etudiant e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Etudiant.findByDateN", query = "SELECT e FROM Etudiant e WHERE e.dateN = :dateN"),
    @NamedQuery(name = "Etudiant.findByAdress", query = "SELECT e FROM Etudiant e WHERE e.adress = :adress"),
    @NamedQuery(name = "Etudiant.findByVille", query = "SELECT e FROM Etudiant e WHERE e.ville = :ville"),
    @NamedQuery(name = "Etudiant.findByPays", query = "SELECT e FROM Etudiant e WHERE e.pays = :pays"),
    @NamedQuery(name = "Etudiant.findByDateI", query = "SELECT e FROM Etudiant e WHERE e.dateI = :dateI")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Cne")
    private String cne;
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
    @Column(name = "DateN")
    @Temporal(TemporalType.DATE)
    private Date dateN;
    @Size(max = 50)
    @Column(name = "Adress")
    private String adress;
    @Size(max = 20)
    @Column(name = "Ville")
    private String ville;
    @Size(max = 20)
    @Column(name = "Pays")
    private String pays;
    @Basic(optional = false)
    @Column(name = "DateI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateI;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiantCne")
    private Collection<Note> noteCollection;

    public Etudiant() {
    }

    public Etudiant(String cne) {
        this.cne = cne;
    }

    public Etudiant(String cne, String password, Date dateI) {
        this.cne = cne;
        this.password = password;
        this.dateI = dateI;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
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

    public Date getDateN() {
        return dateN;
    }

    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }

    public void setDateN(String dateN) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dateN = date.parse(dateN);
        } catch (ParseException e) {

        }
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Date getDateI() {
        return dateI;
    }

    public void setDateI(Date dateI) {
        this.dateI = dateI;
    }

    @XmlTransient
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cne != null ? cne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.cne == null && other.cne != null) || (this.cne != null && !this.cne.equals(other.cne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "<tr>"
                + "<td>" + nom + "</td>"
                + "<td>" + prenom + "</td>"
                + "<td>" + cne + "</th>"
                + "<td>" + password + "</td>"
                + "<td>" + new SimpleDateFormat("yyyy-MM-dd").format(dateN) + "</td>"
                + "<td>" + adress + "</td>"
                + "<td>" + ville + "</td>"
                + "<td>" + pays + "</td>"
                + "</tr>";
    }

}
