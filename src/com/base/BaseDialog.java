package com.base;

import com.activity.UserActivity;
import com.utils.ConstantsUtils;
import com.utils.SqlUtiles;

import javax.swing.*;
import java.awt.*;

public abstract class BaseDialog {
    protected JFrame myFrame;
    protected JLabel bgLabel;
    protected Font textFont;
    protected Font titleFont;
    protected SqlUtiles sqlUtiles;

    public BaseDialog(String bgPath) {
        this.sqlUtiles = initSQL();
        textFont = new Font("宋体", Font.PLAIN, 16);
        titleFont = new Font("宋体", Font.PLAIN, 20);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initBG(bgPath);
                initView();
                addListener();
            }
        });
        myFrame.setLayout(null);
        myFrame.setBounds(ConstantsUtils.LOGIN_X + 50, ConstantsUtils.LOGIN_Y + 100, ConstantsUtils.LOGIN_WIDTH - 100,
                ConstantsUtils.LOGIN_HEIGH - 200);
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

    public abstract SqlUtiles initSQL();

    public abstract void loadData();
}
