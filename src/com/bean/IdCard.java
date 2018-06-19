package com.bean;

import java.sql.Date;

public class IdCard {
    private String idCardNumber;
    private String name;
    private String sex;
    private Date birthday;

    public IdCard() {
    }


    public IdCard(String idCardNumber, String name, String sex, Date birthday) {
        this.idCardNumber = idCardNumber;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
