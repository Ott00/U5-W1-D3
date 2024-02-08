package com.epicode.U5W1D3.entities;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "toppings")
@NoArgsConstructor
public class Topping extends Item {
    private String name;

    @ManyToMany
    @JoinTable(
            name = "pizza_topping",
            joinColumns = @JoinColumn(name = "topping_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private List<Pizza> pizzaList;

    public Topping(String name, int calories, double price) {
        super(calories, price);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }
}
