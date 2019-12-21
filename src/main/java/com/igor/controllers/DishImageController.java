package com.igor.controllers;

import com.igor.entities.Dish;
import com.igor.repositories.DishRepository;
import com.igor.services.ImageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class DishImageController {

    @Autowired
    ImageService imageService;
    @Autowired
    DishRepository dishRepository;

    static void renderImage(HttpServletResponse response, Byte[] image) throws IOException {
        if (image != null) {
            byte[] byteArray = new byte[image.length];
            int i = 0;

            for (Byte wrappedByte : image) {
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

    @PostMapping("cafe/{id}/image")
    public String handleImagePost(@PathVariable Long id, @RequestParam("imagefile") MultipartFile file) throws IOException {
        imageService.saveImageFile(dishRepository.findById(id).get(), file);
        return "redirect:/recipe/" + id + "/show";
    }

    @GetMapping("cafe/{id}/cafeimage")
    public void renderImageFromDB(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Dish dish = dishRepository.findById(id).get();

        renderImage(response, dish.getImage());
    }
}