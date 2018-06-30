package com.bean;

public class Train {
    private String trainNumber;
    private String trainName;
    private int compartmentNumber;
    private int capacityOfCompartment;
    private float trainSpeed;
    private float firstPrice = 0f;
    private float secondPrice = 0f;
    private float bedPrice = 0f;

    public Train() {
    }

    public Train(String trainNumber, String trainName, int compartmentNumber, int capacityOfCompartment,
                 float trainSpeed, float price, float secondPrice, float bedPrice) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.compartmentNumber = compartmentNumber;
        this.capacityOfCompartment = capacityOfCompartment;
        this.trainSpeed = trainSpeed;
        this.firstPrice = price;
        this.secondPrice = secondPrice;
        this.bedPrice = bedPrice;
    }


    public float getSecondPrice() {
        return secondPrice;
    }

    public void setSecondPrice(float secondPrice) {
        this.secondPrice = secondPrice;
    }

    public float getBedPrice() {
        return bedPrice;
    }

    public void setBedPrice(float bedPrice) {
        this.bedPrice = bedPrice;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getCompartmentNumber() {
        return compartmentNumber;
    }

    public void setCompartmentNumber(int compartmentNumber) {
        this.compartmentNumber = compartmentNumber;
    }

    public int getCapacityOfCompartment() {
        return capacityOfCompartment;
    }

    public void setCapacityOfCompartment(int capacityOfCompartment) {
        this.capacityOfCompartment = capacityOfCompartment;
    }

    public float getTrainSpeed() {
        return trainSpeed;
    }

    public void setTrainSpeed(float trainSpeed) {
        this.trainSpeed = trainSpeed;
    }

    public float getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(float firstPrice) {
        this.firstPrice = firstPrice;
    }
}
