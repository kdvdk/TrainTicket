package com.fragment;

import com.activity.MainActivity;
import com.base.BaseFragment;
import com.db.SqlUser;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.ui.MyTextField;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;

public class TicketsQueryFragment extends BaseFragment {

    private JTextField inputTextField;
    private JLabel inputLabel;
    private Font titleFont;
    private JButton okButton;
    private Font textFont;

    private JLabel informationLabel;
    private JLabel classNumber;
    private JLabel trainNumber;
    private JLabel depaturePlace;
    private JLabel depatureTime;
    private JLabel restSeetNumber;

    @Override
    public void initView() {
        this.setLayout(null);
        //背景图
        ImageIcon bg = new ImageIcon(MainActivity.class.getResource("images//user_bg_2.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH,
                        ConstantsUtils.LOGIN_HEIGH - 100,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH - 100);

        titleFont = new Font("黑体", Font.PLAIN, 18);
        textFont = new Font("黑体", Font.PLAIN, 16);
        inputLabel = new MyLabel("请输入车票号:", 20, 50, 150, 50, titleFont);
        inputTextField = new MyTextField(150, 50, 220, 50, titleFont);

        okButton = new MyButton("查询", 155, 420, 100, 50, textFont, 1);


        informationLabel = new JLabel("1");
        informationLabel.setBounds(100, 200, 260, 300);


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
