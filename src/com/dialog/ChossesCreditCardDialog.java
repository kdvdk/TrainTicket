package com.dialog;

import com.Main;
import com.activity.UserActivity;
import com.base.BaseActivity;
import com.base.BaseFragment;
import com.bean.CreditCard;
import com.bean.IdCard;
import com.bean.Ticket;
import com.bean.TrainClass;
import com.db.SqlUser;
import com.fragment.InformationFragment;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.utils.ChangeUtiles;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ChossesCreditCardDialog extends BaseActivity {

    private JLabel title;
    private JFrame myFrame;
    private JList<String> mList;
    private List<CreditCard> datas;
    private JScrollPane scrollPane;
    private JButton okButton;
    private TrainClass trainClass;
    private IdCard idCard;
    private int nearWindows;
    private int seatType;
    private BaseFragment fragment;
    private InformationFragment informationFragment;

    public ChossesCreditCardDialog(TrainClass trainClass, IdCard idCard, int nearWindows, int seatType,
                                   BaseFragment fragment, InformationFragment information) {
        this.trainClass = trainClass;
        this.idCard = idCard;
        this.nearWindows = nearWindows;
        this.seatType = seatType;
        this.fragment = fragment;
        this.informationFragment = information;
    }

    @Override
    public void initView() {
        ImageIcon bg = new ImageIcon(UserActivity.class.getResource("images//people_bg.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH - 100,
                        ConstantsUtils.LOGIN_HEIGH - 200,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH - 100, ConstantsUtils.LOGIN_HEIGH - 200);

        title = new MyLabel("请选择支付银行卡", 90, 30, 300, 40, textFont);

        mList = new JList<>();
        loadData();
        scrollPane = new JScrollPane(mList);
        scrollPane.setBounds(30, 80, 250, 200);
        okButton = new MyButton("确认", 100, 300, 100, 40, textFont, MyButton.TYPE_OK);

        myFrame = new JFrame("选择银行卡");
        myFrame.setLayout(null);
        myFrame.setBounds(ConstantsUtils.LOGIN_X + 50, ConstantsUtils.LOGIN_Y + 100, ConstantsUtils.LOGIN_WIDTH - 100,
                ConstantsUtils.LOGIN_HEIGH - 200);
        myFrame.add(okButton);
        myFrame.add(scrollPane);
        myFrame.add(title);
        myFrame.add(bgLabel);
        myFrame.setVisible(true);
    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(Main.user.getType());
    }

    @Override
    public void addListener() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (getSqlUtiles().buyTicket(trainClass, idCard, nearWindows, seatType, datas.get(mList.getSelectedIndex()))) {
                        showMessageDialog("购买成功");
                        fragment.loadData();
                        informationFragment.loadData();
                        myFrame.dispose();
                    } else {
                        showMessageDialog("购买失败");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                if (fragment != null) {
                    fragment.loadData();
                }
            }
        });
    }

    private void loadData() {
        ListModel listModel = null;
        try {
            datas = getSqlUtiles().queryCreditCard(Main.user);
            listModel = new DefaultComboBoxModel<String>(ChangeUtiles.creditCardListToArray(datas));
            System.out.println(listModel.getElementAt(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mList.setModel(listModel);
    }
}
