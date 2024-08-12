package com.test.tools_challenge.domain;

import java.time.LocalDateTime;

import com.test.tools_challenge.enums.Status;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Embeddable
public class DescricaoTransacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pagamento pagamento;

    private double valor;
    private LocalDateTime dataHora;
    private String estabelecimento;
    private int nsu;
    private int codigoAutorizacao;

    @Enumerated(EnumType.STRING)
    private Status status;
}
