package com.test.tools_challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.tools_challenge.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}