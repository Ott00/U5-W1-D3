package com.epicode.U5W1D3.dao;

import com.epicode.U5W1D3.entities.Topping;
import com.epicode.U5W1D3.exceptions.ItemAlreadyExist;
import com.epicode.U5W1D3.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ToppingService {

    @Autowired
    private ToppingDAO toppingDAO;

    public void saveTopping(Topping topping) {
        if (toppingDAO.existsByName(topping.getName())) {
            throw new ItemAlreadyExist("Nome già assegnato!");
        } else {
            toppingDAO.save(topping);
            log.info("Topping salvato correttamente!");
        }
    }

    public Topping findById(long toppingId) {
        return toppingDAO.findById(toppingId).orElseThrow(() -> new ItemNotFoundException(toppingId));
    }

    public void findByIdAndDelete(long toppingId) {
        Topping found = this.findById(toppingId);
        toppingDAO.delete(found);
        log.info("Il topping con l'id " + toppingId + " è stato cancellato correttamente!");
    }

    public List<String> filterByCaloriesLessThan(int calories) {
        return toppingDAO.filterByCaloriesLessThan(50);
    }
}
