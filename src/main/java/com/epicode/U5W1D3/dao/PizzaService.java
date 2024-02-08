package com.epicode.U5W1D3.dao;

import com.epicode.U5W1D3.entities.Pizza;
import com.epicode.U5W1D3.exceptions.ItemAlreadyExist;
import com.epicode.U5W1D3.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaService {
    @Autowired
    private PizzaDAO pizzaDAO;

    public void savePizza(Pizza pizza) {
        if (pizzaDAO.existsByName(pizza.getName())) {
            throw new ItemAlreadyExist("Nome già assegnato!");
        } else {
            pizzaDAO.save(pizza);
            log.info("Pizza salvata correttamente!");
        }
    }

    public Pizza findById(long pizzaId) {
        return pizzaDAO.findById(pizzaId).orElseThrow(() -> new ItemNotFoundException(pizzaId));
    }

    public void findByIdAndDelete(long pizzaId) {
        Pizza found = this.findById(pizzaId);
        pizzaDAO.delete(found);
        log.info("La pizza con l'id " + pizzaId + " è stato cancellata correttamente!");
    }

    public List<String> filterByPriceLessThan(double price) {
        return pizzaDAO.filterByPriceLessThan(price);
    }
}
