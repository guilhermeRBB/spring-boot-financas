package br.com.rangel.spring_boot_financas.dto;

import br.com.rangel.spring_boot_financas.model.Lancamento;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LancamentoDTO {
    
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private String tipo;
    private String categoria;
    private Long usuarioId;
    private String usuarioNome;

    // converte ent Lancamento pra DTO
    public static LancamentoDTO fromEntity(Lancamento lancamento) {
        LancamentoDTO dto = new LancamentoDTO();
        dto.setId(lancamento.getId());
        dto.setDescricao(lancamento.getDescricao());
        dto.setValor(lancamento.getValor());
        dto.setData(lancamento.getData());
        dto.setTipo(lancamento.getTipo().name());
        dto.setCategoria(lancamento.getCategoria());

        if(lancamento.getUsuario() != null) {
            dto.setUsuarioId(lancamento.getUsuario().getId());
            dto.setUsuarioNome(lancamento.getUsuario().getNome());    
        }

        return dto;
    }
}