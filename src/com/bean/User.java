package com.bean;

public class User {

    private String userPhone;
    private String userPassWord;
    private String userEmail;
    private String userAvatarName;
    private String userIdCardNumber ;
    private String userRealName=" ";
    private String userSex=" ";
    private String usualDepature;
    private int userAge ;
    private int userBirthday;

    private int type;

    public User() {
    }

    public User(String userPhone, String userPassWord, String userEmail, String userAvatarName, int type) {
        this.userPhone = userPhone;
        this.userPassWord = userPassWord;
        this.userEmail = userEmail;
        this.userAvatarName = userAvatarName;
        this.type = type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAvatarName() {
        return userAvatarName;
    }

    public void setUserAvatarName(String userAvatarName) {
        this.userAvatarName = userAvatarName;
    }

    public String getUserIdCardNumber() {
        return userIdCardNumber;
    }

    public void setUserIdCardNumber(String userIdCardNumber) {
        this.userIdCardNumber = userIdCardNumber;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUsualDepature() {
        return usualDepature;
    }

    public void setUsualDepature(String usualDepature) {
        this.usualDepature = usualDepature;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(int userBirthday) {
        this.userBirthday = userBirthday;
    }
}
