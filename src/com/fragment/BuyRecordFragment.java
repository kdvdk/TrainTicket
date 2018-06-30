package com.fragment;

import com.Main;
import com.activity.UserActivity;
import com.base.BaseFragment;
import com.bean.Ticket;
import com.db.SqlUser;
import com.ui.InformationDialog;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.utils.ChangeUtiles;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyRecordFragment extends BaseFragment {


    private JList<String> mList;
    private JScrollPane scrollPane;
    private JLabel container;


    private ListModel<String> listModel;
    private JButton informationButton;
    private JButton returnButton;

    private List<Ticket> datas = new ArrayList<>();

    @Override
    public void initView() {
        this.setLayout(null);
        //背景
        ImageIcon bg = new ImageIcon(UserActivity.class.getResource("images//user_bg_4.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH,
                        ConstantsUtils.LOGIN_HEIGH - 70,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH - 70);
        mList = new JList<>();
        loadData();
        scrollPane = new JScrollPane(mList);
        scrollPane.setBounds(0, 0, 300, 400);
        container = new MyLabel("", 50, 30, 350, 400, textFont);
        container.add(scrollPane);

        informationButton = new MyButton("查看详细", 80, 470, 90, 30, textFont, 1);
        returnButton = new MyButton("退票", 230, 470, 90, 30, textFont, 2);


        this.add(informationButton);
        this.add(returnButton);
        this.add(container);
        this.add(bgLabel);

    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(SqlUser.USER_TYPE);
    }

    @Override
    public void loadData() {
        datas.clear();
        datas = getSqlUtiles().queryTickets(Main.user);
        try {
            listModel = new DefaultComboBoxModel<>(ChangeUtiles.ticketsListToArray(datas, getSqlUtiles()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mList.setModel(listModel);
    }

    @Override
    public void addListener() {

        informationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InformationDialog informationDialog = new InformationDialog(datas.get(mList.getSelectedIndex()));
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getSqlUtiles().returnTheTicket(datas.get(mList.getSelectedIndex()))) {
                    showMessageDialog("退票成功");
                    loadData();
                } else {
                    showMessageDialog("退票失败");
                }
            }
        });
    }

}
