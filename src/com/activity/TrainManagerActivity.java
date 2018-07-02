package com.activity;

import com.base.BaseActivity;
import com.bean.IdCard;
import com.bean.TrainClass;
import com.db.SqlUser;
import com.dialog.ClassesDialog;
import com.dialog.PeopleDetailDialog;
import com.eltima.components.ui.DatePicker;
import com.ui.*;
import com.utils.ChangeUtiles;
import com.utils.ConstantsUtils;
import com.db.SqlHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    private JButton queryClassesButton;
    private JTextField classesText;
    private JTextField idText;
    private MyButton queryPeopleButton;

    private JLabel reBoot;

    private JFrame dialogFrame;
    private String[] datas;
    private List<TrainClass> classList = new ArrayList<>();

    @Override
    public void initView() {
        dialogFrame = new JFrame();
        dialogFrame.setSize(400, 400);
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
        loadData();

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
                String day = datePicker.getText().split(" ")[0];
                String time = datePicker.getText().split(" ")[1];
//                System.out.println(time);
                String inputContent = JOptionPane.showInputDialog(dialogFrame, "输入列车号");
                String distanceCode = String.valueOf(startPlace.getSelectedIndex()) + String.valueOf(goalPlace.getSelectedIndex());
                SqlHelper sqlHelper = new SqlHelper(getSqlUser());
//                Train train = sqlHelper.queryTrain(inputContent);
                if (start_index > goal_index) {
                    distanceCode = String.valueOf(goalPlace.getSelectedIndex()) + String.valueOf(startPlace.getSelectedIndex());
                }
                String temp = new String(inputContent);
                System.out.println(temp);
                float distance = ConstantsUtils.DISTANCEMAP.get(distanceCode);
                TrainClass trainClass = new TrainClass(inputContent.split("-")[1] + start_index + goal_index,
                        temp, start, goal, distance, ChangeUtiles.createDate(day), 0);
                trainClass.setTime(time);
                if (sqlHelper.addClass(trainClass)) {
                    JOptionPane.showMessageDialog(dialogFrame, "成功", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(dialogFrame, "失败", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        right.add(newDataButton);
        deleteButton = new MyButton("删除", 10, 195, 80, 30, new Font("宋体", Font.PLAIN, 15), 2);

        right.add(deleteButton);
        queryButton = new MyButton("查看", 10, 125, 80, 30, new Font("宋体", Font.PLAIN, 15), 1);

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
                        ConstantsUtils.LOGIN_HEIGH,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH);


        int xStar = 30;
        int yStar = 420;
        queryClassesButton = new MyButton("查询班次", xStar, yStar, 110, 30, textFont, 0);

        classesText = new MyTextField(xStar + 130, yStar - 5, 200, 40, titleFont);

        queryPeopleButton = new MyButton("身份证找人", xStar, yStar + 60, 110, 30, textFont, 0);
        idText = new MyTextField(xStar + 130, yStar + 60 - 5, 200, 40, titleFont);


        ImageIcon reboot = new ImageIcon(UserActivity.class.getResource("images//reboot.png"));//背景图案
        reboot.setImage(reboot.getImage().
                getScaledInstance(30,
                        30,
                        Image.SCALE_DEFAULT));
        reBoot = new MyLabel("", 190, 520, 100, 50, new Font("黑体", Font.HANGING_BASELINE, 20));
        reBoot.setIcon(reboot);

        //时间控件
        MyDatePicker myDatePicker = new MyDatePicker();
        datePicker = myDatePicker.getDatePicker();
        datePicker.setBounds(135, 63, 130, 25);
        datePicker.setFont(new Font("黑体", Font.PLAIN, 18));
        myFrame.add(new JLabel("                                                                  "));
        myFrame.add(startPlace);
        myFrame.add(idText);
        myFrame.add(exchangeIcon);
        myFrame.add(goalPlace);
        myFrame.add(splitPane);
        myFrame.add(datePicker);
        myFrame.add(queryClassesButton);
        myFrame.add(classesText);
        myFrame.add(reBoot);
        myFrame.add(queryPeopleButton);
        myFrame.add(bgLabel, new Integer(Integer.MIN_VALUE));
        myFrame.setVisible(true);

    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(SqlUser.MANAGER_TYPE);
    }

    @Override
    public void addListener() {
        queryPeopleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdCard idCard = null;
                try {
                    idCard = getSqlHelper().queryIdCard(idText.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                if (idCard.getIdCardNumber().equals(" ")) {
                    showMessageDialog("查无此用户");
                } else {
                    PeopleDetailDialog peopleDetailDialog = new PeopleDetailDialog(idCard);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SqlHelper sqlHelper = getSqlHelper();
                if (sqlHelper.deleteClasses(classList.get(classesList.getSelectedIndex()))) {
                    JOptionPane.showMessageDialog(dialogFrame, "删除成功", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(dialogFrame, "删除失败", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClassesDialog classesDialog = new ClassesDialog(classList.get(classesList.getSelectedIndex()));
            }
        });
        queryClassesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SqlHelper sqlHelper = getSqlHelper();
                try {
                    TrainClass trainClass = sqlHelper.queryClasses(classesText.getText());
                    if (trainClass.getClassNumber().equals(" ")) {
                        JOptionPane.showMessageDialog(dialogFrame, "查无此班次", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        ClassesDialog classesDialog = new ClassesDialog(trainClass);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
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
    }

    private void loadData() {
        classList.clear();
        SqlHelper sqlHelper = new SqlHelper(getSqlUser());
        try {
            classList = sqlHelper.queryClasses();
            datas = ChangeUtiles.trainClassesListToArray(classList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ListModel listModel = new DefaultComboBoxModel(datas);
//        classesList.setListData(ConstantsUtils.CLASSES);
        classesList.setModel(listModel);
    }
}
