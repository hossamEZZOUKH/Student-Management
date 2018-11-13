package com.spring.controller;

import com.spring.security.Authentication;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hunter
 */
@Controller
@RequestMapping
public class IndexController {

    /**
     * This method handles login GET requests. If users is already logged-in and
     * tries to goto login page again, will be redirected to index page.
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        if (Authentication.isLogin(request)) {
            return "redirect:/";
        } else {
            return "login";
        }
    }

    /**
     * This method handles login POST requests. If users is already logged-in
     * and tries to goto login page again, will be redirected to index page.
     *
     * @param operation
     * @param user
     * @param username
     * @param password
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "operation", defaultValue = "") String operation,
            @RequestParam(value = "user", defaultValue = "") String user,
            @RequestParam(value = "username", defaultValue = "") String username,
            @RequestParam(value = "password", defaultValue = "") String password,
            HttpServletRequest request, Model model) {

        if (operation.equals("login") && !Authentication.isLogin(request)) {
            if (!user.equals("") && !username.equals("") && !password.equals("")) {
                try {
                    Object currentUser = Authentication.login(request, user, username, password);
                    if (currentUser != null) {
                        model.addAttribute("description", "You have been logged in successfully.");
                        model.addAttribute("user", currentUser);
                    } else {
                        model.addAttribute("description", "ERROR : Not requested");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return "redirect:/";
    }

    /**
     * This method handles logout requests. Toggle the handlers if you are
     * RememberMe functionality is useless in your app.
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/";
    }

    /**
     * This method handles logout requests. Toggle the handlers if you are
     * RememberMe functionality is useless in your app.
     *
     * @param operation
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public String logout(@RequestParam(value = "operation", defaultValue = "logout") String operation,
            HttpServletRequest request, Model model) {
        if (operation != null && operation.equals("logout") && Authentication.isLogin(request)) {
            Authentication.logout(request);
            model.addAttribute("description", "you have been logged out successfully.");
        }
        return "redirect:/";
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    @RequestMapping(value = {"", "index", "home"}, method = {RequestMethod.GET, RequestMethod.POST})
    private String index(HttpServletRequest request) {
        Object object = Authentication.getUser(request);

        if (object != null) {
            return "redirect:/" + object.getClass().getSimpleName();
        } else {
            return "redirect:/login";
        }
    }
}
