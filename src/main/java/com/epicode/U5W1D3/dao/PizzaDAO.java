package com.epicode.U5W1D3.dao;

import com.epicode.U5W1D3.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaDAO extends JpaRepository<Pizza, Long> {
    boolean existsByName(String name);

    @Query("SELECT p.name FROM Pizza p WHERE p.price <= :price")
    List<String> filterByPriceLessThan(double price);
}
