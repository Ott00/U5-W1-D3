package com.epicode.U5W1D3.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Bean(name = "toppings_tomato")
    public Topping toppingTomatoBean() {
        return new Topping("Tomato", 0, 0);
    }

    @Bean(name = "toppings_cheese")
    public Topping toppingCheeseBean() {
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean(name = "toppings_ham")
    public Topping toppingHamBean() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean(name = "toppings_pineapple")
    public Topping toppingPineappleBean() {
        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean(name = "toppings_salami")
    public Topping toppingSalamiBean() {
        return new Topping("Salami", 86, 0.99);
    }


    @Bean(name = "pizza_margherita")
    public Pizza pizzaMargheritaBean() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(toppingTomatoBean());
        toppingList.add(toppingCheeseBean());
        return new Pizza("Pizza Margherita", toppingList, false);
    }

    @Bean(name = "hawaiian_pizza")
    public Pizza pizzaHawaiianBean() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(toppingTomatoBean());
        toppingList.add(toppingCheeseBean());
        toppingList.add(toppingHamBean());
        toppingList.add(toppingPineappleBean());
        return new Pizza("Hawaiian Pizza", toppingList, false);
    }

    @Bean(name = "salami_pizza")
    public Pizza pizzaSalamiBean() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(toppingTomatoBean());
        toppingList.add(toppingCheeseBean());
        toppingList.add(toppingSalamiBean());
        return new Pizza("Salami Pizza", toppingList, false);
    }

    @Bean(name = "salami_pizza_xl")
    public Pizza pizzaSalamiXlBean() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(toppingTomatoBean());
        toppingList.add(toppingCheeseBean());
        toppingList.add(toppingSalamiBean());
        return new Pizza("Salami Pizza XL", toppingList, true);
    }

    @Bean(name = "lemonade")
    public Drink lemonadeBean() {
        return new Drink("Lemonade", 128, 1.29);
    }

    @Bean(name = "water")
    public Drink waterBean() {
        return new Drink("Water", 0, 1.29);
    }

    @Bean(name = "wine")
    public Drink wineBean() {
        return new Drink("Wine", 607, 7.49);
    }

    @Bean("pizzas")
    List<Pizza> pizzaList() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(pizzaMargheritaBean());
        pizzas.add(pizzaHawaiianBean());
        pizzas.add(pizzaSalamiBean());
        pizzas.add(pizzaSalamiXlBean());
        return pizzas;
    }

    @Bean("drinks")
    List<Drink> drinksList() {
        List<Drink> drinks = new ArrayList<>();
        drinks.add(lemonadeBean());
        drinks.add(waterBean());
        drinks.add(wineBean());
        return drinks;
    }

    @Bean("toppings")
    List<Topping> toppingsList() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(toppingTomatoBean());
        toppings.add(toppingCheeseBean());
        toppings.add(toppingSalamiBean());
        toppings.add(toppingHamBean());
        toppings.add(toppingPineappleBean());
        return toppings;
    }

    @Bean("tavolo1")
    Table getTable1(@Value("${seat.price}") double seatPrice) {
        return new Table(1, 5, true, seatPrice);
    }

    @Bean("tavolo2")
    Table getTable2(@Value("${seat.price}") double seatPrice) {
        return new Table(2, 4, true, seatPrice);
    }

    @Bean("tavolo3")
    Table getTable3(@Value("${seat.price}") double seatPrice) {
        return new Table(3, 8, false, seatPrice);
    }
}
