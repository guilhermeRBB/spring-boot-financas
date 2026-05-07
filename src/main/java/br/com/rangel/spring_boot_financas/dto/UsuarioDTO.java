package br.com.rangel.spring_boot_financas.dto;

import br.com.rangel.spring_boot_financas.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;

    public static UsuarioDTO fromEntity(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }
}