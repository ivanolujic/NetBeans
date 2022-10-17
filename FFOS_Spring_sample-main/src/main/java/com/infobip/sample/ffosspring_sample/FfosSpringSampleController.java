package com.infobip.sample.ffosspring_sample;

import com.google.gson.Gson;
import edunova.controller.ObradaSmjer;
import edunova.model.Smjer;
import edunova.util.EdunovaException;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController  // ready for use by Spring MVC to handle web requests
public class FfosSpringSampleController {

    private static final String BASE_URL = "https://api.infobip.com";
    private static final String API_KEY = "API KEY";

    @Value("${phone.numbers}")
    private String numbers;

    @GetMapping("/hello")
    public String index() {
        return "Pozdrav Edunova";
    }

    @GetMapping("/smjerovi")
    public String listaSmjerova() {
        ObradaSmjer os = new ObradaSmjer();
        Smjer s;
        for (int i = 0; i < 10; i++) {
            s = new Smjer();
            s.setNaziv("Java programiranje " + i);
            s.setCijena(BigDecimal.TEN);
            os.setEntitet(s);
            try {
                os.create();
            } catch (EdunovaException ex) {
                System.out.println(ex.getPoruka());
            }
        }

        return new Gson().toJson(os.read());
    }

    private String[] useAsArray(String numbers) {
        if (numbers != null && numbers.trim().isEmpty()) {
            return numbers.split(",");
        }
        return null;
    }

}
