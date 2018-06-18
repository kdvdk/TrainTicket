package com.ui;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {

    /**
     * 自定义Label
     *
     * @param text
     * @param x
     * @param y
     * @param wid
     * @param heigh
     * @param font
     */
    public MyLabel(String text, int x, int y, int wid, int heigh, Font font) {
        super(text);
        this.setBounds(x, y, wid, heigh);
        this.setFont(font);
    }

    /**
     * 只有字的构造函数
     * @param text
     * @param font
     */
    public MyLabel(String text,Font font) {
        super(text);
        this.setFont(font);
    }

    public MyLabel() {
    }
}
