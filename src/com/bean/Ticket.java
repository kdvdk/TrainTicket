package com.bean;

public class Ticket {
    private String ticketNumber;
    private String classNumber;
    private String seatNumber;
    private String idCardNumber;
    private float ticketPrice;

    public Ticket() {
    }

    public Ticket(String ticketNumber, String classNumber, String seatNumber, String idCardNumber, float ticketPrice) {
        this.ticketNumber = ticketNumber;
        this.classNumber = classNumber;
        this.seatNumber = seatNumber;
        this.idCardNumber = idCardNumber;
        this.ticketPrice = ticketPrice;
    }

    public String getTicketNumber() {
        return ticketNumber;
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
