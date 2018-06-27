package com.bean;

public class Seat {
    private String trainNumber ;
    private String seatNumber ;
    private float price;

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Seat() {
    }

    public Seat(String trainNumber, String seatNumber, float price) {
        this.trainNumber = trainNumber;
        this.seatNumber = seatNumber;
        this.price = price;
    }
}
