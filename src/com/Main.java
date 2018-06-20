package com;

import com.activity.LoginActivity;
import com.activity.TrainManagerActivity;
import com.activity.UserActivity;
import com.bean.User;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;

public class Main {

    public static User user;

    public static void main(String[] args) {
        initStyle();
        //LoginActivity loginActivity = new LoginActivity();
        //RegisterActivity registerActivity = new RegisterActivity();
        //UserActivity mainActivity = new UserActivity();
        TrainManagerActivity managerActivity = new TrainManagerActivity();
    }


    public static void initStyle() {
        /**
         * 设置风格
         */
        try {
            //generalNoTranslucencyShadow
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            //TODO exception
        }
        UIManager.put("RootPane.setupButtonVisible", false);
    }
}
