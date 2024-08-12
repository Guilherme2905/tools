package com.test.tools_challenge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.tools_challenge.command.CommandHandlerDiscovery;
import com.test.tools_challenge.command.api.estorno.EstornarPagamentoCommand;
import com.test.tools_challenge.command.api.pagamento.AddPagamentoCommand;
import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.query.QueryHandlerDiscovery;
import com.test.tools_challenge.query.api.consulta.ConsultarPagamentoQuery;
import com.test.tools_challenge.query.api.consulta.ConsultarPagamentosQuery;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private CommandHandlerDiscovery commandHandlerDiscovery;

    private QueryHandlerDiscovery queryHandlerDiscovery;

    @PutMapping("/estornar-pagamento")
    public Pagamento estornar(@RequestBody EstornarPagamentoCommand command) {
        return commandHandlerDiscovery.lookup(command).execute(command);
    }

    @PostMapping("/gerar-pagamento")
    public Pagamento gerarPagamento(@RequestBody AddPagamentoCommand command) {
        return commandHandlerDiscovery.lookup(command).execute(command);
    }
    
    @GetMapping("/consultar-pagamento")
    public Pagamento consultarPagamento(@RequestBody ConsultarPagamentoQuery query) {
        return queryHandlerDiscovery.lookup(query).execute(query);
    }

    @GetMapping("/consultar-pagamentos")
    public List<Pagamento> consultarPagamentos(@RequestBody ConsultarPagamentosQuery query) {
        return queryHandlerDiscovery.lookup(query).execute(query);
    }

}
