package com.test.tools_challenge;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.repository.PagamentoRepository;

@SpringBootTest
@ActiveProfiles("test")
public class ConsultarTransacoesTest {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Test
    public void testSaveAndFind() {
        List<Pagamento> found = pagamentoRepository.findAll();

        assertNotNull(found);
    }
}