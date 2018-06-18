package com.ui;

import com.activity.MainActivity;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;

public class BackgroundUi extends JLabel {

    private ImageIcon icon;

    public BackgroundUi(String picturePath) {
        icon = new ImageIcon(MainActivity.class.getResource(picturePath));
        icon.setImage(icon.getImage()
                .getScaledInstance(ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH, Image.SCALE_DEFAULT));
        this.setIcon(icon);
        this.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH);
    }
}
