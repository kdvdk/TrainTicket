package com.base;

import com.activity.UserActivity;
import com.db.SqlUser;
import com.utils.ConstantsUtils;
import com.db.SqlHelper;

import javax.swing.*;
import java.awt.*;

public abstract class BaseDialog {
    protected JFrame myFrame;
    protected JLabel bgLabel;
    protected Font textFont;
    protected Font titleFont;
    protected SqlHelper sqlHelper;
    private JFrame dialogFrame;

    public BaseDialog() {
        this.sqlHelper = new SqlHelper(initSqlUser());
        dialogFrame = new JFrame();
        dialogFrame.setSize(400, 400);
        dialogFrame.setLocationRelativeTo(null);
        dialogFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        textFont = new Font("宋体", Font.PLAIN, 16);
        titleFont = new Font("宋体", Font.PLAIN, 20);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myFrame = new JFrame();
                myFrame.setLayout(null);
                myFrame.setBounds(ConstantsUtils.LOGIN_X + 50, ConstantsUtils.LOGIN_Y + 100, ConstantsUtils.LOGIN_WIDTH - 100,
                        ConstantsUtils.LOGIN_HEIGH - 200);
                initView();
                addListener();
            }
        });
    }

    public void initFrame(String bgPath) {
        initBG(bgPath);
        myFrame.add(bgLabel);
        myFrame.setVisible(true);
    }

    public void initBG(String path) {
        ImageIcon bg = new ImageIcon(UserActivity.class.getResource(path));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH - 100,
                        ConstantsUtils.LOGIN_HEIGH - 200,
                        Image.SCALE_DEFAULT));
        this.bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH - 100, ConstantsUtils.LOGIN_HEIGH - 200);
    }

    public abstract void initView();

    public abstract void addListener();

    public abstract SqlUser initSqlUser();

    public SqlHelper getSqlHelper() {
        return sqlHelper;
    }

    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(dialogFrame, message, "消息提示", JOptionPane.INFORMATION_MESSAGE);
    }

    public abstract void loadData();
}
