package com.fragment;

import com.activity.MainActivity;
import com.base.BaseFragment;
import com.db.SqlUser;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.utils.ConstantsUtils;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.util.ArrayList;

public class BuyRecordFragment extends BaseFragment {


    private JList<String> mList;
    private JScrollPane scrollPane;
    private JLabel container;

    private JLabel[] dataList ;

    private ListModel<String> listModel ;
    private JButton informationButton;
    private JButton returnButton;
    @Override
    public void initView() {
        this.setLayout(null);
        //背景
        ImageIcon bg = new ImageIcon(MainActivity.class.getResource("images//user_bg_4.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH,
                        ConstantsUtils.LOGIN_HEIGH - 70,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH - 70);

        loadData();
        scrollPane = new JScrollPane(mList);
        scrollPane.setBounds(0,0,300,400);
        container = new MyLabel( "",50,30,350,400,textFont);
        container.add(scrollPane);


        informationButton = new MyButton("查看详细",80,470,90,30,textFont,1);
        returnButton = new MyButton("退票",230,470,90,30,textFont,2);


        this.add(informationButton);
        this.add(returnButton);
        this.add(container);
        this.add(bgLabel);

    }

    @Override
    public SqlUser initSqlUser() {
        return null;
    }

    private void loadData(){
        listModel = new DefaultComboBoxModel<>(new String[]{
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1",
                "车票号："+ConstantsUtils.TESTTICKET.getTicketNumber()+" 班次号："+ConstantsUtils.TESTTICKET.getClassNumber()+" 出发时间："+"2018-11-1"
        });
        mList = new JList<>();
        mList.setModel(listModel);
    }

}
