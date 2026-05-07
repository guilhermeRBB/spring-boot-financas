package br.com.rangel.spring_boot_financas.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ResumoDTO {

    private BigDecimal totalReceitas;
    private BigDecimal totalDespesas;
    private BigDecimal saldo;

}