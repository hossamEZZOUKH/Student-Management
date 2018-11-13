/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller;

import com.spring.entities.Admin;
import com.spring.entities.Enseignant;
import com.spring.entities.Etudiant;
import com.spring.entities.Module;
import com.spring.entities.Note;
import com.spring.security.Authentication;
import com.spring.repository.AdminRepository;
import com.spring.repository.EnseignantRepository;
import com.spring.repository.EtudiantRepository;
import com.spring.repository.ModuleRepository;
import com.spring.repository.NoteRepository;
import com.spring.repository.Repository;
import java.util.ArrayList;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author hunter
 */
@Controller
@RequestMapping("Admin")
public class AdminController {

    private final AdminRepository manager;

    public AdminController() {
        this.manager = new AdminRepository();
    }

    @RequestMapping(value = "Create", method = {RequestMethod.GET, RequestMethod.POST})
    public String create(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "Admin/create";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "Update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    
                    return "Admin/update";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "Delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String delet(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "Admin/delete";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "CreateEtudiant", method = {RequestMethod.GET, RequestMethod.POST})
    public String createEtudiant(@RequestParam String data,
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String dateN,
            @RequestParam String cne,
            @RequestParam String adress,
            @RequestParam String ville,
            @RequestParam String pays,
            @RequestParam String password, HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    EtudiantRepository managerEtudiant = new EtudiantRepository();
                    ModuleRepository managerModule = new ModuleRepository();
                    NoteRepository managerNote = new NoteRepository();
                    managerEtudiant.open();
                    managerModule.open();
                    managerNote.open();
                    List<Module> modules = managerModule.query("SELECT m FROM Module m WHERE m.semestre = 1 or m.semestre = 2");
                    Etudiant e = managerEtudiant.findById(cne);
                    if (e == null) {
                        managerEtudiant.begin();
                        Etudiant etudiant = new Etudiant();
                        etudiant.setNom(nom);
                        etudiant.setPrenom(prenom);
                        etudiant.setDateN(dateN);
                        etudiant.setCne(cne);
                        etudiant.setAdress(adress);
                        etudiant.setVille(ville);
                        etudiant.setPays(pays);
                        etudiant.setPassword(password != null && !password.isEmpty() ? password : cne);
                        managerEtudiant.create(etudiant);
                        managerEtudiant.commit();
                        for (Module m : modules) {
                            Note note = new Note();
                            note.setModuleNom(m);
                            note.setDateI();
                            note.setEtudiantCne(etudiant);
                            managerNote.begin();
                            managerNote.create(note);
                            managerNote.commit();
                        }
                        request.setAttribute("message", nom);
                    } else {
                        request.setAttribute("message", "Ce Etudiant existe deja !");
                    }
                    managerNote.close();
                    managerModule.close();
                    managerEtudiant.close();
                    return "redirect:Create";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "CreateEnseignant", method = RequestMethod.POST)
    public String createEnseignant(@RequestParam String data,
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String numeroSomme,
            @RequestParam String cin,
            @RequestParam String password, HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    EnseignantRepository manager = new EnseignantRepository();
                    manager.open();
                    Enseignant e = manager.find(numeroSomme);
                    if (e == null) {
                        manager.begin();
                        Enseignant enseignant = new Enseignant();
                        enseignant.setNom(nom);
                        enseignant.setPrenom(prenom);
                        enseignant.setCin(cin);
                        enseignant.setNs(numeroSomme);
                        enseignant.setPassword(password != null && !password.isEmpty() ? password : cin);
                        manager.create(enseignant);
                        manager.commit();

                        request.setAttribute("message", "Enseignant " + nom + "est ajoutée");
                    } else {
                        request.setAttribute("message", "Ce Enseignant existe deja !");
                    }
                    manager.close();
                    return "redirect:Create";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "CreateAdmin", method = RequestMethod.POST)
    public String createAdmin(@RequestParam String data,
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String cin,
            @RequestParam String password, HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    manager.open();
                    Admin e = manager.find(cin);
                    if (e == null) {
                        manager.begin();
                        Admin admin = new Admin();
                        admin.setNom(nom);
                        admin.setPrenom(prenom);
                        admin.setCin(cin);
                        admin.setPassword(password != null && !password.isEmpty() ? password : cin);
                        manager.create(admin);
                        manager.commit();
                        request.setAttribute("message", "Enseignant " + nom + "est ajoutée");
                    } else {
                        request.setAttribute("message", "Ce Enseignant existe deja !");
                    }
                    manager.close();
                    return "redirect:Create";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "CreateModule", method = RequestMethod.POST)
    public String createModule(@RequestParam String data,
            @RequestParam String nommodule,
            @RequestParam String semestre,
            @RequestParam String NS, HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    ModuleRepository manager = new ModuleRepository();
                    EnseignantRepository manage = new EnseignantRepository();
                    manager.open();
                    manage.open();
                    Module e = manager.find(nommodule);
                    Enseignant y = manage.find(NS);
                    if (e == null) {
                        manager.begin();
                        Module module = new Module();
                        module.setNom(nommodule);
                        module.setSemestre(semestre);
                        module.setEnseignantNs(y);
                        manager.create(module);
                        manager.commit();
                        request.setAttribute("message", "Enseignant " + nommodule + "est ajoutée");
                    } else {
                        request.setAttribute("message", "Ce Enseignant existe deja !");
                    }
                    manage.open();
                    manager.close();
                    return "redirect:Create";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "UpdateEtudiant", method = RequestMethod.POST)
    public String updateEtudiant(@RequestParam String data,
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String dateN,
            @RequestParam String cne,
            @RequestParam String adress,
            @RequestParam String ville,
            @RequestParam String pays,
            @RequestParam String password, HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    EtudiantRepository manager = new EtudiantRepository();
                    manager.open();
                    Etudiant e = manager.findById(cne);
                    manager.begin();
                    e.setNom(nom);
                    e.setPrenom(prenom);
                    e.setDateN(dateN);
                    e.setAdress(adress);
                    e.setVille(ville);
                    e.setPays(pays);
                    e.setPassword(password != null && !password.isEmpty() ? password : cne);
                    manager.update(e);
                    manager.commit();
                    request.setAttribute("message", "Etudiant " + nom + "est Modifier");

                    manager.close();
                    return "redirect:Update";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "UpdateEnseignant", method = RequestMethod.POST)
    public String updateEnseignant(@RequestParam String data,
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String numeroSomme,
            @RequestParam String cin,
            @RequestParam String password, HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    EnseignantRepository manager = new EnseignantRepository();
                    manager.open();
                    Enseignant e = manager.findById(numeroSomme);
                    manager.begin();
                    e.setNom(nom);
                    e.setPrenom(prenom);
                    e.setCin(cin);
                    e.setPassword(password != null && !password.isEmpty() ? password : cin);
                    manager.update(e);
                    manager.commit();
                    request.setAttribute("message", "Enseignant " + nom + "est Modifier");
                    manager.close();
                    return "redirect:Update";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "UpdateAdmin", method = RequestMethod.POST)
    public String updateAdmin(@RequestParam String data,
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String cin,
            @RequestParam String password, HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    manager.open();
                    Admin e = manager.findById(cin);
                    manager.begin();
                    e.setNom(nom);
                    e.setPrenom(prenom);
                    e.setCin(cin);
                    e.setPassword(password != null && !password.isEmpty() ? password : cin);
                    manager.update(e);
                    manager.commit();
                    request.setAttribute("message", "Admin est " + nom + "est Modifier");
                    manager.close();
                    return "redirect:Update";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "UpdateModule", method = RequestMethod.POST)
    public String updateModule(@RequestParam String data,
            @RequestParam String nommodule,
            @RequestParam String semestre,
            @RequestParam String NS, HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    ModuleRepository manager = new ModuleRepository();
                    EnseignantRepository manage = new EnseignantRepository();
                    manager.open();
                    manage.open();
                    Module e = manager.findById(nommodule);
                    Enseignant y = manage.findById(NS);
                    manager.begin();
                    e.setNom(nommodule);
                    e.setSemestre(semestre);
                    e.setEnseignantNs(y);
                    manager.update(e);
                    manager.commit();
                    request.setAttribute("message", "Module " + nommodule + "est Modifier");
                    manage.open();
                    manager.close();
                    return "redirect:Update";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "DeleteEtudiant", method = RequestMethod.POST)
    public String deleteEtudiant(
            @RequestParam String cne,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    EtudiantRepository manager = new EtudiantRepository();
                    manager.open();
                    Etudiant e = manager.findById(cne);
                    manager.begin();
                    manager.remove(e);
                    manager.commit();
                    request.setAttribute("message", "Etudiant est Supprimer");
                    manager.close();
                    return "redirect:Delete";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "DeleteEnseignant", method = RequestMethod.POST)
    public String deleteEnseignant(
            @RequestParam String numeroSomme,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    EnseignantRepository manager = new EnseignantRepository();
                    manager.open();
                    Enseignant e = manager.findById(numeroSomme);
                    manager.begin();
                    manager.remove(e);
                    manager.commit();
                    request.setAttribute("message", "Enseignant est Supprimer");
                    manager.close();
                    return "redirect:Delete";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "DeleteModule", method = RequestMethod.POST)
    public String deleteModule(
            @RequestParam String nommodule,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    ModuleRepository manager = new ModuleRepository();
                    manager.open();
                    Module e = manager.findById(nommodule);
                    manager.begin();
                    manager.remove(e);
                    manager.commit();
                    request.setAttribute("message", "Module est Supprimer");
                    manager.close();
                    return "redirect:Delete";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "DeleteAdmin", method = RequestMethod.POST)
    public String deleteAdmin(
            @RequestParam String cin,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    manager.open();
                    Admin e = manager.findById(cin);
                    manager.begin();
                    manager.remove(e);
                    manager.commit();
                    request.setAttribute("message", "Admin est Supprimer");
                    manager.close();
                    return "redirect:Delete";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "Reinscription", method = {RequestMethod.GET, RequestMethod.POST})
    public String reinscription(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    EtudiantRepository manager = new EtudiantRepository();
                    manager.open();
                    request.setAttribute("Etudiants", manager.findAll());
                    manager.close();
                    return object.getClass().getSimpleName() + "/reinscription";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "Inscription", method = {RequestMethod.GET, RequestMethod.POST})
    public String inscription(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    EtudiantRepository manager = new EtudiantRepository();
                    manager.open();
                    request.setAttribute("Etudiants", manager.findAll());
                    manager.close();
                    return object.getClass().getSimpleName() + "/inscription";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "ReinscriptionEtudiant", method = RequestMethod.POST)
    public String reinscriptionEtudiant(
            @RequestParam String cne,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    if (cne.equals("")) {
                        return "redirect:/" + object.getClass().getSimpleName();
                    } else {
                        NoteRepository managerNote = new NoteRepository();
                        EtudiantRepository managerEtudiant = new EtudiantRepository();
                        ModuleRepository managerModule = new ModuleRepository();
                        managerNote.open();
                        managerEtudiant.open();
                        managerModule.open();
                        Etudiant etudiant = managerEtudiant.findById(cne);
                        List<Note> notes = managerNote.findBy("Cne", cne);
                        List<Note> moduleNonValideS1 = new ArrayList();
                        List<Note> moduleNonValideS2 = new ArrayList();
                        List<Note> moduleNonValideS3 = new ArrayList();
                        List<Note> moduleNonValideS4 = new ArrayList();
                        List<String> modulesS3NomNV = new ArrayList();
                        List<String> modulesS4NomNV = new ArrayList();
                        List<String> modulesS3Nom = new ArrayList();
                        List<String> modulesS4Nom = new ArrayList();
                        List<Module> modules;
                        int n;
                        int count_1 = 0;
                        int count_2 = 0;
                        int count_3 = 0;
                        int count_4 = 0;
                        for (Note note : notes) {
                            switch (note.getModuleNom().getSemestre()) {
                                case 1:
                                    count_1++;
                                    if ((note.getSn() == null || note.getSn() < 10) && (note.getSr() == null || note.getSr() < 10)) {
                                        moduleNonValideS1.add(note);
                                    }
                                    break;
                                case 2:
                                    count_2++;
                                    if ((note.getSn() == null || note.getSn() < 10) && (note.getSr() == null || note.getSr() < 10)) {
                                        moduleNonValideS2.add(note);
                                    }
                                    break;
                                case 3:
                                    count_3++;
                                    modulesS3Nom.add(note.getModuleNom().getNom());
                                    if ((note.getSn() == null || note.getSn() < 10) && (note.getSr() == null || note.getSr() < 10)) {
                                        moduleNonValideS3.add(note);
                                        modulesS3NomNV.add(note.getModuleNom().getNom());
                                    }
                                    break;
                                case 4:
                                    count_4++;
                                    modulesS4Nom.add(note.getModuleNom().getNom());
                                    if ((note.getSn() == null || note.getSn() < 10) && (note.getSr() == null || note.getSr() < 10)) {
                                        moduleNonValideS4.add(note);
                                        modulesS4NomNV.add(note.getModuleNom().getNom());
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (etudiant != null) {
                            if (count_3 != 6 && count_1 != 0 && moduleNonValideS1.size() != 6) {// ajouter S1 & S3
                                n = (moduleNonValideS1.size() <= 2) ? 6 - moduleNonValideS3.size() : 6 - moduleNonValideS1.size() - moduleNonValideS3.size();
                                if (n != 0) {
                                    modules = managerModule.findBy("Semestre", 3);
                                    for (Module module : modules) {
                                        if (!modulesS3Nom.contains(module.getNom()) && n != 0) {
                                            n--;
                                            Note note = new Note();
                                            note.setDateI();
                                            note.setModuleNom(module);
                                            note.setEtudiantCne(etudiant);
                                            managerNote.begin();
                                            managerNote.create(note);
                                            managerNote.commit();
                                        }
                                    }
                                }
                            }
                            if (count_4 != 6 && count_2 != 0  && moduleNonValideS2.size() != 6) {// ajouter S1 & S3
                                n = (moduleNonValideS2.size() <= 2) ? 6 - moduleNonValideS4.size() : 6 - moduleNonValideS2.size() - moduleNonValideS4.size();
                                if (n != 0) {
                                    modules = managerModule.findBy("Semestre", 4);
                                    for (Module module : modules) {
                                        if (!modulesS4Nom.contains(module.getNom()) && n != 0) {
                                            n--;
                                            Note note = new Note();
                                            note.setDateI();
                                            note.setModuleNom(module);
                                            note.setEtudiantCne(etudiant);
                                            managerNote.begin();
                                            managerNote.create(note);
                                            managerNote.commit();
                                        }
                                    }
                                }
                            }
                        } else {
                            request.setAttribute("message", "Ce Etudiant existe deja !");
                        }
                        managerModule.close();
                        managerEtudiant.close();
                        managerNote.close();
                        return "redirect:Reinscription";
                    }
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "InscriptionEtudiant", method = RequestMethod.POST)
    public String inscriptionEtudiant(
            @RequestParam String cne,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    if (cne.equals("")) {
                        return "redirect:/" + object.getClass().getSimpleName();
                    } else {
                        EtudiantRepository managerEtudiant = new EtudiantRepository();
                        ModuleRepository managerModule = new ModuleRepository();
                        NoteRepository managerNote = new NoteRepository();
                        managerEtudiant.open();
                        managerModule.open();
                        managerNote.open();
                        List<Module> modules = managerModule.query("SELECT m FROM Module m WHERE m.semestre = 1 or m.semestre = 2");
                        List<Note> notes = managerNote.findBy("Cne", cne);
                        Etudiant etudiant = managerEtudiant.findById(cne);
                        List<String> modulesOld = new ArrayList();
                        for (Note note : notes) {
                            modulesOld.add(note.getModuleNom().getNom());
                        }
                        if (etudiant != null) {
                            for (Module m : modules) {
                                if (!modulesOld.contains(m.getNom())) {
                                    Note note = new Note();
                                    note.setModuleNom(m);
                                    note.setDateI();
                                    note.setEtudiantCne(etudiant);
                                    managerNote.begin();
                                    managerNote.create(note);
                                    managerNote.commit();
                                }
                            }
                        } else {
                            request.setAttribute("message", "Ce Etudiant n'existe pas deja !");
                        }
                        managerNote.close();
                        managerModule.close();
                        managerEtudiant.close();
                        return "redirect:Inscription";
                    }
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = {"", "index", "home"}, method = {RequestMethod.GET, RequestMethod.POST})
    private String index(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Admin":
                    return object.getClass().getSimpleName() + "/index";
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
            }
        }
        return "redirect:/login";
    }
}
