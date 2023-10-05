package com.example.Examen_nicolasEpinosa.service;

import com.example.Examen_nicolasEpinosa.model.Product;
import com.example.Examen_nicolasEpinosa.model.dtoProduct.DtoProduct;
import com.example.Examen_nicolasEpinosa.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProductImpl implements ServiceProduct {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }


    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public Product saveProduct(DtoProduct dtoProduct) {
        Product product1 = new Product();
        product1.setName(dtoProduct.getName());
        product1.setPrice(dtoProduct.getPrice());

        return productRepo.save(product1);
    }

    @Override
    public Double precioTotal() {
        Optional<Double> precioTotal = productRepo.totalPrice().isPresent()? productRepo.totalPrice(): Optional.of(0.0);

return precioTotal.get();

    }
}
