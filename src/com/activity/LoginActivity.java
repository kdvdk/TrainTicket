package com.activity;

import com.base.BaseActivity;
import com.db.SqlUser;
import com.ui.MyFrame;
import com.ui.MyLabel;
import com.utils.ConstantsUtils;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActivity extends BaseActivity {

    private JButton buttonLogin;//登陆按钮
    private JButton buttonRegister;//忘记密码按钮
    private JLabel containerLabel;//登录的版面
    private JFrame containerFrame;//登陆的框架
    private JTextField accountTextField;//用户名
    private JPasswordField passwordField;//密码
    private JLabel accountTextLabel;
    private JLabel passwordTextLabel;
    private JLabel iconContainer;
    private JLabel welcomeText;
    private JLabel message;


    /**
     * 初始化View
     */
    @Override
    public void initView() {
        Font font = new Font("黑体", Font.PLAIN, 18);//设置字体
        containerFrame = new MyFrame(ConstantsUtils.LOGIN_X, ConstantsUtils.LOGIN_Y, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH);
        //给登陆界面添加背景图片
        ImageIcon bgim = new ImageIcon(LoginActivity.class.getResource("images//bg.png"));//背景图案
        bgim.setImage(bgim.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH,
                        ConstantsUtils.LOGIN_HEIGH,
                        Image.SCALE_DEFAULT));
        //背景图
        iconContainer = new JLabel(bgim);
        //iconContainer.setBounds(100, 350, bgim.getIconWidth(), bgim.getIconHeight());
        iconContainer.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH);
        //welcome
        welcomeText = new MyLabel("欢迎使用火车票预售系统", 70, 20, 300,
                50, new Font("宋体", Font.PLAIN, 24));

        accountTextLabel = new MyLabel("手机号", 50, 120, 60, 50, font);

        passwordTextLabel = new MyLabel("密码", 50, 190, 60, 50, font);

        //提示信息
        message = new JLabel();
        message.setBounds(180, 240, 100, 50);
        message.setFont(new Font("宋体", Font.PLAIN, 15));
        message.setForeground(Color.red);
        message.setText("密码错误");

        //按钮
        buttonLogin = new JButton("登陆");         //更改成loginButton
        buttonLogin.setBounds(70, 390, 100, 50);
        buttonLogin.setFont(font);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (accountTextField.getText().equals("")) {
                    System.out.println("用户名为空");
                } else {
                    System.out.println(accountTextField.getText());
                }
            }
        });

        buttonRegister = new JButton("注册");
        buttonRegister.setBounds(230, 390, 100, 50);
        buttonRegister.setFont(font);
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterActivity registerActivity = new RegisterActivity();
                containerFrame.dispose();
            }
        });

        //加入文本框
        accountTextField = new JTextField();
        accountTextField.setBounds(130, 120, 210, 50);
        accountTextField.setFont(font);


        passwordField = new JPasswordField();//密码输入框
        passwordField.setBounds(130, 190, 210, 50);
        passwordField.setFont(font);


        containerLabel = new JLabel();
        containerLabel.add(accountTextField);
        containerLabel.add(passwordField);

        containerLabel.add(accountTextLabel);
        containerLabel.add(passwordTextLabel);
        containerLabel.add(buttonLogin);
        containerLabel.add(buttonRegister);

        containerLabel.add(welcomeText);

        containerLabel.add(message);
        message.setVisible(false);

        containerFrame.getLayeredPane().add(iconContainer, new Integer(Integer.MIN_VALUE));
        JPanel j = (JPanel) containerFrame.getContentPane();
        j.setOpaque(false);
        containerLabel.setOpaque(false);
        containerFrame.add(containerLabel);
        containerFrame.setVisible(true);
    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(SqlUser.USER_TYPE);
    }
}
