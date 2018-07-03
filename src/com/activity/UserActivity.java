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
    private BuyRecordFragment thirdFragment;
    private InformationFragment forthFragment;

    @Override
    public void initView() {
        //通用格式
        UIManager.put("TabbedPane.tabAreaInsets"
                , new javax.swing.plaf.InsetsUIResource(10, 40, 2, 20));
        myFrame = new MyFrame();
        //tab切换内容


        forthFragment = new InformationFragment(myFrame);
        thirdFragment = new BuyRecordFragment(forthFragment);
        firstFragment = new Place2PlaceFragment(thirdFragment, forthFragment);
        secondFragment = new TicketsQueryFragment(thirdFragment, forthFragment);


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

    @Override
    public void addListener() {

    }

    @Override
    public void loadData() {

    }
}
