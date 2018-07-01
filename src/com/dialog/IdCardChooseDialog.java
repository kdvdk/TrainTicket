package com.dialog;

import com.Main;
import com.activity.UserActivity;
import com.base.BaseActivity;
import com.bean.IdCard;
import com.bean.TrainClass;
import com.db.SqlUser;
import com.fragment.BuyRecordFragment;
import com.fragment.InformationFragment;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.utils.ChangeUtiles;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IdCardChooseDialog extends BaseActivity {
    private JFrame myFrame;
    private JButton okButton;
    //    private JButton cancelButton;
    private JLabel titleLabel;
    private JList<String> mList;
    private List<IdCard> dataList = new ArrayList<>();
    private JScrollPane scrollPane;

    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton windowButton;
    private JPanel panel;
    private int seatType;
    private TrainClass trainClass;
    private int nearWindows;
    private BuyRecordFragment fragment = null;
    private InformationFragment informationFragment;

    public IdCardChooseDialog(TrainClass trainClass) {
        super();
        this.trainClass = trainClass;
    }

    public IdCardChooseDialog(TrainClass trainClass, BuyRecordFragment fragment, InformationFragment informationFragment) {
        super();
        this.trainClass = trainClass;
        this.fragment = fragment;
        this.informationFragment = informationFragment;
    }

    @Override
    public void initView() {
        ImageIcon bg = new ImageIcon(UserActivity.class.getResource("images//idcard_bg.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH - 100,
                        ConstantsUtils.LOGIN_HEIGH - 200,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH - 100, ConstantsUtils.LOGIN_HEIGH - 200);

        int x_star = 30;
        int y_star = 30;

        windowButton = new JRadioButton("靠窗");
        windowButton.setBounds(x_star + 75, y_star + 15, 70, 30);

        titleLabel = new MyLabel("请选择乘客", x_star + 70, y_star - 20, 400, 40, titleFont);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);


        mList = new JList<>();
        loadData();
        scrollPane = new JScrollPane(mList);
        scrollPane.setBounds(x_star, y_star + 50, 235, 160);


        radioButton1 = new JRadioButton("一等座");
        radioButton2 = new JRadioButton("二等座");
        radioButton3 = new JRadioButton("卧铺");
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);
        panel.setBounds(x_star, y_star + 220, 250, 40);
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);


        okButton = new MyButton("确认", x_star + 70, y_star + 270, 100, 40, textFont, MyButton.TYPE_OK);

        myFrame = new JFrame();
        myFrame.setBounds(ConstantsUtils.LOGIN_X + 50, ConstantsUtils.LOGIN_Y + 100, ConstantsUtils.LOGIN_WIDTH - 100,
                ConstantsUtils.LOGIN_HEIGH - 200);
        myFrame.setTitle("选择乘客");
        myFrame.add(titleLabel);
        myFrame.add(scrollPane);
        myFrame.add(okButton);
        myFrame.add(panel);
        myFrame.add(windowButton);
        myFrame.add(bgLabel);
        myFrame.setLayout(null);
        myFrame.setVisible(true);
    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(Main.user.getType());
    }

    @Override
    public void addListener() {

        windowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nearWindows = 1;
            }
        });

        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seatType = 0;
            }
        });
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seatType = 1;
            }
        });
        radioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seatType = 2;
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChossesCreditCardDialog chossesCreditCardDialog = new ChossesCreditCardDialog(trainClass,
                        dataList.get(mList.getSelectedIndex()), nearWindows, seatType, fragment,informationFragment);
                myFrame.dispose();
            }
        });
    }

    public void loadData() {
        ListModel listModel = null;
        try {
            dataList = getSqlUtiles().queryIdCard(Main.user);
            listModel = new DefaultComboBoxModel<String>(ChangeUtiles.idCardListToArray(dataList));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mList.setModel(listModel);
    }
}
