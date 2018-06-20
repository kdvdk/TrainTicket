package com.activity;

import com.base.BaseActivity;
import com.db.SqlUser;
import com.fragment.BuyRecordFragment;
import com.fragment.InformationFragment;
import com.fragment.Place2PlaceFragment;
import com.fragment.TicketsQueryFragment;
import com.sun.java.swing.plaf.motif.MotifTabbedPaneUI;
import com.ui.MyFrame;

import javax.swing.*;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import javax.swing.plaf.multi.MultiTableUI;
import java.awt.*;

public class UserActivity extends BaseActivity {

    private MyFrame myFrame;
    private JPanel container;
    private JTabbedPane tabbedPane;
    private JPanel firstFragment;
    private JPanel secondFragment;
    private JPanel thirdFragment;
    private JPanel forthFragment;

    @Override
    public void initView() {
        //通用格式
        Font titleFont = new Font("宋体", Font.PLAIN, 18);
        UIManager.put("TabbedPane.tabAreaInsets"
                , new javax.swing.plaf.InsetsUIResource(10, 40, 2, 20));
        myFrame = new MyFrame();
        //tab切换内容
        firstFragment = new Place2PlaceFragment();
        secondFragment = new TicketsQueryFragment();
        thirdFragment = new BuyRecordFragment();
        forthFragment = new InformationFragment(myFrame);


        //tab
        tabbedPane = new JTabbedPane();
        tabbedPane.add("站站查询", firstFragment);
        tabbedPane.add("车票查询", secondFragment);
        tabbedPane.add("购票记录", thirdFragment);
        tabbedPane.add("个人信息", forthFragment);

        //new WindowsTabbedPaneUI()
//        tabbedPane.setUI(new MotifTabbedPaneUI());

        container = new JPanel(new BorderLayout());
        container.add(tabbedPane);

//        myFrame.setBG(new BackgroundUi("images//bg.png"));
        myFrame.add(container);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(SqlUser.USER_TYPE);
    }
}
