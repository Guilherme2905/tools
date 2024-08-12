package com.test.tools_challenge.command.api.pagamento;

import java.time.LocalDateTime;

import com.test.tools_challenge.command.Command;
import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.enums.TipoTransacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPagamentoCommand implements Command<Pagamento> {

    private String cartao;
    private double valor;
    private LocalDateTime dataHora;
    private String estabelecimento;
    private TipoTransacao tipo;
    private int parcelas;

}
