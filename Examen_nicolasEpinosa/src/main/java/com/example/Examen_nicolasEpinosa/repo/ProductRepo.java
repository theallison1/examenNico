package com.example.Examen_nicolasEpinosa.repo;

import com.example.Examen_nicolasEpinosa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository <Product,Long> {

    @Query("SELECT SUM( p.price)  FROM Product p")
    Optional<Double> totalPrice();

}
