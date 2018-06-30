package com.utils;

import com.bean.CreditCard;
import com.bean.IdCard;
import com.bean.Ticket;
import com.bean.TrainClass;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//
//    //frame size 400, 150, 1200, 720
//    public static int X = 400;
//    public static int Y = 150;
//    public static int WIDTH = 1200;
//    public static int HEIGH = 720;

    public static String[] CITIES = {
            "默认",
            "成都",
            "上海",
            "太原",
            "北京",
            "西藏",
            "天津",
            "海南",
            "深圳",
            "青岛",
            "厦门"

    };




    public static String[] CLASSES = {
            "20104058 北京 to 上海 16:00~18:00",
            "20104057 太原 to 成都 17:00~18:00",
            "20104056 西藏 to 河北 6:00~18:00",
            "20104055 天津 to 海南 8:00~18:00",
            "20104058 北京 to 上海 16:00~18:00",
            "20104057 太原 to 成都 17:00~18:00",
            "20104056 西藏 to 河北 6:00~18:00",
            "20104055 天津 to 海南 8:00~18:00",
            "20104058 北京 to 上海 16:00~18:00",
            "20104057 太原 to 成都 17:00~18:00",
            "20104056 西藏 to 河北 6:00~18:00",
            "20104055 天津 to 海南 8:00~18:00",
            "20104058 北京 to 上海 16:00~18:00",
            "20104057 太原 to 成都 17:00~18:00",
            "20104056 西藏 to 河北 6:00~18:00",
            "20104055 天津 to 海南 8:00~18:00",
            "20104058 北京 to 上海 16:00~18:00",
            "20104057 太原 to 成都 17:00~18:00",
            "20104056 西藏 to 河北 6:00~18:00",
            "20104055 天津 to 海南 8:00~18:00",
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
            "12"
    };

    public static Map<String,Float> DISTANCEMAP ;
    static {
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
        DISTANCEMAP.put("111",5465f);
        DISTANCEMAP.put("22",0f);
        DISTANCEMAP.put("23",2315f);
        DISTANCEMAP.put("24",3254f);
        DISTANCEMAP.put("25",7894f);
        DISTANCEMAP.put("26",3564f);
        DISTANCEMAP.put("27",4512f);
        DISTANCEMAP.put("28",5654f);
        DISTANCEMAP.put("29",9954f);
        DISTANCEMAP.put("210",8461f);
        DISTANCEMAP.put("211",5465f);
        DISTANCEMAP.put("33",0f);
        DISTANCEMAP.put("34",3541f);
        DISTANCEMAP.put("35",6554f);
        DISTANCEMAP.put("36",7423f);
        DISTANCEMAP.put("37",8798f);
        DISTANCEMAP.put("38",3456f);
        DISTANCEMAP.put("39",7541f);
        DISTANCEMAP.put("310",5410f);
        DISTANCEMAP.put("311",5465f);
        DISTANCEMAP.put("44",0f);
        DISTANCEMAP.put("45",7013f);
        DISTANCEMAP.put("46",9024f);
        DISTANCEMAP.put("47",2034f);
        DISTANCEMAP.put("48",1045f);
        DISTANCEMAP.put("49",1099f);
        DISTANCEMAP.put("410",5410f);
        DISTANCEMAP.put("411",5465f);
        DISTANCEMAP.put("55",0f);
        DISTANCEMAP.put("56",6540f);
        DISTANCEMAP.put("57",6651f);
        DISTANCEMAP.put("58",6666f);
        DISTANCEMAP.put("59",3333f);
        DISTANCEMAP.put("510",2222f);
        DISTANCEMAP.put("511",5465f);
        DISTANCEMAP.put("66",0f);
        DISTANCEMAP.put("67",1111f);
        DISTANCEMAP.put("68",1231f);
        DISTANCEMAP.put("69",7511f);
        DISTANCEMAP.put("610",9974f);
        DISTANCEMAP.put("611",5465f);
        DISTANCEMAP.put("77",0f);
        DISTANCEMAP.put("78",5461f);
        DISTANCEMAP.put("79",4444f);
        DISTANCEMAP.put("710",1446f);
        DISTANCEMAP.put("711",5465f);
        DISTANCEMAP.put("88",7821f);
        DISTANCEMAP.put("89",2586f);
        DISTANCEMAP.put("810",5461f);
        DISTANCEMAP.put("811",5465f);
        DISTANCEMAP.put("99",0f);
        DISTANCEMAP.put("910",7411f);
        DISTANCEMAP.put("911",5465f);
        DISTANCEMAP.put("1010",1233f);
        DISTANCEMAP.put("1011",5465f);

    }

    public static TrainClass TESTCLASS = new TrainClass("00001", "WANG-101", "成都",
            "上海", 23982.1f, new Date(2018, 6, 18), 100);
    public static Ticket TESTTICKET = new Ticket("N13223","WANG-123","07-A2",
            "510122199711011233",23.7f,1);
    public static IdCard TESTIDCARD = new IdCard("510122199711015523","王锐","男",new Date(2018));

    public static CreditCard TESTCARD = new CreditCard("5123541564216","王锐",780f);


}
