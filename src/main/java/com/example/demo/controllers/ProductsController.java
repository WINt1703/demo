package com.example.demo.controllers;

import com.example.demo.dtos.Product.ResponseProductDto;
import com.example.demo.dtos.Product.RequestProductDto;
import com.example.demo.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseProductDto> updateProduct(@PathVariable String id, @ModelAttribute RequestProductDto productDto) {
        var product = productService.updateProduct(id, productDto);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.orElseThrow());
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseProductDto> createProduct(@ModelAttribute RequestProductDto productDto) {
        var product = productService.addProduct(productDto);

        if (product.isPresent()) {
            return ResponseEntity.ok(product.orElseThrow());
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        if (productService.deleteProduct(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
