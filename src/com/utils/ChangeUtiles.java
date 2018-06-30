package com.utils;

import com.bean.CreditCard;
import com.bean.IdCard;
import com.bean.Ticket;
import com.bean.TrainClass;
import com.fragment.BuyRecordFragment;

import java.sql.Date;
import java.sql.SQLException;
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

    public static String[] ticketsListToArray(List<Ticket> mList, SqlUtiles sqlUtiles) throws SQLException {
        String[] re = new String[mList.size()];
        for (int i = mList.size() - 1; i >= 0; i--) {
            Ticket item = mList.get(i);
            TrainClass trainClass = sqlUtiles.queryClasses(item.getClassNumber());
            re[i] = "车票号：" + item.getTicketNumber() + " 班次号："
                    + item.getClassNumber() + " " + trainClass.getDepaturePlace() + " to " + trainClass.getGoalPlace()
                    + " 出发时间：" + trainClass.getDepatureDay();
            System.out.println(re[i]);
        }
        return re;
    }

    public static String[] creditCardListToArray(List<CreditCard> mList) {
        String[] re = new String[mList.size()];
        for (int i = 0; i < mList.size(); i++) {
            CreditCard item = mList.get(i);
            re[i] = "卡号：" + item.getCardNumber() + "  余额：" + item.getBalace();
            System.out.println(re[i]);
        }
        return re;
    }


}
