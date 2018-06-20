package com.fragment;

import com.activity.UserActivity;
import com.base.BaseFragment;
import com.db.SqlUser;
import com.eltima.components.ui.DatePicker;
import com.ui.MyButton;
import com.ui.MyDatePicker;
import com.ui.MyLabel;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Locale;

public class Place2PlaceFragment extends BaseFragment {

    private JComboBox<String> startPlace;
    private JComboBox<String> goalPlace;
    private JLabel exchangeIcon;

    private JButton queryButton;
    private JButton buyButton;

    private JSplitPane splitPane;
    private JList<String> classesList;

    private JScrollPane scrollPane;

    private DatePicker datePicker;

    @Override
    public void initView() {
        this.setLayout(null);
        int xStart = 60;
        int yStart = 20;
        startPlace = new JComboBox<>();
        startPlace.setBounds(xStart, yStart, 100, 40);
        goalPlace = new JComboBox<>();
        goalPlace.setBounds(xStart + 180, yStart, 100, 40);
        for (int i = 0; i < ConstantsUtils.CITIES.length; i++) {
            startPlace.addItem(ConstantsUtils.CITIES[i]);
            goalPlace.addItem(ConstantsUtils.CITIES[i]);

        }
        ImageIcon bgim = new ImageIcon(UserActivity.class.getResource("images//exchange.jpg"));//背景图案
        bgim.setImage(bgim.getImage().
                getScaledInstance(30,
                        30,
                        Image.SCALE_DEFAULT));
        exchangeIcon = new MyLabel("", xStart + 125, 20 - 5, 100, 50, new Font("黑体", Font.HANGING_BASELINE, 20));
        exchangeIcon.setIcon(bgim);
        queryButton = new JButton("查询");
        queryButton.setFont(new Font("黑体", Font.PLAIN, 15));

        xStart = 20;
        yStart = 20 + 70;

        //分页
        splitPane = new JSplitPane();
        JPanel left = new JPanel();
        left.setLayout(null);
        //左侧list
        classesList = new JList();
//        classesList.setBounds();
//        classesList.setPreferredSize();
        ListModel listModel = new DefaultComboBoxModel(ConstantsUtils.CLASSES);
//        classesList.setListData(ConstantsUtils.CLASSES);
        classesList.setModel(listModel);
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(classesList);
        scrollPane.setBounds(10, 20, 240, 350);
//        scrollPane.setViewportView(classesList);
        left.add(scrollPane);


        //右侧
        JLabel right = new JLabel();
        queryButton = new MyButton("查询", 10, 135, 80, 30, new Font("宋体", Font.PLAIN, 15), 1);
        right.add(queryButton);
        buyButton = new MyButton("购买", 10, 235, 80, 30, new Font("宋体", Font.PLAIN, 15), 1);
        right.add(buyButton);


        splitPane.setLeftComponent(left);
        splitPane.setRightComponent(right);
        //splitPane.setLayout(null);
        splitPane.setBounds(xStart, yStart, 360, 420);
        splitPane.setDividerLocation(250);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);

        //背景图
        ImageIcon bg = new ImageIcon(UserActivity.class.getResource("images//user_bg_1.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH,
                        ConstantsUtils.LOGIN_HEIGH - 70,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH - 70);


        //时间控件
        MyDatePicker myDatePicker = new MyDatePicker();
        datePicker = myDatePicker.getDatePicker();
        datePicker.setBounds(150, 63, 100, 25);
        datePicker.setFont(new Font("黑体", Font.PLAIN, 18));
        this.add(new JLabel("                                                                  "));
        this.add(startPlace);
        this.add(exchangeIcon);
        this.add(goalPlace);
        this.add(splitPane);
        this.add(datePicker);
        this.add(bgLabel, new Integer(Integer.MIN_VALUE));

    }

    @Override
    public SqlUser initSqlUser() {
        return null;
    }

    private void queryData(String start, String goal) {

    }


}
