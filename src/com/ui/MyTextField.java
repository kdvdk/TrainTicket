package com.ui;

import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {
    public MyTextField(int x, int y, int width, int heigh, Font font) {
        this.setBounds(x, y, width, heigh);
        this.setFont(font);
    }
}
