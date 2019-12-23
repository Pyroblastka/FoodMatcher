package com.igor.controllers;


import com.igor.entities.Cafe;
import com.igor.entities.Dish;
import com.igor.entities.Ingredient;
import com.igor.repositories.CafeRepository;
import com.igor.repositories.DishRepository;
import com.igor.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Controller
public class CafeController {

    @Autowired
    CafeRepository cafeRepository;
    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    DishRepository dishRepository;

    @GetMapping("/addcafe")
    public String getCafeForm(Model model) {
        model.addAttribute("defaultCafe",new Cafe());
        return "/cafeform";
    }

    @PostMapping("/addcafe")
    public String addCafe(@ModelAttribute("cafe") Cafe cafe,  @RequestParam("img") MultipartFile image,Model model) throws IOException {
        cafe.setImage(image);
        cafeRepository.saveAndFlush(cafe);
        //model.addAttribute("cafies", cafeRepository.findAll());
        return "redirect:/index";
    }

    @GetMapping("/cafe/{id}/menu")
    public String getCafeMenu(@PathVariable Long id,  Model model) {
        Cafe cafe = cafeRepository.findById(id).get();
        model.addAttribute("dishes",cafe.getDishes());
        return "/menu";
    }

    @GetMapping("/cafe/{id}/newdish")
    public String getNewDishForm(@PathVariable Long id,  Model model) {
        Cafe cafe = cafeRepository.findById(id).get();
        model.addAttribute("cafe",cafe);
        return "/dishform";
    }

    @PostMapping("/cafe/{id}/newdish")
    public String addNewDish(@PathVariable Long id, @RequestParam("name") String name,
                             @RequestParam("img") MultipartFile image,
                             @RequestParam("ingredients") List<String> ingrs, Model model) throws IOException {
        Cafe cafe = cafeRepository.findById(id).get();

        Dish dish = new Dish();
        dish.setName(name);
        dish.setImage(image);

        for(String i: ingrs) {
            Ingredient ingredient = ingredientRepository.findByName(i);
            if(ingredient==null) {
                ingredient = new Ingredient(i);
                ingredientRepository.saveAndFlush(ingredient);
            }
            dish.addIngredient(ingredient);
        }
        dishRepository.saveAndFlush(dish);
        cafe.addDish(dish);
        cafeRepository.saveAndFlush(cafe);
        model.addAttribute("cafe",cafe.getId());
        return "redirect:/cafe/"+cafe.getId()+"/menu";
    }
}
