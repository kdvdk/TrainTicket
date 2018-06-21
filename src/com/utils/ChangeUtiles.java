package com.utils;

import com.bean.IdCard;
import com.bean.TrainClass;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ChangeUtiles {
    /**
     * sql date maker
     *
     * @param date
     * @return
     */
    public static Date createDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date date1 = format.parse(date);
            Date re = new Date(date1.getTime());
            return re;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * list 2 Array
     *
     * @param mList
     * @return
     */
    public static String[] trainClassesListToArray(List<TrainClass> mList) {
        String[] re = new String[mList.size()];
        for (int i = 0; i < mList.size(); i++) {
            TrainClass item = mList.get(i);
            re[i] = item.getClassNumber() + " " + item.getDepaturePlace() + " to " + item.getGoalPlace() + " " + item.getDepatureDay();
            System.out.println(re[i]);
        }
        return re;
    }

    public static String[] idCardListToArray(List<IdCard> mList) {
        String[] re = new String[mList.size()];
        for (int i = 0; i < mList.size(); i++) {
            IdCard item = mList.get(i);
            re[i] = item.getName() + "  " + item.getIdCardNumber();
            System.out.println(re[i]);
        }
        return re;
    }
}
