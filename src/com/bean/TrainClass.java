package com.bean;

import java.sql.Date;

public class TrainClass {
    private String classNumber;
    private String trainNumber;
    private String depaturePlace;
    private String goalPlace;
    private float dinstance;
    private Date depatureTime;
    private int passengerNumber;

    public TrainClass() {
    }

    public TrainClass(String classNumber, String trainNumber, String depaturePlace, String goalPlace, float dinstance, Date depatureTime, int passengerNumber) {
        this.classNumber = classNumber;
        this.trainNumber = trainNumber;
        this.depaturePlace = depaturePlace;
        this.goalPlace = goalPlace;
        this.dinstance = dinstance;
        this.depatureTime = depatureTime;
        this.passengerNumber = passengerNumber;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDepaturePlace() {
        return depaturePlace;
    }

    public void setDepaturePlace(String depaturePlace) {
        this.depaturePlace = depaturePlace;
    }

    public String getGoalPlace() {
        return goalPlace;
    }

    public void setGoalPlace(String goalPlace) {
        this.goalPlace = goalPlace;
    }

    public float getDinstance() {
        return dinstance;
    }

    public void setDinstance(float dinstance) {
        this.dinstance = dinstance;
    }

    public Date getDepatureTime() {
        return depatureTime;
    }

    public void setDepatureTime(Date depatureTime) {
        this.depatureTime = depatureTime;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }
}

