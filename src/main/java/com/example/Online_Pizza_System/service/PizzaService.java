package com.example.Online_Pizza_System.service;

import com.example.Online_Pizza_System.model.Order;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit; // this module I got from : https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/temporal/ChronoUnit.html
import java.time.LocalTime;

@Service
public class PizzaService {
    public Order processOrder(Order order) {
        // Set base price based on size
        float basePrice = getBasePrice(order.getSize());
        order.setBasePrice(basePrice);

        // Calculate toppings price
        int toppingCount = order.getToppings().size();

        double toppingsPrice;

        if (toppingCount > 3) {
            // If the topping count is greater than 3, we charge for (toppingCount - 1) toppings.
            toppingsPrice = toppingCount - 1;
        } else {
            // If the topping count is 3 or fewer, we charge for the full topping count.
            toppingsPrice = toppingCount;
        }

        order.setToppingsPrice(toppingsPrice); // Set toppings price

        // Calculate total amount
        double totalAmount = (basePrice * order.getQuantity()) + toppingsPrice;
        if (order.isDelivery()) {
            totalAmount += 5;
        }
        order.setTotalAmount(totalAmount);

// Set delivery or pickup time
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        LocalTime deliveryOrPickupTime;
        if (order.isDelivery()) {
            deliveryOrPickupTime = currentTime.plusHours(1);
        } else {
            deliveryOrPickupTime = currentTime.plusHours(2);
        }
        order.setDeliveryOrPickupTime(deliveryOrPickupTime.toString());
        return order;
    }


    private float getBasePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return 10;
            case "medium":
                return 13;
            case "large":
                return 17;
            default:
                return 0;
        }
    }

}
