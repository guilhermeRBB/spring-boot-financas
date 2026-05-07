package br.com.rangel.spring_boot_financas.controller;

import br.com.rangel.spring_boot_financas.model.Usuario;
import br.com.rangel.spring_boot_financas.service.UsuarioService;
import br.com.rangel.spring_boot_financas.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public UsuarioDTO cadastrar(@RequestBody Usuario usuario) {
        return UsuarioDTO.fromEntity(service.cadastrar(usuario));
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return UsuarioDTO.fromEntity(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public UsuarioDTO atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return UsuarioDTO.fromEntity(service.atualizar(id, usuario));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        return service.listarTodos()
                .stream()
                .map(UsuarioDTO::fromEntity)
                .toList();
    }
}