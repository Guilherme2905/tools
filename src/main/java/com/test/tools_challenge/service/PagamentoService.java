package com.test.tools_challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.exception.PagamentoNotFoundException;
import com.test.tools_challenge.repository.PagamentoRepository;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento save(Pagamento deal) {
        return pagamentoRepository.save(deal);
    }

    public Pagamento consultarPagamento(Long pagamentoId) {
        return pagamentoRepository.findById(pagamentoId).orElseThrow(PagamentoNotFoundException::new);
    }

    public List<Pagamento> consultarTodosOsPagamentos() {
        return pagamentoRepository.findAll();
    }
}