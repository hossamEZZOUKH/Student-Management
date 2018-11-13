/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller;

import com.spring.entities.Etudiant;
import java.util.List;

/**
 *
 * @author hunter
 */
public class AjaxResponseBody {

    //@JsonView(Views.Public.class)
    String msg;

    //@JsonView(Views.Public.class)
    String code;

    //@JsonView(Views.Public.class)
    List<Etudiant> result;
}
