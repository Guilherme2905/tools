package com.test.tools_challenge;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.test.tools_challenge.domain.DescricaoTransacao;
import com.test.tools_challenge.domain.FormaPagamento;
import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.repository.PagamentoRepository;
import com.test.tools_challenge.usecase.pagamento.ProcessarPagamentoUseCase;

@SpringBootTest
@ActiveProfiles("test")
public class ConsultarTransacaoTest {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProcessarPagamentoUseCase processarPagamentoUseCase;

    @Test
    public void testSaveAndFind() {
        Pagamento pagamento = new Pagamento();
        pagamento.setCartao("123456789");

        DescricaoTransacao descricao = new DescricaoTransacao();
        descricao.setValor(100.0);
        pagamento.setDescricao(descricao);

        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setParcelas(1);
        pagamento.setFormaPagamento(formaPagamento);

        pagamentoRepository.save(pagamento);

        processarPagamentoUseCase.processar(pagamento.getId());

        Pagamento found = pagamentoRepository.findById(pagamento.getId()).orElse(null);

        assertNotNull(found);
    }
}