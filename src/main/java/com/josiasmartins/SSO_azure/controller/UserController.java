package com.josiasmartins.SSO_azure.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Authentication getUser(Authentication authentication) {
        // Exemplo de como retornar detalhes do usuário autenticado
        return authentication; // Retorna o objeto de autenticação como JSON
    }
}
