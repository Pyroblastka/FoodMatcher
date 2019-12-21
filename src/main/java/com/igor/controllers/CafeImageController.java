package com.igor.controllers;

import com.igor.entities.Cafe;
import com.igor.repositories.CafeRepository;
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
public class CafeImageController {

    @Autowired
    ImageService imageService;
    @Autowired
    CafeRepository cafeRepository;

    @PostMapping("/cafe/{id}/image")
    public String handleImagePost(@PathVariable Long id, @RequestParam("imagefile") MultipartFile file) throws IOException {
        imageService.saveImageFile(cafeRepository.findById(id).get(), file);
        return "redirect:/cafe/" + id + "/show";
    }

    @GetMapping("/cafe/{id}/cafeimage")
    public void renderImageFromDB(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Cafe cafe = cafeRepository.findById(id).get();

        if (cafe.getImage() != null) {
            byte[] byteArray = new byte[cafe.getImage().length];
            int i = 0;

            for (Byte wrappedByte : cafe.getImage()) {
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}