package br.com.academiadev.financeiro.repository;

import br.com.academiadev.financeiro.model.LancamentoFinanceiro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoFinanceiroRepository extends CrudRepository<LancamentoFinanceiro, Long> {
}
