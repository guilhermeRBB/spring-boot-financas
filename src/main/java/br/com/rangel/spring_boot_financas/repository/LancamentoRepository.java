package br.com.rangel.spring_boot_financas.repository;

import br.com.rangel.spring_boot_financas.model.Lancamento;
import br.com.rangel.spring_boot_financas.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    @Query("SELECT l FROM Lancamento l WHERE l.usuario.id = :usuarioId " +
           "AND (:mes IS NULL OR MONTH(l.data) = :mes) " +
           "AND (:tipo IS NULL OR l.tipo = :tipo) " +
           "AND (:categoria IS NULL OR l.categoria = :categoria)")
    List<Lancamento> filtrar(
            @Param("usuarioId") Long usuarioId,
            @Param("mes") Integer mes,
            @Param("tipo") Lancamento.Tipo tipo,
            @Param("categoria") String categoria
    );
}
