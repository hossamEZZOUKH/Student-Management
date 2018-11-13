/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller;

import com.spring.entities.Enseignant;
import com.spring.entities.Etudiant;
import com.spring.entities.Module;
import com.spring.entities.Note;
import com.spring.security.Authentication;
import com.spring.repository.EtudiantRepository;
import com.spring.repository.ModuleRepository;
import com.spring.repository.NoteRepository;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author hunter
 */
@Controller
@RequestMapping("Etudiant")
public class EtudiantController {

    private final EtudiantRepository manager;

    public EtudiantController() {
        this.manager = new EtudiantRepository();
    }

    @RequestMapping(value = "Moyenne", method = {RequestMethod.GET, RequestMethod.POST})
    public String moyenne(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    manager.open();
                    Etudiant etudiant = (Etudiant) object;
                    NoteRepository managerNote = new NoteRepository();
                    managerNote.open();
                    request.setAttribute("Notes", managerNote.findBy("Cne", etudiant.getCne()));
                    managerNote.close();
                    manager.close();
                    return "Etudiant/moyenne";
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "Attestation", method = {RequestMethod.GET, RequestMethod.POST})
    public String attestation(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    manager.open();
                    Etudiant etudiant = (Etudiant) object;
                    NoteRepository managerNote = new NoteRepository();
                    managerNote.open();
                    request.setAttribute("Notes", managerNote.findBy("Cne", etudiant.getCne()));
                    manager.close();
                    return "Etudiant/attestation";
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "RDN", method = {RequestMethod.GET, RequestMethod.POST})
    public String RDN(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    NoteRepository managerNote = new NoteRepository();
                    managerNote.open();
                    request.setAttribute("Notes", managerNote.findBy("Cne", ((Etudiant) object).getCne()));
                    managerNote.open();
                    return "Etudiant/RDN";

                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "XML", method = {RequestMethod.GET, RequestMethod.POST})
    public String XML(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Etudiant":
                    NoteRepository managerNote = new NoteRepository();
                    managerNote.open();
                    request.setAttribute("Notes", managerNote.findBy("Cne", ((Etudiant) object).getCne()));
                    managerNote.open();
                    return "Etudiant/RNXML";

                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = {"", "index", "home"}, method = {RequestMethod.GET, RequestMethod.POST})
    private String index(HttpServletRequest request
    ) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Admin":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Etudiant":
                    return object.getClass().getSimpleName() + "/index";
                case "Enseignant":
                    return "redirect:/" + object.getClass().getSimpleName();
            }
        }
        return "redirect:/login";
    }

}
