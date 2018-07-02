package com.dialog;

import com.Main;
import com.activity.UserActivity;
import com.base.BaseActivity;
import com.base.BaseDialog;
import com.bean.Ticket;
import com.bean.TrainClass;
import com.db.SqlUser;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InformationDialog extends BaseDialog {

    private JLabel place;
    private JLabel ticketNumber;
    private JLabel classesNumber;
    private JLabel peopleName;
    private JLabel depatureTime;
    private JLabel seatNumber;
    private JLabel price;
    private JButton okButton;

    private int x_star = 30;
    private int y_star = 30;
    private int mergin = 40;

    private Ticket ticket;
    private TrainClass trainClass;

    public InformationDialog(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void initView() {
        loadData();
        place = new MyLabel("出发地：" + trainClass.getDepaturePlace() + "    目的地：" + trainClass.getGoalPlace(),
                x_star, y_star, 300, 30, textFont);
        ticketNumber = new MyLabel("车票号：" + ticket.getTicketNumber(), x_star, y_star += mergin, 300, 30, textFont);
        classesNumber = new MyLabel("班次号：" + trainClass.getClassNumber(), x_star, y_star += mergin, 300, 30, textFont);
        try {
            peopleName = new MyLabel("乘车人：" + getSqlUtiles().queryIdCard(ticket.getIdCardNumber()).getName() + " " + ticket.getIdCardNumber()
                    , x_star, y_star += mergin, 300, 30, textFont);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        depatureTime = new MyLabel("出发时间：" + trainClass.getDepatureDay() + " " + trainClass.getTime(), x_star, y_star += mergin, 300, 30, textFont);
        seatNumber = new MyLabel("座位号：   " + ticket.getCompartment() + "车厢    " + ticket.getSeatNumber() + "号座位", x_star, y_star += mergin, 300, 30, textFont);
        price = new MyLabel("车票费：" + ticket.getTicketPrice(), x_star, y_star += mergin, 300, 30, textFont);
        okButton = new MyButton("确认", x_star + 70, y_star += 50, 100, 40, textFont, MyButton.TYPE_OK);

        myFrame.add(okButton);
        myFrame.add(peopleName);
        myFrame.add(depatureTime);
        myFrame.add(price);
        myFrame.add(seatNumber);
        myFrame.add(ticketNumber);
        myFrame.add(classesNumber);
        myFrame.add(place);
        initFrame("images//information_bg.jpg");
    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(Main.user.getType());
    }

    @Override
    public void addListener() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.dispose();
            }
        });
    }

    @Override
    public void loadData() {
        try {
            this.trainClass = getSqlUtiles().queryClasses(ticket.getClassNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
