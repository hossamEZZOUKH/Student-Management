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
import com.spring.repository.EnseignantRepository;
import com.spring.repository.EtudiantRepository;
import com.spring.repository.ModuleRepository;
import com.spring.repository.NoteRepository;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.SimpleTimeZone;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hunter
 */
@Controller
@RequestMapping("Enseignant")
public class EnseignantController {

    private final EnseignantRepository manager;

    public EnseignantController() {
        this.manager = new EnseignantRepository();
    }

    @RequestMapping(value = {"", "index", "home"}, method = {RequestMethod.GET, RequestMethod.POST})
    private String index(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Enseignant":
                    Enseignant enseignant = (Enseignant) object;
                    ModuleRepository managerModule = new ModuleRepository();
                    managerModule.open();
                    request.setAttribute("Modules", managerModule.findBy("Ns", enseignant.getNs()));
                    managerModule.close();
                    return object.getClass().getSimpleName() + "/index";
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/" + object.getClass().getSimpleName();
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "XML", method = {RequestMethod.GET, RequestMethod.POST})
    private String getXML(HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Enseignant":
                    Enseignant enseignant = (Enseignant) object;
                    ModuleRepository managerModule = new ModuleRepository();
                    managerModule.open();
                    request.setAttribute("Modules", managerModule.findBy("Ns", enseignant.getNs()));
                    managerModule.close();
                    return object.getClass().getSimpleName() + "/xml";
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/" + object.getClass().getSimpleName();
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "XML={module}", method = {RequestMethod.GET, RequestMethod.POST})
    private String getXML(
            @PathVariable("module") String module,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Enseignant":
                    if (module == null || module.equals("")) {
                        return "redirect:/" + object.getClass().getSimpleName();
                    } else {
                        Enseignant enseignant = (Enseignant) object;
                        ModuleRepository managerModule = new ModuleRepository();
                        managerModule.open();
                        Module m = managerModule.findById(module);
                        managerModule.close();
                        if (m != null && enseignant.getNs().equals(m.getEnseignantNs().getNs())) {
                            NoteRepository managerNote = new NoteRepository();
                            managerNote.open();
                            List<Note> notes = managerNote.findBy("NomModule", module);
                            request.setAttribute("Notes", notes);
                            managerNote.close();
                            return object.getClass().getSimpleName() + "/xmlModule";
                        } else {
                            return "redirect:/" + object.getClass().getSimpleName();
                        }
                    }
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/" + object.getClass().getSimpleName();
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "ConsulterModule={module}", method = {RequestMethod.GET, RequestMethod.POST})
    private String consulterModule(
            @PathVariable("module") String module,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Enseignant":
                    if (module.equals("")) {
                        return "redirect:/" + object.getClass().getSimpleName();
                    } else {
                        NoteRepository managerNote = new NoteRepository();
                        managerNote.open();
                        request.setAttribute("Notes", managerNote.findBy("NomModule", module));
                        managerNote.close();
                        return object.getClass().getSimpleName() + "/consulterModule";
                    }
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/" + object.getClass().getSimpleName();
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "InsertNote={module}", method = {RequestMethod.GET, RequestMethod.POST})
    private String InsertNote(
            @PathVariable String module,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Enseignant":
                    if (module.equals("")) {
                        return "redirect:/" + object.getClass().getSimpleName();
                    } else {
                        NoteRepository managerNote = new NoteRepository();
                        managerNote.open();
                        request.setAttribute("Notes", managerNote.findBy("NomModule", module));
                        managerNote.close();
                        return object.getClass().getSimpleName() + "/updateNote";
                    }
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/" + object.getClass().getSimpleName();
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "UpdateNoteEtudiant", method = {RequestMethod.GET, RequestMethod.POST})
    private String updateNoteEtudiant(
            @RequestParam(required = false) String module,
            @RequestParam(required = false) String cne,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Enseignant":
                    if (module == null || cne == null || module.equals("") || cne.equals("")) {
                        return "redirect:/" + object.getClass().getSimpleName();
                    } else {
                        NoteRepository managerNote = new NoteRepository();
                        managerNote.open();
                        List<Note> notes = managerNote.findBy("Cne", cne);
                        for (Note note : notes) {
                            if (note.getModuleNom().getNom().equals(module)) {
                                request.setAttribute("Note", note);
                                break;
                            }
                        }
                        managerNote.close();
                        return object.getClass().getSimpleName() + "/updateNoteEtudiant";
                    }
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/" + object.getClass().getSimpleName();
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "UpdateNoteConsulter", method = {RequestMethod.GET, RequestMethod.POST})
    private String updateNoteConsulter(
            @RequestParam(required = false) String module,
            @RequestParam(required = false) String cne,
            @RequestParam(required = false) Double sn,
            @RequestParam(required = false) Double sr,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Enseignant":
                    if (module == null || cne == null || module.equals("") || cne.equals("")) {
                        return "redirect:/" + object.getClass().getSimpleName();
                    } else {
                        NoteRepository managerNote = new NoteRepository();
                        managerNote.open();
                        List<Note> notes = managerNote.findBy("Cne", cne);
                        for (Note note : notes) {
                            if (note.getModuleNom().getNom().equals(module)) {
                                managerNote.begin();
                                note.setDateI(Calendar.getInstance().getTime());
                                note.setSn(sn);
                                note.setSr(sr);
                                managerNote.update(note);
                                managerNote.commit();
                                request.setAttribute("Note", note);
                                break;
                            }
                        }
                        managerNote.close();
                        return "redirect:ConsulterModule=" + module;
                    }
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/" + object.getClass().getSimpleName();
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "UpdateNote", method = {RequestMethod.GET, RequestMethod.POST})
    private String updateNote(
            @RequestParam(required = false) String module,
            @RequestParam(required = false) String cne,
            @RequestParam(required = false) Double sn,
            @RequestParam(required = false) Double sr,
            HttpServletRequest request) {
        Object object = Authentication.getUser(request);
        if (object != null) {
            switch (object.getClass().getSimpleName()) {
                case "Enseignant":
                    if (module == null || cne == null || module.equals("") || cne.equals("")) {
                        return "redirect:/" + object.getClass().getSimpleName();
                    } else {
                        NoteRepository managerNote = new NoteRepository();
                        managerNote.open();
                        List<Note> notes = managerNote.findBy("Cne", cne);
                        for (Note note : notes) {
                            if (note.getModuleNom().getNom().equals(module)) {
                                managerNote.begin();
                                note.setDateI(Calendar.getInstance().getTime());
                                note.setSn(sn);
                                note.setSr(sr);
                                managerNote.update(note);
                                managerNote.commit();
                                request.setAttribute("Note", note);
                                break;
                            }
                        }
                        managerNote.close();
                        return "redirect:/" + object.getClass().getSimpleName() + "/InsertNote=" + module;
                    }
                case "Etudiant":
                    return "redirect:/" + object.getClass().getSimpleName();
                case "Admin":
                    return "redirect:/" + object.getClass().getSimpleName();
            }
        }
        return "redirect:/login";
    }
}
