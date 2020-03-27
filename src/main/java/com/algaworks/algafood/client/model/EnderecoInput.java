package com.algaworks.algafood.client.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EnderecoInput {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private CidadeIdInput cidade;
    
}