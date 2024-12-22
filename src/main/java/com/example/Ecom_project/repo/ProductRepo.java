package com.example.Ecom_project.repo;

import com.example.Ecom_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//import org.springframework.stereotype.Repository;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p from Product p Where " +
        "lower(p.name) like lower(concat('%', :keyword ,'%'))" +
        "or lower(p.description) like lower(concat('%', :keyword ,'%'))" +
        "or lower(p.brand) like lower(concat('%', :keyword ,'%'))" +
        "or lower(p.category) like lower(concat('%', :keyword ,'%'))"
    )
    List<Product> searchProducts(String keyword);
}
