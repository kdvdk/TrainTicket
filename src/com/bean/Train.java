package com.bean;

public class Train {
    private String trainNumber;
    private String trainName;
    private int compartmentNumber;
    private int capacityOfCompartment;
    private float trainSpeed;

    public Train() {
    }

    public Train(String trainNumber, String trainName, int compartmentNumber, int capacityOfCompartment, float trainSpeed) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.compartmentNumber = compartmentNumber;
        this.capacityOfCompartment = capacityOfCompartment;
        this.trainSpeed = trainSpeed;
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
}
