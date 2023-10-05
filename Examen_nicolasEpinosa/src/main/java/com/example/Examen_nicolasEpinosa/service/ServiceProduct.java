package com.example.Examen_nicolasEpinosa.service;

import com.example.Examen_nicolasEpinosa.model.Product;
import com.example.Examen_nicolasEpinosa.model.dtoProduct.DtoProduct;
import com.example.Examen_nicolasEpinosa.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ServiceProduct {

    public List<Product> findAll();
    public Optional<Product> findById(Long id);
    public Product saveProduct(DtoProduct dtoProduct);

    public Double precioTotal ();
}
