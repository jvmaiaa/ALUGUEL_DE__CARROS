package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.CepDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class EnderecoService {

    private final String VIA_CEP_URL = "https://viacep.com.br/ws/";

    private final RestTemplate restTemplate;

    public CepDTO consultaCep(String cep){
        String url = VIA_CEP_URL + cep + "/json";
        return restTemplate.getForObject(url, CepDTO.class);
    }

}
