package com;

import com.activity.LoginActivity;
import com.activity.TrainManagerActivity;
import com.activity.UserActivity;
import com.bean.User;
import com.utils.ConstantsUtils;
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

    public static void initMap(){
        ConstantsUtils.DISTANCEMAP.put("00",0f);
        ConstantsUtils.DISTANCEMAP.put("01",7123f);
        ConstantsUtils.DISTANCEMAP.put("02",1235f);
        ConstantsUtils.DISTANCEMAP.put("03",5123f);
        ConstantsUtils.DISTANCEMAP.put("04",1238f);
        ConstantsUtils.DISTANCEMAP.put("05",6420f);
        ConstantsUtils.DISTANCEMAP.put("06",4123f);
        ConstantsUtils.DISTANCEMAP.put("07",3210f);
        ConstantsUtils.DISTANCEMAP.put("08",5820f);
        ConstantsUtils.DISTANCEMAP.put("09",1258f);
        ConstantsUtils.DISTANCEMAP.put("010",7221f);
        ConstantsUtils.DISTANCEMAP.put("12",1330f);
        ConstantsUtils.DISTANCEMAP.put("11",0f);
        ConstantsUtils.DISTANCEMAP.put("13",1321f);
        ConstantsUtils.DISTANCEMAP.put("14",4212f);
        ConstantsUtils.DISTANCEMAP.put("15",3210f);
        ConstantsUtils.DISTANCEMAP.put("16",4512f);
        ConstantsUtils.DISTANCEMAP.put("17",1230f);
        ConstantsUtils.DISTANCEMAP.put("18",2031f);
        ConstantsUtils.DISTANCEMAP.put("19",2312f);
        ConstantsUtils.DISTANCEMAP.put("110",5465f);
        ConstantsUtils.DISTANCEMAP.put("22",0f);
        ConstantsUtils.DISTANCEMAP.put("23",2315f);
        ConstantsUtils.DISTANCEMAP.put("24",3254f);
        ConstantsUtils.DISTANCEMAP.put("25",7894f);
        ConstantsUtils.DISTANCEMAP.put("26",3564f);
        ConstantsUtils.DISTANCEMAP.put("27",4512f);
        ConstantsUtils.DISTANCEMAP.put("28",5654f);
        ConstantsUtils.DISTANCEMAP.put("29",9954f);
        ConstantsUtils.DISTANCEMAP.put("210",8461f);
        ConstantsUtils.DISTANCEMAP.put("33",0f);
        ConstantsUtils.DISTANCEMAP.put("34",3541f);
        ConstantsUtils.DISTANCEMAP.put("35",6554f);
        ConstantsUtils.DISTANCEMAP.put("36",7423f);
        ConstantsUtils.DISTANCEMAP.put("37",8798f);
        ConstantsUtils.DISTANCEMAP.put("38",3456f);
        ConstantsUtils.DISTANCEMAP.put("39",7541f);
        ConstantsUtils.DISTANCEMAP.put("310",5410f);
        ConstantsUtils.DISTANCEMAP.put("44",0f);
        ConstantsUtils.DISTANCEMAP.put("45",7013f);
        ConstantsUtils.DISTANCEMAP.put("46",9024f);
        ConstantsUtils.DISTANCEMAP.put("47",2034f);
        ConstantsUtils.DISTANCEMAP.put("48",1045f);
        ConstantsUtils.DISTANCEMAP.put("49",1099f);
        ConstantsUtils.DISTANCEMAP.put("410",5410f);
        ConstantsUtils.DISTANCEMAP.put("55",0f);
        ConstantsUtils.DISTANCEMAP.put("56",6540f);
        ConstantsUtils.DISTANCEMAP.put("57",6651f);
        ConstantsUtils.DISTANCEMAP.put("58",6666f);
        ConstantsUtils.DISTANCEMAP.put("59",3333f);
        ConstantsUtils.DISTANCEMAP.put("510",2222f);
        ConstantsUtils.DISTANCEMAP.put("66",0f);
        ConstantsUtils.DISTANCEMAP.put("67",1111f);
        ConstantsUtils.DISTANCEMAP.put("68",1231f);
        ConstantsUtils.DISTANCEMAP.put("69",7511f);
        ConstantsUtils.DISTANCEMAP.put("610",9974f);
        ConstantsUtils.DISTANCEMAP.put("77",0f);
        ConstantsUtils.DISTANCEMAP.put("78",5461f);
        ConstantsUtils.DISTANCEMAP.put("79",4444f);
        ConstantsUtils.DISTANCEMAP.put("710",1446f);
        ConstantsUtils.DISTANCEMAP.put("88",7821f);
        ConstantsUtils.DISTANCEMAP.put("89",2586f);
        ConstantsUtils.DISTANCEMAP.put("810",5461f);
        ConstantsUtils.DISTANCEMAP.put("99",0f);
        ConstantsUtils.DISTANCEMAP.put("910",7411f);
        ConstantsUtils.DISTANCEMAP.put("1010",1233f);
    }
}
