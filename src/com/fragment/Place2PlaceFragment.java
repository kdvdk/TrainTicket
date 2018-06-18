package com.fragment;

import com.activity.LoginActivity;
import com.activity.MainActivity;
import com.eltima.components.ui.DatePicker;
import com.sun.java.swing.plaf.motif.MotifLabelUI;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Place2PlaceFragment extends JPanel {

    private JComboBox<String> startPlace;
    private JComboBox<String> goalPlace;
    private JLabel exchangeIcon;

    private JButton queryButton;
    private JButton buyButton;

    private JSplitPane splitPane;
    private JList<String> classesList;


    private DatePicker datePicker;


    public Place2PlaceFragment() {
        this.setLayout(null);
        initView();
    }

    private void initView() {
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
        ImageIcon bgim = new ImageIcon(MainActivity.class.getResource("images//exchange.jpg"));//背景图案
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
        classesList = new JList<>();
        classesList.setBounds(10, 20, 230, 400);
        classesList.setPreferredSize(new Dimension(230, 100));
        classesList.setListData(ConstantsUtils.CLASSES);
        left.add(classesList);


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
        ImageIcon bg = new ImageIcon(MainActivity.class.getResource("images//user_bg_1.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH,
                        ConstantsUtils.LOGIN_HEIGH - 100,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH - 100);



        //时间控件
        datePicker = getDatePicker();
        datePicker.setBounds(150,50,100,50);
        datePicker.setFont(new Font("黑体",Font.PLAIN,18));
        this.add(new JLabel("                                                                  "));
        this.add(startPlace);
        this.add(exchangeIcon);
        this.add(goalPlace);
        this.add(splitPane);
        this.add(datePicker);
        this.add(bgLabel, new Integer(Integer.MIN_VALUE));

    }

    private void queryData(String start, String goal) {

    }

    /**
     * 初始化时间控件
     *
     * @return
     */
    private DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        Dimension dimension = new Dimension(177, 24);

        int[] hilightDays = {1, 3, 5, 7};

        int[] disabledDays = {4, 6, 5, 9};
        //构造方法（初始时间，时间显示格式，字体，控件大小）
        datepick = new DatePicker(date, DefaultFormat, font, dimension);

        datepick.setLocation(137, 83);//设置起始位置
        /*
        //也可用setBounds()直接设置大小与位置
        datepick.setBounds(137, 83, 177, 24);
        */
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CANADA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);

        return datepick;
    }
}