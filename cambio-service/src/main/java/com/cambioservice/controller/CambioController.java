package com.cambioservice.controller;

import com.cambioservice.config.ConfigurationEnv;
import com.cambioservice.model.Cambio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "cambio-service/")
public class CambioController {

    private final ConfigurationEnv ENVS;

    public CambioController(ConfigurationEnv configurationEnv){
        this.ENVS = configurationEnv;
    }

    @GetMapping(value = "{amount}/{from}/{to}")
    public Cambio retornaCambio(

            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to

            ){

        String port = ENVS.returnPort();

        return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, port);
    }

}
