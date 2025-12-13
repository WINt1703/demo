package com.example.demo.services;

import com.example.demo.dtos.MainPageData;
import com.example.demo.models.Product;
import com.example.demo.repositories.*;
import com.example.demo.utils.ProductSorting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainPageService {
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final UnittypeRepository unittypeRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;

    public MainPageService(ProductRepository productRepository,
                           SupplierRepository supplierRepository,
                           UnittypeRepository unittypeRepository,
                           CategoryRepository categoryRepository,
                           ManufacturerRepository manufacturerRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.categoryRepository = categoryRepository;
        this.unittypeRepository = unittypeRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    public MainPageData getMainPageData(String searchQuery, String sortCode) {
        List<Product> products = null;
        if(searchQuery != null && !searchQuery.isEmpty()){
            products = productRepository.findAllByTitleStartingWith(searchQuery, ProductSorting.fromCode(sortCode));
        }
        else {
            products = productRepository.findAll(ProductSorting.fromCode(sortCode));
        }

        return new MainPageData(products, supplierRepository.findAll(), manufacturerRepository.findAll(), categoryRepository.findAll(), unittypeRepository.findAll());
    }
}
