package com.algaworks.algafood.client.api;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import com.algaworks.algafood.client.model.RestauranteInput;
import com.algaworks.algafood.client.model.RestauranteModel;
import com.algaworks.algafood.client.model.RestauranteResumoModel;

import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestauranteClient {

    private static String RESOURCE_PATH = "/restaurantes";
    private RestTemplate restTemplate;
    private String url;

    public List<RestauranteResumoModel> listar(){
        try{
            URI resourceUri = URI.create(url + RESOURCE_PATH);
            RestauranteResumoModel[] restaurenates = restTemplate
                .getForObject(resourceUri, RestauranteResumoModel[].class);
            return Arrays.asList(restaurenates);
        }catch(RestClientResponseException ex){
            throw new ClientApiException(ex.getMessage(), ex);
        }
    }
    
    public RestauranteModel adicionar(RestauranteInput restaurante){
        try{
            URI resourceUri = URI.create(url + RESOURCE_PATH);
            RestauranteModel restauranteCadastrado = restTemplate
                .postForObject(resourceUri, restaurante, RestauranteModel.class);
            return restauranteCadastrado;
        }catch(RestClientResponseException ex){
            throw new ClientApiException(ex.getMessage(), ex);
        }
    }

}