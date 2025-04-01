package com.exceptions.lab;
import java.util.List;

import com.exceptions.BadFeedbackException;

public class ClassCoffyShop implements CoffeeShop {

        private int coffeeCount;
        private List<String> feedbacks;


        public ClassCoffyShop(int coffeeCount, List<String> feedbacks) {
            this.coffeeCount = coffeeCount;
            this.feedbacks = feedbacks;
        }

        @Override
        public void buyCoffee() throws Exception {
            if (coffeeCount <=0){
                throw new NoCoffyException("No coffee available");
            }
            coffeeCount--;
        }
    
        @Override
        public boolean buyCoffeeIfPresent() {
            if (coffeeCount > 0) {
                coffeeCount--;
                return true;
            }
            return false;
        }
    
        @Override
        public void giveFeedback(String feedback) throws RuntimeException {
            String bad_words[] = new String[]{"bad", "worst", "not tasty", "not drinkable"};
            for (String word : bad_words) {
                if (feedback.toLowerCase().contains(word)) {
                    throw new BadFeedbackException("Error with writing feedback");
                }
            }
            feedbacks.add(feedback);
        }
    
        @Override
        public List<String> readFeedbacks() {
            return feedbacks;
        }
    
        @Override
        public int coffeeAmount() {
            return coffeeCount;
        }
}
