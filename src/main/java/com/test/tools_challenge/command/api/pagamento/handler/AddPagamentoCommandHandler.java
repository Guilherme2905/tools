package com.test.tools_challenge.command.api.pagamento.handler;

import org.springframework.stereotype.Component;

import com.test.tools_challenge.command.CommandHandler;
import com.test.tools_challenge.command.api.pagamento.AddPagamentoCommand;
import com.test.tools_challenge.domain.DescricaoTransacao;
import com.test.tools_challenge.domain.FormaPagamento;
import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.service.PagamentoService;
import com.test.tools_challenge.usecase.pagamento.ProcessarPagamentoUseCase;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@Transactional
public class AddPagamentoCommandHandler implements CommandHandler<Pagamento, AddPagamentoCommand> {

    private PagamentoService pagamentoService;

    private ProcessarPagamentoUseCase processarPagamentoUseCase;

    @Override
    @Transactional
    public Pagamento execute(AddPagamentoCommand command) {

        try {

            DescricaoTransacao descricaoTransacao = DescricaoTransacao.builder()
                .valor(command.getValor())
                .dataHora(command.getDataHora())
                .estabelecimento(command.getEstabelecimento())
                .build();
    
            FormaPagamento formaPagamento = FormaPagamento.builder()
                .tipoTransacao(command.getTipo())
                .parcelas(command.getParcelas())
                .build();
    
            Pagamento pagamento = Pagamento.builder()
                .cartao(command.getCartao())
                .descricao(descricaoTransacao)
                .formaPagamento(formaPagamento)
                .build();
    
            pagamentoService.save(pagamento);

            processarPagamentoUseCase.processar(pagamento.getId());
    
            return pagamento;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

}
