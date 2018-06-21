package com;

import com.activity.LoginActivity;
import com.activity.TrainManagerActivity;
import com.activity.UserActivity;
import com.bean.User;
import com.utils.ConstantsUtils;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static User user;
    public static void main(String[] args) {
        initStyle();
        //RegisterActivity registerActivity = new RegisterActivity();

        UserActivity mainActivity = new UserActivity();
        TrainManagerActivity managerActivity = new TrainManagerActivity();
        //LoginActivity loginActivity = new LoginActivity();

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
