package com.activity;

import com.Main;
import com.base.BaseActivity;
import com.bean.Train;
import com.bean.TrainClass;
import com.db.SqlUser;
import com.eltima.components.ui.DatePicker;
import com.ui.MyButton;
import com.ui.MyFrame;
import com.ui.MyLabel;
import com.ui.MyTextField;
import com.utils.ConstantsUtils;
import com.utils.SqlUtiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import java.util.Date;
import java.util.Locale;

public class TrainManagerActivity extends BaseActivity {
    private JComboBox<String> startPlace;
    private JComboBox<String> goalPlace;
    private JLabel exchangeIcon;

    private JButton newDataButton;
    private JButton deleteButton;
    private JButton queryButton;

    private JSplitPane splitPane;
    private JList<String> classesList;

    private JScrollPane scrollPane;

    private DatePicker datePicker;
    private MyFrame myFrame;

    private JButton classesTitleText;
    private JTextField classesText;
    private JTextField idText;
    private MyButton idTitleText;

    private JLabel reBoot ;

    private JFrame dialogFrame;

    @Override
    public void initView() {
        dialogFrame = new JFrame();
        dialogFrame.setSize(400,400);
        dialogFrame.setLocationRelativeTo(null);
        dialogFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame = new MyFrame();
        myFrame.setLayout(null);
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
        scrollPane.setBounds(10, 20, 230, 250);
//        scrollPane.setViewportView(classesList);
        left.add(scrollPane);


        //右侧
        JLabel right = new JLabel();
        newDataButton = new MyButton("发布", 10, 55, 80, 30, new Font("宋体", Font.PLAIN, 15), 0);
        newDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(listModel.getElementAt(classesList.getSelectedIndex()));
                int start_index = startPlace.getSelectedIndex();
                int goal_index = goalPlace.getSelectedIndex();
                String start = startPlace.getItemAt(startPlace.getSelectedIndex());
                String goal = goalPlace.getItemAt(goalPlace.getSelectedIndex());
                String time = datePicker.getText();
                String inputContent = JOptionPane.showInputDialog(dialogFrame,"输入列车号");
                String distanceCode = String.valueOf(startPlace.getSelectedIndex())+String.valueOf(goalPlace.getSelectedIndex());
                SqlUtiles sqlUtiles = new SqlUtiles(getSqlUser());
//                Train train = sqlUtiles.queryTrain(inputContent);
                if(start_index>goal_index){
                    distanceCode = String.valueOf(goalPlace.getSelectedIndex())+String.valueOf(startPlace.getSelectedIndex());
                }
                String temp = new String(inputContent);
                System.out.println(temp);
                float distance = Main.DISTANCEMAP.get(distanceCode);
                TrainClass trainClass = new TrainClass(inputContent.split("-")[1]+start_index+goal_index,temp,start,goal,distance,ConstantsUtils.createDate(time),0);
                if(sqlUtiles.addClass(trainClass)){
                    JOptionPane.showMessageDialog(dialogFrame,"成功","消息提示",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(dialogFrame,"失败","消息提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        right.add(newDataButton);
        deleteButton = new MyButton("删除", 10, 195, 80, 30, new Font("宋体", Font.PLAIN, 15), 2);
        right.add(deleteButton);
        queryButton = new MyButton("查看",10,125,80,30,new Font("宋体", Font.PLAIN, 15),1);
        right.add(queryButton);

        splitPane.setLeftComponent(left);
        splitPane.setRightComponent(right);
        //splitPane.setLayout(null);
        splitPane.setBounds(xStart, yStart, 360, 300);
        splitPane.setDividerLocation(250);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);

        //背景图
        ImageIcon bg = new ImageIcon(UserActivity.class.getResource("images//manager_bg.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH,
                        ConstantsUtils.LOGIN_HEIGH ,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH );



        int xStar = 30 ;
        int yStar = 420;
        classesTitleText = new MyButton("查询班次",xStar,yStar,110,30,textFont,0);
        classesText = new MyTextField(xStar+130,yStar-5,200,40,titleFont);

        idTitleText = new MyButton("身份证找人",xStar,yStar+60,110,30,textFont,0);
        idText = new MyTextField(xStar+130,yStar+60-5,200,40,titleFont);


        ImageIcon reboot = new ImageIcon(UserActivity.class.getResource("images//reboot.png"));//背景图案
        reboot.setImage(reboot.getImage().
                getScaledInstance(30,
                        30,
                        Image.SCALE_DEFAULT));
        reBoot = new MyLabel("", 190, 520, 100, 50, new Font("黑体", Font.HANGING_BASELINE, 20));
        reBoot.setIcon(reboot);
        reBoot.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                myFrame.dispose();
                LoginActivity loginActivity = new LoginActivity();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //时间控件
        datePicker = getDatePicker();
        datePicker.setBounds(150, 63, 100, 25);
        datePicker.setFont(new Font("黑体", Font.PLAIN, 18));
        myFrame.add(new JLabel("                                                                  "));
        myFrame.add(startPlace);
        myFrame.add(idText);
        myFrame.add(exchangeIcon);
        myFrame.add(goalPlace);
        myFrame.add(splitPane);
        myFrame.add(datePicker);
        myFrame.add(classesTitleText);
        myFrame.add(classesText);
        myFrame.add(reBoot);
        myFrame.add(idTitleText);
        myFrame.add(bgLabel, new Integer(Integer.MIN_VALUE));
        myFrame.setVisible(true);

    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(SqlUser.MANAGER_TYPE);
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
