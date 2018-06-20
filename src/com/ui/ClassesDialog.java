package com.ui;

import com.activity.UserActivity;
import com.bean.TrainClass;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;

public class ClassesDialog extends JFrame {

    private JFrame frame;
    private Font textFont = new Font("宋体",Font.BOLD,15);
    private TrainClass trainClass ;
    public ClassesDialog(TrainClass trainClass) throws HeadlessException {
        this.trainClass = trainClass;
        initView();
    }

    /**
     * UI初始化
     */
    private void initView(){
        frame = this;
        //背景图
        ImageIcon bg = new ImageIcon(UserActivity.class.getResource("images//dialog_bg.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH/3+100,
                        ConstantsUtils.LOGIN_HEIGH/3 ,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH/3+100, ConstantsUtils.LOGIN_HEIGH/3 );



        this.setLayout(null);
        this.setBounds(ConstantsUtils.LOGIN_X+ConstantsUtils.LOGIN_WIDTH/3-50,ConstantsUtils.LOGIN_Y+ConstantsUtils.LOGIN_HEIGH/3,
                ConstantsUtils.LOGIN_WIDTH/3+100,ConstantsUtils.LOGIN_HEIGH/3);
        this.setTitle("班次信息");

        int x_star = 10;
        int y_star = 10;
        int width = ConstantsUtils.LOGIN_WIDTH/3+50;
        JLabel classNumber = new MyLabel("班次号："+trainClass.getClassNumber(),x_star+20,y_star,width,30,textFont);
        JLabel trainNumber = new MyLabel("火车号："+trainClass.getTrainNumber(),x_star+20,y_star=y_star+20,width,30,textFont);
        JLabel depaturePlace = new MyLabel("出发地："+trainClass.getDepaturePlace(),x_star+20,y_star=y_star+20,width,30,textFont);
        JLabel goalPlace = new MyLabel("目的地："+trainClass.getGoalPlace(),x_star+20,y_star=y_star+20,width,30,textFont);
        JLabel depatureTime1 = new MyLabel("出发时间：",x_star+20,y_star=y_star+20,width,30,textFont);
        JLabel depatureTime2 = new MyLabel(trainClass.getDepatureDay()+"  "+trainClass.getTime(),x_star+20,y_star=y_star+20,width,30,textFont);
        JLabel numberOfPassenger = new MyLabel("现已有乘客数："+trainClass.getPassengerNumber(),x_star+20,y_star+=20,width,30,textFont);

        this.add(numberOfPassenger);
        this.add(depatureTime1);
        this.add(depatureTime2);
        this.add(depaturePlace);
        this.add(goalPlace);
        this.add(trainNumber);
        this.add(classNumber);
        this.setVisible(true);
        this.add(bgLabel);

    }
}
