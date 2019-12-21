package com.igor.services;

import com.igor.entities.Cafe;
import com.igor.entities.Dish;
import com.igor.repositories.CafeRepository;
import com.igor.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Component
public class ImageService {

    @Autowired
    CafeRepository cafeRepository;
    @Autowired
    DishRepository dishRepository;

    @Transactional
    public void saveImageFile(Cafe cafe, MultipartFile file) throws IOException {
        cafe.setImage(file);
        cafeRepository.save(cafe);
    }

    @Transactional
    public void saveImageFile(Dish dish, MultipartFile file) throws IOException {
        dish.setImage(file);
        dishRepository.save(dish);
    }
}
