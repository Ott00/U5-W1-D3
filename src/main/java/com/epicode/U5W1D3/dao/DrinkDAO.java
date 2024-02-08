package com.epicode.U5W1D3.dao;

import com.epicode.U5W1D3.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkDAO extends JpaRepository<Drink, Long> {
    boolean existsByName(String name);


}
