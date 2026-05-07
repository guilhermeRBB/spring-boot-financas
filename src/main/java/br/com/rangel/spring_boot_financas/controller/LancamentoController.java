package br.com.rangel.spring_boot_financas.controller;

import br.com.rangel.spring_boot_financas.dto.LancamentoDTO;
import br.com.rangel.spring_boot_financas.model.Lancamento;
import br.com.rangel.spring_boot_financas.controller.LancamentoController;
import br.com.rangel.spring_boot_financas.dto.ResumoDTO;
import br.com.rangel.spring_boot_financas.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService service;

    @GetMapping
    public List<LancamentoDTO> listarTodos() {
        return service.listarTodos()
                .stream()
                .map(LancamentoDTO::fromEntity)
                .toList();
    }

    @PostMapping
    public LancamentoDTO salvar(@RequestBody Lancamento lancamento) {
        return LancamentoDTO.fromEntity(service.salvar(lancamento));
    }

    @GetMapping("/{id}")
    public LancamentoDTO buscarPorId(@PathVariable Long id) {
        return LancamentoDTO.fromEntity(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public LancamentoDTO atualizar(@PathVariable Long id, @RequestBody Lancamento lancamento) {
        return LancamentoDTO.fromEntity(service.atualizar(id, lancamento));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<LancamentoDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return service.listarPorUsuario(usuarioId)
                .stream()
                .map(LancamentoDTO::fromEntity)
                .toList();
    }

    @GetMapping("/filtrar")
    public List<LancamentoDTO> filtrar(
        @RequestParam Long usuarioId,
        @RequestParam(required = false) Integer mes,
        @RequestParam(required = false) Lancamento.Tipo tipo,
        @RequestParam(required = false) String categoria) {

        return service.filtrar(usuarioId, mes, tipo, categoria)
            .stream()
            .map(LancamentoDTO::fromEntity)
            .toList();
    }

    @GetMapping("/resumo/{usuarioId}")
    public ResumoDTO resumo(@PathVariable Long usuarioId) {
        return service.calcularResumo(usuarioId);
    }
}