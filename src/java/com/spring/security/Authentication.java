/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.security;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hunter
 */
public class Authentication {

    public static Object login(HttpServletRequest request, @NotNull String user, @NotNull String username, @NotNull String password)
            throws SQLException {
        String table = user.equals("admin")
                ? "Admin" : user.equals("enseignant")
                        ? "Enseignant" : user.equals("etudiant")
                                ? "Etudiant" : "";

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MasterM2IPU");
        EntityManager em = emf.createEntityManager();

        List<Object> objects = em.createQuery("SELECT e FROM " + table + " e WHERE e." + (table.equals("Etudiant") ? "cne" : "cin") + " = :username AND e.password = :password")
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();

        em.close();
        emf.close();
        
        
        if (objects != null && objects.size() > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("user", objects.get(0));
            return objects.get(0);
        }
        
        return null;
    }

    public static boolean isLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object user = (Object) session.getAttribute("user");
        return user != null;
    }

    public static boolean isLogin(HttpServletRequest request, @NotNull Class use) {
        HttpSession session = request.getSession();
        Object user = (Object) session.getAttribute("user");
        return user != null && user.getClass().getSimpleName().equals(use.getSimpleName());
    }

    public static Object getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object user = (Object) session.getAttribute("user");
        return user;
    }

    public static void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
    }
}
