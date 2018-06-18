package com.fragment;

import com.activity.LoginActivity;
import com.sun.java.swing.plaf.motif.MotifLabelUI;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Place2PlaceFragment extends JPanel {

    private JComboBox<String> startPlace;
    private JComboBox<String> goalPlace;
    private JLabel exchangeIcon;
    private JButton queryButton;

    private JSplitPane splitPane;
    private JList<String> classes;

    public Place2PlaceFragment() {
        this.setLayout(null);
        initView();
    }

    private void initView() {
        int xStart = 70;
        int yStart = 20;
        startPlace = new JComboBox<>();
        startPlace.setBounds(xStart, yStart, 80, 40);
        goalPlace = new JComboBox<>();
        goalPlace.setBounds(xStart + 180, yStart, 80, 40);
        for (int i = 0; i < ConstantsUtils.CITIES.length; i++) {
            startPlace.addItem(ConstantsUtils.CITIES[i]);
            goalPlace.addItem(ConstantsUtils.CITIES[i]);

        }

        ImageIcon bgim = new ImageIcon(LoginActivity.class.getResource("images//exchange.jpg"));//背景图案
        bgim.setImage(bgim.getImage().
                getScaledInstance(30,
                        30,
                        Image.SCALE_DEFAULT));
        exchangeIcon = new MyLabel("", xStart + 115, 20 - 5, 100, 50, new Font("黑体", Font.HANGING_BASELINE, 20));
        exchangeIcon.setIcon(bgim);
        queryButton = new JButton("查询");
        queryButton.setFont(new Font("黑体", Font.PLAIN, 15));

        xStart = 20;
        yStart = 20 + 70;

        splitPane = new JSplitPane();
        JLabel left = new JLabel("左边");
        left.setLayout(null);

        JLabel right = new JLabel("右边");


        splitPane.setLeftComponent(left);
        splitPane.setRightComponent(right);
        //splitPane.setLayout(null);
        splitPane.setBounds(xStart, yStart, 360, 420);
        splitPane.setDividerLocation(250);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);


        this.add(new JLabel("                                                                  "));
        this.add(startPlace);
        this.add(exchangeIcon);
        this.add(goalPlace);
        this.add(splitPane);
//        this.add(new MyLabel("                                                                           ", new Font("黑体", Font.PLAIN, 5)));
//        this.add(queryButton);


    }
}
