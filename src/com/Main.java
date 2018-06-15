package com;

import com.activity.LoginActivity;
import com.activity.RegisterActivity;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        initStyle();
        LoginActivity loginActivity = new LoginActivity();
        //RegisterActivity registerActivity = new RegisterActivity();
    }


    public static void initStyle() {
        /**
         * 设置风格
         */
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            //TODO exception
        }
        UIManager.put("RootPane.setupButtonVisible", false);
    }
}
