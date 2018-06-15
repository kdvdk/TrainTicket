package com.activity;

import com.ui.MyFrame;

import javax.swing.*;

public class LoginActivity {
    private JFrame frame;
    private JLabel label;

    public LoginActivity() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initView();
            }
        });
    }

    private void initView() {

        frame = new MyFrame();
        label = new JLabel("Hello world");
        frame.add(label);
        frame.setVisible(true);
    }
}
