package com.activity;

import com.ui.MyFrame;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;

public class LoginActivity {

    private JButton buttonLogin;//登陆按钮
    private JButton buttonForget;//忘记密码按钮
    private JLabel containerLabel;//登录的版面
    private JFrame containerFrame;//登陆的框架
    private JTextField accountTextField;//用户名
    private JPasswordField passwordField;//密码
    private JLabel accountTextLabel;
    private JLabel passwordTextLabel;
    private JLabel iconContainer;
    private JLabel welcomeText;

    public LoginActivity() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initView();
            }
        });
    }

    private void initView() {

        Font font = new Font("黑体", Font.PLAIN, 15);//设置字体
        containerFrame = new MyFrame(ConstantsUtils.LOGIN_X, ConstantsUtils.LOGIN_Y, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH);
        //给登陆界面添加背景图片
        ImageIcon bgim = new ImageIcon(LoginActivity.class.getResource("bg.png"));//背景图案
        bgim.setImage(bgim.getImage().
                getScaledInstance(bgim.getIconWidth(),
                        bgim.getIconHeight(),
                        Image.SCALE_DEFAULT));

        //背景图
        iconContainer = new JLabel(bgim);
        iconContainer.setBounds(100, 350, bgim.getIconWidth(), bgim.getIconHeight());

        //welcome
        welcomeText = new JLabel();
        welcomeText.setFont(new Font("宋体", Font.PLAIN, 24));
        welcomeText.setText("欢迎使用火车票预售系统");
        welcomeText.setBounds(70, 30, 300, 50);

        accountTextLabel = new JLabel("用户名");
        accountTextLabel.setBounds(20, 100, 60, 50);
        accountTextLabel.setFont(font);

        passwordTextLabel = new JLabel("密码");
        passwordTextLabel.setBounds(20, 170, 60, 50);
        passwordTextLabel.setFont(font);

        buttonLogin = new JButton("登陆");         //更改成loginButton
        buttonLogin.setBounds(70, 270, 100, 50);
        buttonLogin.setFont(font);

        buttonForget = new JButton("退出");
        buttonForget.setBounds(230, 270, 100, 50);
        buttonForget.setFont(font);

        //加入文本框
        accountTextField = new JTextField();
        accountTextField.setBounds(110, 100, 250, 50);
        accountTextField.setFont(font);

        passwordField = new JPasswordField();//密码输入框
        passwordField.setBounds(110, 170, 250, 50);
        passwordField.setFont(font);


        containerLabel = new JLabel();
        containerLabel.add(accountTextField);
        containerLabel.add(passwordField);

        containerLabel.add(accountTextLabel);
        containerLabel.add(passwordTextLabel);
        containerLabel.add(buttonLogin);
        containerLabel.add(buttonForget);
        containerLabel.add(iconContainer);
        containerLabel.add(welcomeText);

        containerFrame.add(containerLabel);
        containerFrame.setVisible(true);
    }
}
