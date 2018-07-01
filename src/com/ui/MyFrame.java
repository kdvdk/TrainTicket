package com.ui;

import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    /**
     * 设置默认宽高、title、以及退出按钮
     *
     * @throws HeadlessException
     */
    public MyFrame() throws HeadlessException {
        //this.setBounds(ConstantsUtils.X, ConstantsUtils.Y, ConstantsUtils.WIDTH, ConstantsUtils.HEIGH);
        this.setBounds(ConstantsUtils.LOGIN_X, ConstantsUtils.LOGIN_Y, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(ConstantsUtils.TITLE);
        //this.getContentPane().add(new JPanel());
        System.out.println("1");
    }


    /**
     * 根据需求设置Frame大小
     * 设置默认TITLE
     *
     * @param x
     * @param y
     * @param width
     * @param heigh
     * @throws HeadlessException
     */
    public MyFrame(int x, int y, int width, int heigh) throws HeadlessException {

        this.setBounds(x, y, width, heigh);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(ConstantsUtils.TITLE);
    }


    /**
     * 设置背景图
     *
     * @param bgLabel
     */
    public void setBG(JLabel bgLabel) {
        this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));
        JPanel j = (JPanel) this.getContentPane();
        j.setOpaque(false);
        bgLabel.setOpaque(false);
        this.add(bgLabel);
    }

}
