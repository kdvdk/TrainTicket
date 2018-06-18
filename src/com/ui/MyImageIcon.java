package com.ui;

import com.Main;
import com.activity.LoginActivity;
import com.activity.MainActivity;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class MyImageIcon extends ImageIcon {
    public MyImageIcon(String path, int wid, int heigh) {
        super(getResource(path));
        this.setImage(this.getImage().
                getScaledInstance(wid,
                        heigh,
                        Image.SCALE_DEFAULT));
    }
}
