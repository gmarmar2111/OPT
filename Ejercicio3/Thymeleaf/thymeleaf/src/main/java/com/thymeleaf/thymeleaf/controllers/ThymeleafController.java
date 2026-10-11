package com.thymeleaf.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {

    @GetMapping("/elegir")
    public String elegir(@RequestParam(name = "idioma", required = false) String idioma) {
        try {
            if (idioma.equals("espanyol")) {
                return "redirect:/espanyol.html";
            } else if (idioma.equals("ingles")) {
                return "redirect:/ingles.html";
            } else if (idioma.equals("aleman")) {
                return "redirect:/aleman.html";
            } else if (idioma.equals("japones")) {
                return "redirect:/japones.html";
            }
            else {
                return "redirect:/ingles.html";
            }

        }catch(NullPointerException e){
            return "redirect:/ingles.html";
        }
    }
}
