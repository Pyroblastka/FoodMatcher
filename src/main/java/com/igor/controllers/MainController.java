package com.igor.controllers;

import com.igor.entities.Cafe;
import com.igor.repositories.CafeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    CafeRepository cafeRepository;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model){
        List<Cafe> cafies = cafeRepository.findAll();
        model.addAttribute("cafies", cafies);
        return "index";
    }

    @GetMapping("menu")
    public String menu(){
        return "menu";
    }

}
