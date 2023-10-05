package com.example.Examen_nicolasEpinosa.controller;


import com.example.Examen_nicolasEpinosa.model.Product;
import com.example.Examen_nicolasEpinosa.model.dtoProduct.DtoProduct;
import com.example.Examen_nicolasEpinosa.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.ProviderNotFoundException;
import java.util.List;

@RestController
public class ControllerProduct {

    @Autowired
    ServiceProduct serviceProduct;
    @GetMapping("/")
    List<Product> all() {
        return serviceProduct.findAll();
    }

    @GetMapping("/precioTotal")
    Double totalPrice() {

        return serviceProduct.precioTotal();
    }


    @PostMapping("/product")
    Product newEmployee(@RequestBody DtoProduct dtoProduct) {
        return serviceProduct.saveProduct(dtoProduct);
    }



    @GetMapping("/product/{id}")
    Product one(@PathVariable Long id) {

        return serviceProduct.findById(id)
                .orElseThrow(() -> new ProviderNotFoundException(""+id));
    }

}
