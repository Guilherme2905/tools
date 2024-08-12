package com.test.tools_challenge.query.api.consulta;

import com.test.tools_challenge.domain.Pagamento;
import com.test.tools_challenge.query.Query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultarPagamentoQuery implements Query<Pagamento> {
    private Long id;
}
