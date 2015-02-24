package com.capgemini.StarterKit.controller;

import com.capgemini.StarterKit.entities.ZipCode;
import com.capgemini.StarterKit.service.ZipCodeService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import java.util.IllegalFormatException;
import java.util.List;


@Controller
@RequestMapping(value = "/zipCode")
public class ZipCodeController {

    @Autowired
    private ZipCodeService zipCodeService;
    

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<ZipCode> findAllUser() {
        return zipCodeService.findAll();
    }
    
    @RequestMapping(value = "/createP", method = RequestMethod.POST)
    @ResponseBody
    public ZipCode createZipCodePOST (@RequestBody ZipCode zipCode) {
        System.out.println("/+++++++create POST");
        System.out.println(zipCode);
        return zipCodeService.create(zipCode);
    }
    
    @RequestMapping(value = "/createG/{zipCodeS}", method = RequestMethod.GET)
    @ResponseBody
    public String createZipCodeGET (@PathVariable String zipCodeS) {
        System.out.println("/++++++++ create GET");
        ZipCode zipCode = new ZipCode(zipCodeS);
        zipCodeService.create(zipCode);
        return zipCode.toString();
    }
    
    @RequestMapping(value = "/throwIllegalArgumentException")
    public void throwIllegalArgumentException() throws Exception {
        throw  new IllegalArgumentException("throwIllegalArgumentException");
    }

    @RequestMapping(value = "/throwClassCastException")
    public void throwException() throws Exception {
        throw new ClassCastException();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgumentException(Exception e) {
        return "Handled "+e.getLocalizedMessage();
    }
    
    
}
