package com.exceptions.lab;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.exceptions.BadFeedbackException;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeShopTest {

    CoffeeShop coffeeShop = new ClassCoffyShop(5, new ArrayList<>());
    CoffeeShop coffeeShopException = new ClassCoffyShop(0, new ArrayList<>(Arrays.asList("good coffee")));

    @Test
    void buyCoffee() {
        try {
            coffeeShop.buyCoffee();
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
        assertEquals(4, coffeeShop.coffeeAmount());
    }

    @Test
    void buyCoffeeException() {
        Exception exception = assertThrows(NoCoffyException.class, () -> {
            coffeeShopException.buyCoffee();
        });
        assertEquals("No coffee available", exception.getMessage());        
    }


    @Test
    void buyCoffeeIfPresent() {
        assertTrue(coffeeShop.buyCoffeeIfPresent());
    }

    @Test
    void buyCoffeeNotPresent() {
        assertFalse(coffeeShopException.buyCoffeeIfPresent());
    }

    @Test
    void giveFeedback() {
        coffeeShop.giveFeedback("Great coffee!");
        
        List<String> feedbacks = coffeeShop.readFeedbacks();
        
        assertEquals(1, feedbacks.size());
        assertEquals("Great coffee!", feedbacks.get(0));
    }

    @Test
    void giveFeedbackException() {
        RuntimeException exception = assertThrows(BadFeedbackException.class, () -> {
            coffeeShopException.giveFeedback("bad coffee");
        });
        assertEquals("Error with writing feedback", exception.getMessage());
    }

    @Test
    void readFeedbacks(){
        List<String> feedbacks = coffeeShop.readFeedbacks();
        assertTrue(feedbacks.isEmpty());
        
        coffeeShop.giveFeedback("Great coffee!");
        feedbacks = coffeeShop.readFeedbacks();
        assertEquals(1, feedbacks.size());
        assertEquals("Great coffee!", feedbacks.get(0));



        RuntimeException exception = assertThrows(BadFeedbackException.class, () -> {
            coffeeShopException.giveFeedback("Not drinkable coffee");
        });
        assertEquals("Error with writing feedback", exception.getMessage());
        feedbacks = coffeeShop.readFeedbacks();
        assertEquals(1, feedbacks.size());
    }

    @Test
    void coffeeAmount() {
        assertEquals(5, coffeeShop.coffeeAmount());
    }
}