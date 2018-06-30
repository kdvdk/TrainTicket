package com.bean;

public class Ticket {
    private String ticketTrainNumber;
    private String ticketNumber;
    private String classNumber;
    private String seatNumber;
    private String idCardNumber;
    private float ticketPrice;
    private int compartment;

    public Ticket() {

    }

    public Ticket(String ticketNumber, String classNumber, String seatNumber, String idCardNumber, float ticketPrice, int compartment) {
        this.ticketNumber = ticketNumber;
        this.classNumber = classNumber;
        this.seatNumber = seatNumber;
        this.idCardNumber = idCardNumber;
        this.ticketPrice = ticketPrice;
        this.compartment = compartment;
    }

    public int getCompartment() {
        return compartment;
    }

    public void setCompartment(int compartment) {
        this.compartment = compartment;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getTicketTrainNumber() {
        return ticketTrainNumber;
    }

    public void setTicketTrainNumber(String ticketTrainNumber) {
        this.ticketTrainNumber = ticketTrainNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
