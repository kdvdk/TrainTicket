package com.activity;

import com.base.BaseActivity;
import com.db.SqlUser;
import com.fragment.Place2PlaceFragment;
import com.fragment.TicketsQueryFragment;
import com.sun.java.swing.plaf.motif.MotifTabbedPaneUI;
import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;
import com.ui.BackgroundUi;
import com.ui.MyFrame;
import com.ui.MyLabel;
import com.utils.ConstantsUtils;
import org.jb2011.lnf.beautyeye.ch2_tab.BETabbedPaneUI;

import javax.swing.*;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import javax.swing.plaf.multi.MultiTabbedPaneUI;
import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.awt.*;

public class MainActivity extends BaseActivity {

    private MyFrame myFrame;
    private JPanel container;
    private JTabbedPane tabbedPane;
    private JPanel firstLabel;
    private JPanel secondLabel;


    @Override
    public void initView() {
        //通用格式
        Font titleFont = new Font("宋体", Font.PLAIN, 18);
        UIManager.put("TabbedPane.tabAreaInsets"
                , new javax.swing.plaf.InsetsUIResource(10, 10, 2, 20));

        //tab切换内容
        firstLabel = new Place2PlaceFragment();
        secondLabel = new TicketsQueryFragment();

        //tab
        tabbedPane = new JTabbedPane();

        tabbedPane.add("站站查询", firstLabel);
        tabbedPane.add("车票查询", secondLabel);

        //new WindowsTabbedPaneUI()
        tabbedPane.setUI(new MotifTabbedPaneUI());

        container = new JPanel(new BorderLayout());
        container.add(tabbedPane);
        myFrame = new MyFrame();
//        myFrame.setBG(new BackgroundUi("images//bg.png"));
        myFrame.add(container);
        myFrame.setVisible(true);
    }

    @Override
    public SqlUser initSqlUser() {
        return null;
    }
}
