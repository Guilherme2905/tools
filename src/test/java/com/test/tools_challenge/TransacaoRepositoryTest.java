package com.test.tools_challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.test.tools_challenge.domain.DescricaoTransacao;
import com.test.tools_challenge.domain.FormaPagamento;
import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.repository.PagamentoRepository;

@SpringBootTest
@ActiveProfiles("test")
public class TransacaoRepositoryTest {

    @Autowired
    private PagamentoRepository pagamentoRepository;

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

        Pagamento found = pagamentoRepository.findById(pagamento.getId()).orElse(null);

        assertNotNull(found);
        assertEquals("123456789", found.getCartao());
        assertEquals(100.0, found.getDescricao().getValor());
    }
}