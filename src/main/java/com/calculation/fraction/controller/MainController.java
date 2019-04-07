package com.calculation.fraction.controller;

import com.calculation.fraction.Fraction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping()
public class MainController {

    @GetMapping("/healthcheck")
    public String healthcheck() {
        return "{\"status\":\"UP\"}";
    }

    @PostMapping("/calc")
    public Map<String, String> calculate(@RequestBody String equation){
        Fraction fraction = new Fraction();
        String result = fraction.calculateFraction(equation);
        Map<String, String> fractionResult = new HashMap<>();
        fractionResult.put("equation", equation);
        fractionResult.put("result", result);
        return fractionResult;
    }
}
