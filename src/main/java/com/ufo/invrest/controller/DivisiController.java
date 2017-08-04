/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufo.invrest.controller;

import com.ufo.invrest.pojo.Divisi;
import com.ufo.invrest.service.CRUDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Riza
 */
@RestController
@RequestMapping(value="/divisi")
public class DivisiController {
    @Autowired
    private CRUDService CRUDService;
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/nomor/{nomor}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Divisi getDivisiByNomor(@PathVariable("nomor") Integer nomor){
       
        Divisi hasil = (Divisi) CRUDService.GetUniqueEntityByNamedQuery("Divisi.findByNomor", nomor);
       
        return hasil;
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Divisi> getAll(){
        
        List<Divisi> hasil = (List<Divisi>) CRUDService.getAll(Divisi.class);
        return hasil;
    }
   
    
    
    
}
