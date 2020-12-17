package com.example.pizzabena.Classes;

public class order {
    String pizzaName;
    String PizzaDescription;
    String pizzaPrice;

    public order(String pizzaName, String pizzaDescription, String pizzaPrice) {
        this.pizzaName = pizzaName;
        PizzaDescription = pizzaDescription;
        this.pizzaPrice = pizzaPrice;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getPizzaDescription() {
        return PizzaDescription;
    }



    public String getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public void setPizzaDescription(String pizzaDescription) {
        PizzaDescription = pizzaDescription;
    }



    public void setPizzaPrice(String pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }
}
