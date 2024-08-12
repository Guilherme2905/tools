package com.test.tools_challenge.query.api.consulta.handler;

import org.springframework.stereotype.Component;

import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.query.QueryHandler;
import com.test.tools_challenge.query.api.consulta.ConsultarPagamentoQuery;
import com.test.tools_challenge.service.PagamentoService;

@Component
public class ConsultarPagamentoQueryHandler implements QueryHandler<Pagamento, ConsultarPagamentoQuery> {

    private PagamentoService pagamentoService;

    @Override
    public Pagamento execute(ConsultarPagamentoQuery query) {

        Pagamento pagamento = pagamentoService.consultarPagamento(query.getId());

        return pagamento;
    }
}
