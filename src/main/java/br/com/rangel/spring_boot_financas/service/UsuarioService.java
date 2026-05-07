package br.com.rangel.spring_boot_financas.service;

import br.com.rangel.spring_boot_financas.model.Usuario;
import br.com.rangel.spring_boot_financas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    public Usuario cadastrar(Usuario usuario) {

        // verificar se existe user com este email
        repository.findByEmail(usuario.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("Email ja cadastrado");
                });
        return repository.save(usuario);        
    }

    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = buscarPorId(id);
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setSenha(usuarioAtualizado.getSenha());

        return repository.save(usuario);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }
}
