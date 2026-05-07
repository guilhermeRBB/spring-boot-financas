package br.com.rangel.spring_boot_financas.service;
import br.com.rangel.spring_boot_financas.dto.ResumoDTO;

import br.com.rangel.spring_boot_financas.model.Lancamento;
import br.com.rangel.spring_boot_financas.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.math.BigDecimal;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    public List<Lancamento> listarTodos() {
        return repository.findAll(); // Método pronto JPA
    }

    public Lancamento salvar(Lancamento lancamento) {
        return repository.save(lancamento); // INSERT no bd
    }

    public void deletar(Long id) {
        repository.deleteById(id); // DELETE no banco
    }

    public Lancamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lançamento não encontrado"));
    }

    public List<Lancamento> filtrar(Long usuarioId, Integer mes, Lancamento.Tipo tipo, String categoria) {
        return repository.filtrar(usuarioId, mes, tipo, categoria);
    }

    public List<Lancamento> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public Lancamento atualizar(Long id, Lancamento lancamentoAtualizado) {
        // 1- buscar no banco    
        Lancamento lancamento = buscarPorId(id);

        lancamento.setDescricao(lancamentoAtualizado.getDescricao());
        lancamento.setValor(lancamentoAtualizado.getValor());
        lancamento.setData(lancamentoAtualizado.getData());
        lancamento.setTipo(lancamentoAtualizado.getTipo());
        lancamento.setCategoria(lancamentoAtualizado.getCategoria());

        return repository.save(lancamento);
    }

    public ResumoDTO calcularResumo(Long usuarioId) {
        List<Lancamento> lancamentos = repository.findByUsuarioId(usuarioId);

        BigDecimal receitas = lancamentos.stream()
                .filter(l -> l.getTipo() == Lancamento.Tipo.RECEITA)
                .map(Lancamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal despesas = lancamentos.stream()
                .filter(l -> l.getTipo() == Lancamento.Tipo.DESPESA)
                .map(Lancamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        ResumoDTO resumo = new ResumoDTO();
        resumo.setTotalReceitas(receitas);
        resumo.setTotalDespesas(despesas);
        resumo.setSaldo(receitas.subtract(despesas));
        return resumo;
    }
}
