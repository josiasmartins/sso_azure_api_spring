package com.josiasmartins.SSO_azure.controller;

import com.josiasmartins.SSO_azure.domain.model.DevoncaModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/")
public class TestSSOController {

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public DevoncaModel test() {
//
//        DevoncaModel devoncaModel = new DevoncaModel();
//        devoncaModel.setName("test");
//        devoncaModel.setCurrent(false);
//
//        return devoncaModel;
//
//    }

    public String index(Model model, Authentication user) {
        model.addAttribute("user", user);

        return "http://localhost/all";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public String test() {

        return "http://localhost/all";
    }
}
