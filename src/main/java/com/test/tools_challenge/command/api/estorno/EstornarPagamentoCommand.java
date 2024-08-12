package com.test.tools_challenge.command.api.estorno;

import com.test.tools_challenge.command.Command;
import com.test.tools_challenge.domain.Pagamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstornarPagamentoCommand implements Command<Pagamento> {

    private Long id;

}
