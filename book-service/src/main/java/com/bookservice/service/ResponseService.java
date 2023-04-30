package com.bookservice.service;

import com.bookservice.response.Cambio;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class ResponseService {


    public static Cambio getCambio(String currency, Double price){

        HashMap<String, String> params = new HashMap<>();

        params.put("to", currency);
        params.put("amount", price.toString());
        params.put("from", "USD");

        return new RestTemplate()
                .getForEntity("http://localhost:8001/cambio-service/" +
                                "{amount}/{from}/{to}",
                                Cambio.class,
                                params)
                .getBody();

    }

}
