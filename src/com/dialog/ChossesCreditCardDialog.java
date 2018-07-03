package com.dialog;

import com.Main;
import com.base.BaseDialog;
import com.base.BaseFragment;
import com.bean.CreditCard;
import com.bean.IdCard;
import com.bean.TrainClass;
import com.db.SqlUser;
import com.fragment.InformationFragment;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.utils.ChangeUtiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ChossesCreditCardDialog extends BaseDialog {

    private JLabel title;
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
        super();
        this.trainClass = trainClass;
        this.idCard = idCard;
        this.nearWindows = nearWindows;
        this.seatType = seatType;
        this.fragment = fragment;
        this.informationFragment = information;
    }

    @Override
    public void initView() {
        title = new MyLabel("请选择支付银行卡", 90, 30, 300, 40, textFont);
        mList = new JList<>();
        loadData();
        scrollPane = new JScrollPane(mList);
        scrollPane.setBounds(30, 80, 250, 200);
        okButton = new MyButton("确认", 100, 300, 100, 40, textFont, MyButton.TYPE_OK);
        myFrame.add(okButton);
        myFrame.add(scrollPane);

        myFrame.add(title);
         initFrame("images//people_bg.jpg");
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
                    if (getSqlHelper().buyTicket(trainClass, idCard, nearWindows, seatType, datas.get(mList.getSelectedIndex()))) {
                        showMessageDialog("购买成功");
                        fragment.loadData();
                        informationFragment.loadData();
                        myFrame.dispose();
                    } else {
                        showMessageDialog("该乘车人已购买过，购买失败");
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

    @Override
    public void loadData() {
        ListModel listModel = null;
        try {
            datas = getSqlHelper().queryCreditCard(Main.user);
            listModel = new DefaultComboBoxModel<String>(ChangeUtiles.creditCardListToArray(datas));
            System.out.println(listModel.getElementAt(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mList.setModel(listModel);
    }
}
