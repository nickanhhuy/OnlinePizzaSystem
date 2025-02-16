package com.example.Online_Pizza_System.service;

import com.example.Online_Pizza_System.model.Order;
import org.springframework.stereotype.Service;

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
        double totalAmount = (basePrice * order.getQuantity()) + toppingsPrice + (order.isDelivery() ? 5 : 0);
        order.setTotalAmount(totalAmount);

        // Set delivery or pickup time
        LocalTime currentTime = LocalTime.now();
        String deliveryOrPickupTime = order.isDelivery() ?
                currentTime.plusHours(1).toString() : currentTime.plusHours(2).toString();
        order.setDeliveryOrPickupTime(deliveryOrPickupTime);

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
