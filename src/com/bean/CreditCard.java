package com.bean;

public class CreditCard {
    private String cardNumber;
    private String cardOwner;
    private float balace;

    public CreditCard() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public float getBalace() {
        return balace;
    }

    public void setBalace(float balace) {
        this.balace = balace;
    }

    public CreditCard(String cardNumber, String cardOwner, float balace) {
        this.cardNumber = cardNumber;
        this.cardOwner = cardOwner;
        this.balace = balace;
    }
}
