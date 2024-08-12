package com.test.tools_challenge.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cartao;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DescricaoTransacao descricao;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private FormaPagamento formaPagamento;
}
