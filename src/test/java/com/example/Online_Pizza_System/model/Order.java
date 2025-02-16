package com.example.Online_Pizza_System.model;
import java.util.ArrayList;
import java.util.List;

public class Order {
    //Initialize the private parameters
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String size;
    private int quantity;
    private List<String> toppings = new ArrayList<>();
    private boolean delivery;
    private String orderSummary;
    private double totalAmount;
    private String deliveryOrPickupTime;
    private double basePrice;
    private double toppingsPrice;

    //Getter and setter method for each parameter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDelivery() {
        return delivery;
    }
    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }
    public double getToppingsPrice() {
        return toppingsPrice;
    }
    public void setToppingsPrice(double toppingsPrice) {
        this.toppingsPrice = toppingsPrice;
    }
    public String getOrderSummary() {
        return orderSummary;
    }
    public void setOrderSummary(String orderSummary) {
        this.orderSummary = orderSummary;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void setDeliveryOrPickupTime(String deliveryOrPickupTime) {
        this.deliveryOrPickupTime = deliveryOrPickupTime;
    }

    public String getDeliveryOrPickupTime() {
        return deliveryOrPickupTime;
    }
    public double getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

}
