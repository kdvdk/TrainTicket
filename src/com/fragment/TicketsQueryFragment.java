package com.fragment;

import com.activity.MainActivity;
import com.base.BaseFragment;
import com.db.SqlUser;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.ui.MyTextField;
import com.utils.ConstantsUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketsQueryFragment extends BaseFragment {

    private JTextField inputTextField;
    private JLabel inputLabel;

    private JButton okButton;


    private JLabel informationLabel;
    private JLabel classNumber;
    private JLabel trainNumber;
    private JLabel depaturePlace;
    private JLabel goalPlace;
    private JLabel depatureTime;
    private JLabel restSeetNumber;

    @Override
    public void initView() {
        this.setLayout(null);
        //背景图
        ImageIcon bg = new ImageIcon(MainActivity.class.getResource("images//user_bg_2_cai.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH,
                        ConstantsUtils.LOGIN_HEIGH - 70,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH - 70);


        inputLabel = new MyLabel("请输入班次号:", 20, 50, 150, 50, titleFont);
        inputTextField = new MyTextField(150, 50, 220, 50, titleFont);
        Document document = inputTextField.getDocument();
        document.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                okButton.setText("查询");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                okButton.setText("查询");
            }
        });

        okButton = new MyButton("查询", 155, 420, 100, 50, textFont, 1);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okButton.setText("购买");
            }
        });

        informationLabel = new JLabel();
        informationLabel.setBounds(160, 130, 260, 300);

        int starty = 10;
        int margin = 40;
        classNumber = new MyLabel("班次号：" + ConstantsUtils.TESTCLASS.getClassNumber(), 10, starty, 200, 50, textFont);
        trainNumber = new MyLabel("火车号：" + ConstantsUtils.TESTCLASS.getTrainNumber(), 10, starty += margin, 200, 50, textFont);
        depaturePlace = new MyLabel("出发地点：" + ConstantsUtils.TESTCLASS.getDepaturePlace(), 10, starty += margin, 200, 50, textFont);
        goalPlace = new MyLabel("目的地：" + ConstantsUtils.TESTCLASS.getGoalPlace(), 10, starty += margin, 200, 50, textFont);
        depatureTime = new MyLabel("出发时间：" + ConstantsUtils.TESTCLASS.getDepatureTime(), 10, starty += margin, 200, 50, textFont);
        restSeetNumber = new MyLabel("剩余座位：" + ConstantsUtils.TESTCLASS.getPassengerNumber(), 10, starty += margin, 200, 50, textFont);
        informationLabel.add(classNumber);
        informationLabel.add(trainNumber);
        informationLabel.add(depaturePlace);
        informationLabel.add(goalPlace);
        informationLabel.add(depatureTime);
        informationLabel.add(restSeetNumber);
        //        informationLabel.setBackground(Color.red);

        //        informationLabel.setLayout(null);
        this.add(informationLabel);
        this.add(okButton);
        this.add(inputTextField);
        this.add(inputLabel);
        this.add(bgLabel);
    }

    @Override
    public SqlUser initSqlUser() {
        return null;
    }
}
