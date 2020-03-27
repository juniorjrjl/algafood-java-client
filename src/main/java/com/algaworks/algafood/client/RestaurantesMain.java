package com.algaworks.algafood.client;

import java.math.BigDecimal;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.model.CidadeIdInput;
import com.algaworks.algafood.client.model.CozinhaIdInput;
import com.algaworks.algafood.client.model.EnderecoInput;
import com.algaworks.algafood.client.model.RestauranteInput;
import com.algaworks.algafood.client.model.RestauranteModel;

import org.springframework.web.client.RestTemplate;

public class RestaurantesMain {

    public static void main(String[] args) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            RestauranteClient restauranteClient = new RestauranteClient(restTemplate, 
                "http://localhost:8080");
            restauranteClient.listar().stream().forEach(r -> System.out.println(r));
        }catch(ClientApiException ex){
            System.out.println(ex.getProblem().isPresent() ? 
                                    ex.getProblem().get() : 
                                    "Erro desconhecido");
        }

        try {

            CozinhaIdInput cozinha = CozinhaIdInput.builder().id(1L).build();
            RestauranteInput restaurante = RestauranteInput.builder()
                .nome("Restaurante do Jão")
                .taxaFrete(new BigDecimal(20.00))
                .cozinha(cozinha)
                .endereco(EnderecoInput.builder()
                    .bairro("bairro 1")
                    .cep("cep 1")
                    .cidade(CidadeIdInput.builder().id(1L).build())
                    .complemento("complemento 1")
                    .logradouro("logradouro 1")
                    .numero("numero 1").build()).build();
            RestTemplate restTemplate = new RestTemplate();
            RestauranteClient restauranteClient = new RestauranteClient(restTemplate, 
                "http://localhost:8080");
            RestauranteModel restauranteAdicionado = restauranteClient.adicionar(restaurante);
            System.out.println(restauranteAdicionado);
        } catch (ClientApiException ex) {
            System.out.println(ex.getProblem().isPresent() ? 
                                    ex.getProblem().get() : 
                                    "Erro desconhecido");
        }
    }
    
}