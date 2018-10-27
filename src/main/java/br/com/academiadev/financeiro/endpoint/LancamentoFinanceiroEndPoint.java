package br.com.academiadev.financeiro.endpoint;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	private UsuarioRepository usuarioRepository;

	@Autowired
	private LancamentoFinanceiroRepository lancamentoRepository;

	@GetMapping("/lancamento/save")
	public String helloWord() {
		Usuario usuario = new Usuario();
		usuario.setEmail("docsbruno@gmail.com");
		usuario.setNome("Bruno Muehlbauer");
		usuario.setSenha("12345678");
		usuarioRepository.save(usuario);

		LancamentoFinanceiro lancamento = new LancamentoFinanceiro();
		lancamento.setDataCriacao(LocalDate.now());
		lancamento.setDataEmissao(LocalDate.now());
		lancamento.setDataVencimento(LocalDate.now());
		lancamento.setDataCriacao(LocalDate.now());
		lancamento.setValor(new BigDecimal("1115.37"));
		lancamento.setUsuario(usuario);
		lancamento.setRecebedorPagador("Vinicius");
		lancamento.setStatus(Status.PAGO);
		lancamento.setTipolancamento(TipoLancamento.RECEBER);

		lancamentoRepository.save(lancamento);
		return "Lancamento criado";
	}

	@GetMapping("/lancamento")
	public List<LancamentoFinanceiro> buscarLancamentos() {
		return toList(lancamentoRepository.findAll());
	}

	public <E> List<E> toList(Iterable<E> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}

}
