package com.spring.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.spring.entities.*;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author crazy
 */
@Entity
@Table(name = "Note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByIdNote", query = "SELECT n FROM Note n WHERE n.idNote = :idNote"),
    @NamedQuery(name = "Note.findBySn", query = "SELECT n FROM Note n WHERE n.sn = :sn"),
    @NamedQuery(name = "Note.findBySr", query = "SELECT n FROM Note n WHERE n.sr = :sr"),
    @NamedQuery(name = "Note.findByDateI", query = "SELECT n FROM Note n WHERE n.dateI = :dateI"),
    @NamedQuery(name = "Note.findByDateM", query = "SELECT n FROM Note n WHERE n.dateM = :dateM"),
    @NamedQuery(name = "Note.findByNomModule", query = "SELECT n FROM Note n JOIN n.moduleNom m where m.nom = :nomModule"),
    @NamedQuery(name = "Note.findByCne", query = "SELECT n FROM Note n JOIN n.etudiantCne e where e.cne = :cne")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNote")
    private Integer idNote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SN")
    private Double sn;
    @Column(name = "SR")
    private Double sr;
    @Column(name = "DateI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateI;
    @Column(name = "DateM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateM;
    @JoinColumn(name = "Etudiant_Cne", referencedColumnName = "Cne")
    @ManyToOne(fetch = FetchType.LAZY)
    private Etudiant etudiantCne;
    @JoinColumn(name = "Module_Nom", referencedColumnName = "Nom")
    @ManyToOne(fetch = FetchType.LAZY)
    private Module moduleNom;

    public Note() {
    }

    public Note(Integer idNote) {
        this.idNote = idNote;
    }

    public Note(Integer idNote, Date dateI) {
        this.idNote = idNote;
        this.dateI = dateI;
    }

    public Integer getIdNote() {
        return idNote;
    }

    public void setIdNote(Integer idNote) {
        this.idNote = idNote;
    }

    public Double getSn() {
        return sn;
    }

    public void setSn(Double sn) {
        this.sn = sn;
    }

    public Double getSr() {
        return sr;
    }

    public void setSr(Double sr) {
        this.sr = sr;
    }

    public Date getDateI() {
        return dateI;
    }

    public void setDateI(Date dateI) {
        this.dateI = dateI;
    }

    public void setDateI() {
        Calendar c = Calendar.getInstance();
        this.dateI = c.getTime();
    }

    public Date getDateM() {
        return dateM;
    }

    public void setDateM(Date dateM) {
        this.dateM = dateM;
    }

    public Etudiant getEtudiantCne() {
        return etudiantCne;
    }

    public void setEtudiantCne(Etudiant etudiantCne) {
        this.etudiantCne = etudiantCne;
    }

    public Module getModuleNom() {
        return moduleNom;
    }

    public void setModuleNom(Module moduleNom) {
        this.moduleNom = moduleNom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNote != null ? idNote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.idNote == null && other.idNote != null) || (this.idNote != null && !this.idNote.equals(other.idNote))) {
            return false;
        }
        return true;
    }

    public static String toDocumentXML(List<Note> notes)
            throws ParserConfigurationException, SQLException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        doc.setXmlVersion("1.0");
        doc.setXmlStandalone(true);
        Element results = doc.createElement("etudiant-info");
        doc.appendChild(results);
        Element node;
        for (Note note : notes) {
            Etudiant etudiant = note.getEtudiantCne();
            Element row = doc.createElement("etudiant");
            results.appendChild(row);
            node = doc.createElement("cne");//columnName
            node.appendChild(doc.createTextNode(etudiant.getCne()));//value
            row.appendChild(node);
            node = doc.createElement("nom");
            node.appendChild(doc.createTextNode(etudiant.getNom()));
            row.appendChild(node);
            node = doc.createElement("prenom");
            node.appendChild(doc.createTextNode(etudiant.getPrenom()));
            row.appendChild(node);
            node = doc.createElement("password");
            node.appendChild(doc.createTextNode(etudiant.getPassword()));
            row.appendChild(node);
            node = doc.createElement("date-naissance");
            node.appendChild(doc.createTextNode(new SimpleDateFormat("yyyy-MM-dd").format(etudiant.getDateN())));
            note.setDateI(Calendar.getInstance().getTime());
            row.appendChild(node);
            node = doc.createElement("adress");
            node.appendChild(doc.createTextNode(etudiant.getAdress()));
            row.appendChild(node);
            node = doc.createElement("ville");
            node.appendChild(doc.createTextNode(etudiant.getVille()));
            row.appendChild(node);
            node = doc.createElement("pays");
            node.appendChild(doc.createTextNode(etudiant.getPays()));
            row.appendChild(node);
            node = doc.createElement("note-normal");
            node.appendChild(doc.createTextNode(note.getSn() + ""));
            row.appendChild(node);
            node = doc.createElement("note-rattrapage");
            node.appendChild(doc.createTextNode(note.getSr() + ""));
            row.appendChild(node);
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        String output = writer.getBuffer().toString().replaceAll("<etudiant-info", "\n<etudiant-info").replaceAll("></etudiant-info", ">\n</etudiant-info").replaceAll("><e", ">\n\t<e").replaceAll("></e", ">\n\t</e").replaceAll("><", ">\n\t\t<");
        return output;
    }

    @Override
    public String toString() {
        return "com.spring.entities.Note[ idNote=" + idNote + " ]";
    }

}
