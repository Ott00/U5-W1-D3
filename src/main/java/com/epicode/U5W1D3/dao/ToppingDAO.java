package com.epicode.U5W1D3.dao;

import com.epicode.U5W1D3.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToppingDAO extends JpaRepository<Topping, Long> {
    boolean existsByName(String name);

    @Query("SELECT t.name FROM Topping t WHERE t.calories < :calories")
    List<String> filterByCaloriesLessThan(int calories);
}
