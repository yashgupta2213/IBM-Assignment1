package com.example.entity;

public class Mercedes_data {
    private String city;
    private int petrol_price;
    private int time_required;
    private int bill_amount;
    private boolean fuel_lid_status;

    public Mercedes_data() {
    }

    public void setCity(String city) {
        this.city = city;
    }


    public void setPetrol_price(int petrol_price) {
        this.petrol_price = petrol_price;
    }

    public void setTime_required(int time_required) {
        this.time_required = time_required;
    }


    public void setBill_amount(int bill_amount) {
        this.bill_amount = bill_amount;
    }

    public void setFuel_lid_status(boolean fuel_lid_status) {
        this.fuel_lid_status = fuel_lid_status;
    }

    @Override
    public String toString() {
        return "Mercedes_data{" +
                "city='" + city + '\'' +
                ", petrol_price=" + petrol_price +
                ", time_required=" + time_required + " Minutes "+
                ", bill_amount=" + bill_amount +
                ", fuel_lid_status=" + fuel_lid_status +
                '}';
    }
}
