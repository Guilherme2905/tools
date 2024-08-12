package com.test.tools_challenge.usecase.pagamento;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.enums.Status;
import com.test.tools_challenge.exception.ProcessarPagamentoException;
import com.test.tools_challenge.repository.PagamentoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Component
@Slf4j
public class ProcessarPagamentoUseCase {

    private PagamentoRepository pagamentoRepository;

    @Transactional
    public void processar(Long pagamentoId) {
        try {
            Random random = new Random();
            boolean autorizado = random.nextBoolean();

            Pagamento pagamento = pagamentoRepository.findById(pagamentoId).orElseThrow();

            if (autorizado) {
                pagamento.getDescricao().setCodigoAutorizacao(4213125);
                pagamento.getDescricao().setNsu(59421);
                pagamento.getDescricao().setStatus(Status.AUTORIZADO);
            } else {
                pagamento.getDescricao().setCodigoAutorizacao(14523124);
                pagamento.getDescricao().setNsu(1234);
                pagamento.getDescricao().setStatus(Status.NEGADO);
            }

            pagamentoRepository.save(pagamento);

        } catch (Throwable e) {
            log.error("Erro ao processar pagamento: {}", e.getMessage(), e);
            throw new ProcessarPagamentoException();
        }
    }
}
