package com.fragment;

import com.activity.MainActivity;
import com.base.BaseFragment;
import com.db.SqlUser;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;

public class InformationFragment extends BaseFragment {
    @Override
    public void initView() {
        this.setLayout(null);
        //背景图
        ImageIcon bg = new ImageIcon(MainActivity.class.getResource("images//user_bg_3.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH,
                        ConstantsUtils.LOGIN_HEIGH - 70,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH - 70);


        this.add(bgLabel);
    }

    @Override
    public SqlUser initSqlUser() {
        return null;
    }
}
