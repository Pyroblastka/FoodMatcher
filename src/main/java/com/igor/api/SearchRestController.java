package com.igor.api;

import com.igor.entities.Ingredient;
import com.igor.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class SearchRestController {

    @Autowired
    IngredientRepository ingredientRepository;

    @RequestMapping("/searchq")
    public List<Ingredient> search(@RequestParam(value = "value") String value) throws IOException {
        try {

            List<Ingredient> ingredients = ingredientRepository.findByNameContainsIgnoreCase(value);

            return ingredients;
        } catch (Exception e) {
            return null;
        }
    }
}
