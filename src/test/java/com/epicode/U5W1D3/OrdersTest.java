package com.epicode.U5W1D3;

import com.epicode.U5W1D3.entities.Pizza;
import com.epicode.U5W1D3.entities.Table;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class OrdersTest {
    private static AnnotationConfigApplicationContext ctx;

    @BeforeAll
    static void setup() {
        ctx = new AnnotationConfigApplicationContext(U5W1D3Application.class);
    }

    @AfterAll
    static void clear() {
        ctx.close();
    }

    @Test
    public void testSeatPriceLoadedFromProperties() {
        Table t1 = (Table) ctx.getBean("tavolo1");
        Table t2 = (Table) ctx.getBean("tavolo2");
        Table t3 = (Table) ctx.getBean("tavolo3");
        assertEquals(2.5, t1.getSeatPrice());
        assertEquals(2.5, t2.getSeatPrice());
        assertEquals(2.5, t3.getSeatPrice());
    }

    @Test
    public void testIfPizzaIsXL() {
        Pizza p1 = (Pizza) ctx.getBean("salami_pizza_xl");
        Pizza p2 = (Pizza) ctx.getBean("pizza_margherita");
        assertTrue(p1.isXl());
        assertFalse(p2.isXl());
    }

    @ParameterizedTest
    @CsvSource({"pizza_margherita, Pizza Margherita, 4.99", "hawaiian_pizza, Hawaiian Pizza, 6.77"})
    public void testPizzaProprieties(String beanName, String name, double price) {
        Pizza p = (Pizza) ctx.getBean(beanName);
        assertEquals(name, p.getName());
        assertEquals(price, p.getPrice());
    }
}
