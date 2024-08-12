package com.test.tools_challenge.query.api.consulta.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.query.QueryHandler;
import com.test.tools_challenge.query.api.consulta.ConsultarPagamentosQuery;
import com.test.tools_challenge.service.PagamentoService;

@Component
public class ConsultarPagamentosQueryHandler implements QueryHandler<List<Pagamento>, ConsultarPagamentosQuery> {

    private PagamentoService pagamentoService;

    @Override
    public List<Pagamento> execute(ConsultarPagamentosQuery query) {

        List<Pagamento> pagamentos = pagamentoService.consultarTodosOsPagamentos();

        return pagamentos;
    }
}
