package com.igor.api;

import com.igor.entities.Cafe;
import com.igor.repositories.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CafeController {

    @Autowired
    CafeRepository cafeRepository;

    @RequestMapping("/addcafe")
    Object addcafe(@RequestParam(value = "name") String name,
                   @RequestParam(value = "address") String address) {
        Cafe cafe = new Cafe(name, address);
        cafeRepository.saveAndFlush(cafe);
        return "done";
    }

    @RequestMapping("/getcafe")
    public List<Cafe> getall(@RequestParam(value = "name", required = false) String name) throws IOException {
        if (name != null) {
            return cafeRepository.findByName(name);
        }
        return cafeRepository.findAll();
    }

    @RequestMapping("/getcafe/{id}")
    public Cafe getcafe(@PathVariable(value = "id") Long id) throws IOException {
        return cafeRepository.findById(id).get();
    }

    @RequestMapping("/deletecafe")
    Object deletecafe(@RequestParam(value = "id", required = false) Long id) {
        if(id==null) {
            return "no required param \"id\"";
        }
        cafeRepository.deleteById(id);
        return "done";
    }
}
