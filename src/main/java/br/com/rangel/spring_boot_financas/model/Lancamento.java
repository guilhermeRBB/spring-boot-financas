package br.com.rangel.spring_boot_financas.model;

// (JPA) - responsável por mapear a classe para o BD
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

// gera getters, setters, toString, equals e hashCode automaticamente
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "lancamentos")
public class Lancamento {
   
    @Id // PK da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Valor é obrigatório")
    @Positive(message = "Valor deve ser maior que zero")
    private BigDecimal valor;

    private String categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public enum Tipo {
        RECEITA, DESPESA
    }

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;


    @NotNull(message = "Data é obrigatória")
    private LocalDate data;

    @NotNull(message = "Tipo é obrigatório")
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}
