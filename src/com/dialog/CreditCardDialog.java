package com.dialog;

import com.Main;
import com.activity.UserActivity;
import com.base.BaseActivity;
import com.base.BaseDialog;
import com.base.BaseFragment;
import com.bean.CreditCard;
import com.db.SqlUser;
import com.fragment.InformationFragment;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.ui.MyTextField;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditCardDialog extends BaseDialog {

    private JButton okButton;
    private JLabel cardNumberTitle;
    private JLabel cardBalanceTitle;
    private JTextField cardNumberInput;
    private JTextField cardBalanceInput;
    private BaseFragment informationFragment;

    public CreditCardDialog(BaseFragment informationFragment) {
        this.informationFragment = informationFragment;
    }

    @Override
    public void initView() {
        int x_star = 30;
        int y_star = 50;
        int mergin = 80;

        cardNumberTitle = new MyLabel("卡号", x_star, y_star, 100, 30, textFont);
        cardNumberInput = new MyTextField(x_star + 70, y_star, 150, 40, textFont);
        cardBalanceTitle = new MyLabel("余额", x_star, y_star += mergin, 100, 30, textFont);
        cardBalanceInput = new MyTextField(x_star + 70, y_star, 150, 40, textFont);

        okButton = new MyButton("添加", x_star + 70, y_star + 170, 100, 40, textFont, MyButton.TYPE_OK);

        myFrame.setBounds(ConstantsUtils.LOGIN_X + 50, ConstantsUtils.LOGIN_Y + 100, ConstantsUtils.LOGIN_WIDTH - 100,
                ConstantsUtils.LOGIN_HEIGH - 200);
        myFrame.add(cardBalanceInput);
        myFrame.add(cardNumberTitle);
        myFrame.add(okButton);
        myFrame.add(cardNumberInput);
        myFrame.add(cardBalanceTitle);
        initFrame("images//idcard_bg.jpg");
    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(Main.user.getType());
    }

    @Override
    public void loadData() {

    }

    @Override
    public void addListener() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreditCard creditCard = new CreditCard(cardNumberInput.getText(), Main.user.getUserPhone(),
                        Float.valueOf(cardBalanceInput.getText()));
                if (getSqlUtiles().insertCreditCard(creditCard)) {
                    showMessageDialog("添加成功");
                    myFrame.dispose();
                    informationFragment.loadData();
                } else {
                    showMessageDialog("添加失败");
                }
            }
        });
    }
}
