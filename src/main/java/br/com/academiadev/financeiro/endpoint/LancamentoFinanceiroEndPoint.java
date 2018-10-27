package br.com.academiadev.financeiro.endpoint;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.financeiro.model.LancamentoFinanceiro;
import br.com.academiadev.financeiro.model.Usuario;
import br.com.academiadev.financeiro.model.TipoLancamento;
import br.com.academiadev.financeiro.model.Status;
import br.com.academiadev.financeiro.repository.UsuarioRepository;
import br.com.academiadev.financeiro.repository.LancamentoFinanceiroRepository;

@RestController
@RequestMapping
public class LancamentoFinanceiroEndPoint {

	@Autowired
	private LancamentoFinanceiroRepository lancamentoRepository;

	@PostMapping("/lancamentoFinanceiro")
    public void save(@RequestBody LancamentoFinanceiro lancamentoFinanceiro) {
		lancamentoRepository.save(lancamentoFinanceiro);
    }
	
	@GetMapping("/lancamentoFinanceiro")
	public List<LancamentoFinanceiro> buscarLancamentos() {
		return toList(lancamentoRepository.findAll());
	}

	public <E> List<E> toList(Iterable<E> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}

}
