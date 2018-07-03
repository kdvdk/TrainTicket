package com.activity;

import com.Main;
import com.base.BaseActivity;
import com.bean.User;
import com.db.SqlUser;
import com.ui.MyButton;
import com.ui.MyFrame;
import com.ui.MyLabel;
import com.ui.MyTextField;
import com.utils.ConstantsUtils;
import com.db.SqlHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterActivity extends BaseActivity {
    private User user;

    private ImageIcon bgImage;
    private JLabel bgLabel;

    private JLabel welcomeLabel;
    private JLabel phoneLabel;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JLabel avatarNameLabel;
    private JLabel usualDepatureLabel;


    private JTextField phoneTextField;
    private JTextField passwordTextField;
    private JTextField emailTextField;
    private JTextField avaterNameTextField;
    private JTextField usualDepatureTextField;

    private JButton OKButton;
    private JButton BanckButton;

    private MyFrame myFrame;
    private JLabel container;


    private SqlHelper sqlHelper;

    @Override
    public void initView() {
        container = new JLabel();
        Font titleFont = new Font("宋体", Font.PLAIN, 24);
        Font textFont = new Font("黑体", Font.PLAIN, 17);
        myFrame = new MyFrame(ConstantsUtils.LOGIN_X, ConstantsUtils.LOGIN_Y, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH);

        int yStar = 90;
        int xStart = 50;
        int heigh = 50;
        int margin = 60;
        welcomeLabel = new MyLabel("注册", 180, 10, 70, heigh, titleFont);
        phoneLabel = new MyLabel("手机号", xStart, yStar, 70, heigh, textFont);
        passwordLabel = new MyLabel("密码", xStart, yStar = yStar + margin, 70, heigh, textFont);
        emailLabel = new MyLabel("邮箱", xStart, yStar = yStar + margin, 70, heigh, textFont);
        avatarNameLabel = new MyLabel("用户名", xStart, yStar = yStar + margin, 70, heigh, textFont);
        usualDepatureLabel = new MyLabel("常用出发地", xStart, yStar + margin, 100, heigh, textFont);

        yStar = 100;
        int width = 200;
        xStart = xStart + 100;
        heigh = 30;
        phoneTextField = new MyTextField(xStart, yStar, width, heigh, textFont);
        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(xStart, yStar += margin, width, heigh);
        passwordTextField.setFont(textFont);
        emailTextField = new MyTextField(xStart, yStar += margin, width, heigh, textFont);
        avaterNameTextField = new MyTextField(xStart, yStar += margin, width, heigh, textFont);
        usualDepatureTextField = new MyTextField(xStart, yStar += margin, width, heigh, textFont);


        /**
         * ok按钮
         */
        OKButton = new MyButton("完成", 90, 440, 80, 40, textFont, 1);
        /**
         * 返回按钮
         */
        BanckButton = new MyButton("返回", 230, 440, 80, 40, textFont, 2);

        //背景
        bgImage = new ImageIcon(RegisterActivity.class.getResource("images//registerbg.png"));
        bgImage.setImage(bgImage.getImage().getScaledInstance(ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH, Image.SCALE_DEFAULT));
        bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());

        myFrame.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));
        JPanel j = (JPanel) myFrame.getContentPane();
        j.setOpaque(false);

        container.add(emailLabel);
        container.add(welcomeLabel);
        container.add(phoneLabel);
        container.add(usualDepatureLabel);
        container.add(passwordLabel);
        container.add(avatarNameLabel);
        container.add(phoneTextField);
        container.add(passwordTextField);
        container.add(emailTextField);
        container.add(avaterNameTextField);
        container.add(usualDepatureTextField);
        container.add(OKButton);
        container.add(BanckButton);
        container.setOpaque(false);


        myFrame.setResizable(false);
        myFrame.add(container);
        myFrame.setVisible(true);
    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(SqlUser.USER_TYPE);
    }

    @Override
    public void addListener() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phone = phoneTextField.getText();
                String password = passwordTextField.getText();
                String email = emailTextField.getText();
                String avatarName = avaterNameTextField.getText();
                String usualDepature = usualDepatureTextField.getText();

                if (phone.equals("") || phone.length() < 10) {
                    showMessageDialog("输入不规范");
                } else if (password.equals("") || password.length() < 6) {
                    showMessageDialog("输入不规范");
                } else if (email.equals("") || email.length() < 6) {
                    showMessageDialog("输入不规范");
                } else if (avatarName.equals("")) {
                    showMessageDialog("输入不规范");
                } else if (usualDepature.length() != 2 && usualDepature.length() != 3) {
                    showMessageDialog("输入不规范");
                } else {
                    user = new User();
                    user.setUserPhone(phone);
                    user.setUserEmail(email);
                    user.setUserAvatarName(avatarName);
                    user.setUserPassWord(password);
                    user.setUsualDepature(usualDepature);
                    Main.user = user;
                    sqlHelper = new SqlHelper(getSqlUser());
                    if (sqlHelper.InsertUser(user)) {
                        System.out.println("注册成功");
                        banck();
                    } else {
                        showMessageDialog("注册失败，该用户已被注册");
                    }
                }
            }
        });
        BanckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                banck();
            }
        });
    }

    private void banck() {
        LoginActivity loginActivity = new LoginActivity();
        myFrame.dispose();

    }

}
