package com.epicode.U5W1D3.dao;

import com.epicode.U5W1D3.entities.Drink;
import com.epicode.U5W1D3.exceptions.ItemAlreadyExist;
import com.epicode.U5W1D3.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DrinkService {
    @Autowired
    private DrinkDAO drinkDAO;

    public void saveDrink(Drink drink) {
        if (drinkDAO.existsByName(drink.getName())) {
            throw new ItemAlreadyExist("Nome già assegnato!");
        } else {
            drinkDAO.save(drink);
            log.info("Drink salvato correttamente!");
        }
    }

    public Drink findById(long drinkId) {
        return drinkDAO.findById(drinkId).orElseThrow(() -> new ItemNotFoundException(drinkId));
    }

    public void findByIdAndDelete(long drinkId) {
        Drink found = this.findById(drinkId);
        drinkDAO.delete(found);
        log.info("Il drink con l'id " + drinkId + " è stato cancellato correttamente!");
    }
}
