package com.josiasmartins.SSO_azure.controller;

import com.josiasmartins.SSO_azure.domain.model.DevoncaModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestSSOController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public DevoncaModel test(Authentication authentication) {
        DevoncaModel devoncaModel = new DevoncaModel();
        devoncaModel.setName("test");
        devoncaModel.setCurrent(false);
        return devoncaModel; // Retorna o objeto como JSON
    }
}
