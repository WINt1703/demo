package com.example.demo.services;

import com.example.demo.dtos.Product.ResponseProductDto;
import com.example.demo.dtos.Product.RequestProductDto;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.models.Order;
import com.example.demo.models.OrderProduct;
import com.example.demo.models.Product;
import com.example.demo.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final UnittypeRepository unittypeRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final ProductMapper productMapper;
    private final OrderProductRepository orderProductRepository;

    public ProductService(ProductRepository productRepository,
                           SupplierRepository supplierRepository,
                           UnittypeRepository unittypeRepository,
                           CategoryRepository categoryRepository,
                           ManufacturerRepository manufacturerRepository,
                           OrderProductRepository orderProductRepository,
                           ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.categoryRepository = categoryRepository;
        this.unittypeRepository = unittypeRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.orderProductRepository = orderProductRepository;
        this.productMapper = productMapper;
    }

    public Optional<ResponseProductDto> updateProduct(String id, RequestProductDto productDto) {
        try {
            var unitType = unittypeRepository.findById(productDto.supplierId()).orElseThrow();
            var category = categoryRepository.findById(productDto.supplierId()).orElseThrow();
            var manufacturer = manufacturerRepository.findById(productDto.supplierId()).orElseThrow();
            var supplier = supplierRepository.findById(productDto.supplierId()).orElseThrow();
            var product = productRepository.findById(id).orElseThrow();

            productMapper.copyToEntity(product, productDto, unitType, category, manufacturer, supplier);

            return Optional.of(productMapper.fromEntity(productRepository.save(product)));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }

    public Optional<ResponseProductDto> addProduct(RequestProductDto productDto) {
        try {
            var unitType = unittypeRepository.findById(productDto.supplierId()).orElseThrow();
            var category = categoryRepository.findById(productDto.supplierId()).orElseThrow();
            var manufacturer = manufacturerRepository.findById(productDto.supplierId()).orElseThrow();
            var supplier = supplierRepository.findById(productDto.supplierId()).orElseThrow();
            var product = new Product();

            productMapper.copyToEntity(product, productDto, unitType, category, manufacturer, supplier);

            return Optional.of(productMapper.fromEntity(productRepository.save(product)));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }

    @Transactional
    public boolean deleteProduct(String productId) {
        try {
            var product = this.productRepository.findById(productId);

            if (product.isPresent()) {
                var unwrappedProduct = product.orElseThrow();
                this.orderProductRepository.deleteAll(unwrappedProduct.getOrderProducts());
                this.productRepository.delete(unwrappedProduct);
                return true;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
