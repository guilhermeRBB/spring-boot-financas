package br.com.rangel.spring_boot_financas.controller;

import br.com.rangel.spring_boot_financas.model.Usuario;
import br.com.rangel.spring_boot_financas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return service.cadastrar(usuario);
    }
}