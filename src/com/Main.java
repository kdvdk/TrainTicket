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
    public static Map<String,Float> DISTANCEMAP ;
    public static void main(String[] args) {
        initStyle();
        //RegisterActivity registerActivity = new RegisterActivity();
        //UserActivity mainActivity = new UserActivity();
        initMap();
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

    public static void initMap(){
        DISTANCEMAP = new HashMap<>();
        DISTANCEMAP.put("00",0f);
        DISTANCEMAP.put("01",7123f);
        DISTANCEMAP.put("02",1235f);
        DISTANCEMAP.put("03",5123f);
        DISTANCEMAP.put("04",1238f);
        DISTANCEMAP.put("05",6420f);
        DISTANCEMAP.put("06",4123f);
        DISTANCEMAP.put("07",3210f);
        DISTANCEMAP.put("08",5820f);
        DISTANCEMAP.put("09",1258f);
        DISTANCEMAP.put("010",7221f);
        DISTANCEMAP.put("12",1330f);
        DISTANCEMAP.put("11",0f);
        DISTANCEMAP.put("13",1321f);
        DISTANCEMAP.put("14",4212f);
        DISTANCEMAP.put("15",3210f);
        DISTANCEMAP.put("16",4512f);
        DISTANCEMAP.put("17",1230f);
        DISTANCEMAP.put("18",2031f);
        DISTANCEMAP.put("19",2312f);
        DISTANCEMAP.put("110",5465f);
        DISTANCEMAP.put("22",0f);
        DISTANCEMAP.put("23",2315f);
        DISTANCEMAP.put("24",3254f);
        DISTANCEMAP.put("25",7894f);
        DISTANCEMAP.put("26",3564f);
        DISTANCEMAP.put("27",4512f);
        DISTANCEMAP.put("28",5654f);
        DISTANCEMAP.put("29",9954f);
        DISTANCEMAP.put("210",8461f);
        DISTANCEMAP.put("33",0f);
        DISTANCEMAP.put("34",3541f);
        DISTANCEMAP.put("35",6554f);
        DISTANCEMAP.put("36",7423f);
        DISTANCEMAP.put("37",8798f);
        DISTANCEMAP.put("38",3456f);
        DISTANCEMAP.put("39",7541f);
        DISTANCEMAP.put("310",5410f);
        DISTANCEMAP.put("44",0f);
        DISTANCEMAP.put("45",7013f);
        DISTANCEMAP.put("46",9024f);
        DISTANCEMAP.put("47",2034f);
        DISTANCEMAP.put("48",1045f);
        DISTANCEMAP.put("49",1099f);
        DISTANCEMAP.put("410",5410f);
        DISTANCEMAP.put("55",0f);
        DISTANCEMAP.put("56",6540f);
        DISTANCEMAP.put("57",6651f);
        DISTANCEMAP.put("58",6666f);
        DISTANCEMAP.put("59",3333f);
        DISTANCEMAP.put("510",2222f);
        DISTANCEMAP.put("66",0f);
        DISTANCEMAP.put("67",1111f);
        DISTANCEMAP.put("68",1231f);
        DISTANCEMAP.put("69",7511f);
        DISTANCEMAP.put("610",9974f);
        DISTANCEMAP.put("77",0f);
        DISTANCEMAP.put("78",5461f);
        DISTANCEMAP.put("79",4444f);
        DISTANCEMAP.put("710",1446f);
        DISTANCEMAP.put("88",7821f);
        DISTANCEMAP.put("89",2586f);
        DISTANCEMAP.put("810",5461f);
        DISTANCEMAP.put("99",0f);
        DISTANCEMAP.put("910",7411f);
        DISTANCEMAP.put("1010",1233f);
    }
}
