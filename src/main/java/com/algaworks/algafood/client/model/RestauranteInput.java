package com.algaworks.algafood.client.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RestauranteInput {

    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaIdInput cozinha;
    private EnderecoInput endereco;
    
}