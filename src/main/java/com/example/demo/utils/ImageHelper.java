package com.example.demo.utils;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class ImageHelper {
    public String convertImageBytesToBase64(byte[] imageBytes) {
        String base64 = Base64.getEncoder().encodeToString(imageBytes);

        return "data:image/jpeg;base64," + base64;
    }
}
