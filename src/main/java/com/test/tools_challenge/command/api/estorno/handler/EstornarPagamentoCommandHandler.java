package com.test.tools_challenge.command.api.estorno.handler;

import org.springframework.stereotype.Component;

import com.test.tools_challenge.command.CommandHandler;
import com.test.tools_challenge.command.api.estorno.EstornarPagamentoCommand;
import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.enums.Status;
import com.test.tools_challenge.repository.PagamentoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@Transactional
public class EstornarPagamentoCommandHandler implements CommandHandler<Pagamento, EstornarPagamentoCommand> {

    private PagamentoRepository pagamentoRepository;

    @Override
    @Transactional
    public Pagamento execute(EstornarPagamentoCommand command) {

        try {

            Pagamento pagamento = pagamentoRepository.findById(command.getId()).orElseThrow();
    
            pagamento.getDescricao().setStatus(Status.CANCELADO);
    
            pagamentoRepository.save(pagamento);

            return pagamento;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

}
