package com.utils;

import com.activity.MainActivity;
import com.bean.TrainClass;

import java.sql.Date;

public class ConstantsUtils {
    public static String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String DBURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=TrainTickets";
    public static String NAME_ROOT = "train_root";
    public static String NAME_USER = "train_user";
    public static String NAME_MANAGER = "train_manager";
    public static String PWD = "wang135410";

    public static String TITLE = "火车票预售系统";

    //loginsize
    public static int LOGIN_X = 800;
    public static int LOGIN_Y = 200;
    public static int LOGIN_WIDTH = 412;
    public static int LOGIN_HEIGH = 620;


    //frame size 400, 150, 1200, 720
    public static int X = 400;
    public static int Y = 150;
    public static int WIDTH = 1200;
    public static int HEIGH = 720;

    public static String[] CITIES = {
            "成都",
            "上海",
            "太原",
            "北京",
            "西藏",
            "天津",
            "海南",
            "深圳",
            "青岛",
            "厦门",
            "长沙",
            "长春",
            "重庆",
            "大连",
            "哈尔滨"
    };

    public static String[] CLASSES = {
            "20104058 北京 to 上海 16:00~18:00",
            "20104057 太原 to 成都 17:00~18:00",
            "20104056 西藏 to 河北 6:00~18:00",
            "20104055 天津 to 海南 8:00~18:00"
    };

    public static String[] YEARS = {
            "2018",
            "2019"
    };

    public static String[] MONTH = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
    };

    public static TrainClass TESTCLASS = new TrainClass("00001", "WANG-101", "成都",
            "上海", 23982.1f, new Date(2018, 6, 18), 100);

}
