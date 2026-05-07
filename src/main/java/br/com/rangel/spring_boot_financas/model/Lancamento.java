package br.com.rangel.spring_boot_financas.model;

// (JPA) - responsável por mapear a classe para o BD
import jakarta.persistence.*;

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

    private String descricao;
    private BigDecimal valor;
    private LocalDate data;

    @Enumerated(EnumType.STRING) 
    private Tipo tipo;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public enum Tipo {
        RECEITA, DESPESA
    }
}
