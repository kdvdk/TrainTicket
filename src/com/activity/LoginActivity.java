package com.activity;

import com.Main;
import com.base.BaseActivity;
import com.bean.User;
import com.db.SqlUser;
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


    private SqlUtiles sqlUtiles;
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


        //找回密码
        JLabel backMessage = new MyLabel("输入注册时的邮箱,若正确即可登录",70,240,350,50,new Font("宋体",Font.PLAIN,20));
        JTextField email = new MyTextField(70,300,250,50,font);
        backMessage.setVisible(false);
        email.setVisible(false);

        //提示信息
        message = new JLabel();
        message.setBounds(130, 240, 250, 50);
        message.setFont(new Font("宋体", Font.PLAIN, 15));
        message.setForeground(Color.red);
        message.setText("密码错误");
        message.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                email.setVisible(true);
                backMessage.setVisible(true);
                message.setVisible(false);
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

        //按钮
        buttonLogin = new JButton("登陆");         //更改成loginButton
        buttonLogin.setBounds(70, 390, 100, 50);
        buttonLogin.setFont(font);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(email.isVisible()){
                    String emailText = email.getText();
                    String limit = "WHERE UserEmail = '"+emailText+"'";
                    sqlUtiles = new SqlUtiles(getSqlUser());
                    User user = sqlUtiles.queryUser(limit);
                    if(user.getUserEmail().trim().equals(emailText)){
                        System.out.println("登录成功");
                        Main.user = user;
                    }
                }else{
                    if (accountTextField.getText().equals("")) {
                        System.out.println("用户名为空");
                    } else {
                        String account = accountTextField.getText();
                        String password = passwordField.getText();
                        String limit = "WHERE UserPhoneNumber = '"+account+"'";
                        sqlUtiles = new SqlUtiles(getSqlUser());
                        User user = sqlUtiles.queryUser(limit);
                        if(user.getUserPhone().equals("-")){
                            message.setText("查无此账号,请先注册");
                            message.setVisible(true);
                        }else{
                            System.out.println(user.getUserPassWord());
                            System.out.println(password);
                            if(user.getUserPassWord().trim().equals(password)){
                                setMessage("登录成功");
                                System.out.println("登录成功");
                                Main.user = user;
                            }else{
                                setMessage("密码错误_忘记密码？请点我");
                                System.out.println("密码错误");
                            }
                        }

                    }
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
        containerLabel.add(email);
        containerLabel.add(backMessage);
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

    private void setMessage(String s){
        message.setText(s);
        message.setVisible(true);
    }
}
