package com.igor.controllers;


import com.igor.entities.Cafe;
import com.igor.repositories.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class CafeController {

    @Autowired
    CafeRepository cafeRepository;

    @GetMapping("/addcafe")
    public String getCafeForm(Model model) {
        model.addAttribute("defaultCafe",new Cafe());
        return "cafeform";
    }

    @PostMapping("/addcafe")
    public String addCafe(@ModelAttribute("cafe") Cafe cafe,  @RequestParam("img") MultipartFile image,Model model) throws IOException {
        cafe.setImage(image);
        cafeRepository.saveAndFlush(cafe);
        //model.addAttribute("cafies", cafeRepository.findAll());
        return "redirect:/index";
    }
}
