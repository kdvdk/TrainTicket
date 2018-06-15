package com.ui;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {


    //Button选择
    public static int TYPE_OK = 1;
    public static int TYPE_CANCEL = 2;
    public static int TYPE_DEFAULT = 0;

    /**
     * 自定义构造函数
     *
     * @param x
     * @param y
     * @param width
     * @param heigh
     * @param font
     */
    public MyButton(String text, int x, int y, int width, int heigh, Font font, int type) {
        this.setBounds(x, y, width, heigh);
        this.setFont(font);
        this.setText(text);
        if (type == TYPE_OK) {
            this.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        } else if (type == TYPE_CANCEL) {
            this.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        }
    }
}
