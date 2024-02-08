package com.epicode.U5W1D3;

import com.epicode.U5W1D3.dao.DrinkService;
import com.epicode.U5W1D3.dao.PizzaService;
import com.epicode.U5W1D3.dao.ToppingService;
import com.epicode.U5W1D3.entities.Drink;
import com.epicode.U5W1D3.entities.Pizza;
import com.epicode.U5W1D3.entities.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class OrdersRunner implements CommandLineRunner {
    @Autowired
    PizzaService pizzaService;
    @Autowired
    ToppingService toppingService;
    @Autowired
    DrinkService drinkService;

    @Override
    public void run(String... args) throws Exception {


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D3Application.class);

        Topping t1 = (Topping) ctx.getBean("toppings_tomato");
        Topping t2 = (Topping) ctx.getBean("toppings_cheese");
        Topping t3 = (Topping) ctx.getBean("toppings_ham");
        Topping t4 = (Topping) ctx.getBean("toppings_pineapple");
        Topping t5 = (Topping) ctx.getBean("toppings_salami");
        toppingService.saveTopping(t1);
        toppingService.saveTopping(t2);
        toppingService.saveTopping(t3);
        toppingService.saveTopping(t4);
        toppingService.saveTopping(t5);

        Pizza p1 = (Pizza) ctx.getBean("pizza_margherita");
        Pizza p2 = (Pizza) ctx.getBean("hawaiian_pizza");
        Pizza p3 = (Pizza) ctx.getBean("salami_pizza");
        Pizza p4 = (Pizza) ctx.getBean("salami_pizza_xl");
        pizzaService.savePizza(p1);
        pizzaService.savePizza(p2);
        pizzaService.savePizza(p3);
        pizzaService.savePizza(p4);

        Drink d1 = (Drink) ctx.getBean("lemonade");
        Drink d2 = (Drink) ctx.getBean("water");
        Drink d3 = (Drink) ctx.getBean("wine");

        drinkService.saveDrink(d1);
        drinkService.saveDrink(d2);
        drinkService.saveDrink(d3);

        System.out.println("**Test Custom Query");
        System.out.println("Pizze che costano meno di x€");
        pizzaService.filterByPriceLessThan(8).forEach(System.out::println);
        System.out.println();
        System.out.println("Topping che hanno meno di x calorie");
        toppingService.filterByCaloriesLessThan(50).forEach(System.out::println);


//        try {
//            Menu m = (Menu) ctx.getBean("menu");
//            m.printMenu();
//
//            Table t1 = (Table) ctx.getBean("tavolo1");
//
//            Order o1 = new Order(4, t1);
//
//            o1.addItem(ctx.getBean("pizza_margherita", Pizza.class));
//            o1.addItem(ctx.getBean("hawaiian_pizza", Pizza.class));
//            o1.addItem(ctx.getBean("salami_pizza_xl", Pizza.class));
//            o1.addItem(ctx.getBean("lemonade", Drink.class));
//            o1.addItem(ctx.getBean("lemonade", Drink.class));
//            o1.addItem(ctx.getBean("wine", Drink.class));
//
//            System.out.println("DETTAGLI TAVOLO 1:");
//            o1.print();
//
//            System.out.println("CONTO TAVOLO 1");
//            System.out.println(o1.getTotal());
//        } catch (Exception ex) {
//            System.err.println(ex.getMessage());
//        } finally {
//            ctx.close();
//        }
    }
}
