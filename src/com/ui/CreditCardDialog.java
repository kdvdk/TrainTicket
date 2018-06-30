package com.ui;

import com.Main;
import com.activity.UserActivity;
import com.base.BaseActivity;
import com.base.BaseFragment;
import com.bean.CreditCard;
import com.db.SqlUser;
import com.fragment.InformationFragment;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditCardDialog extends BaseActivity {

    private JFrame myFrame;
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
        ImageIcon bg = new ImageIcon(UserActivity.class.getResource("images//idcard_bg.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH - 100,
                        ConstantsUtils.LOGIN_HEIGH - 200,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH - 100, ConstantsUtils.LOGIN_HEIGH - 200);

        int x_star = 30;
        int y_star = 50;
        int mergin = 80;

        cardNumberTitle = new MyLabel("卡号", x_star, y_star, 100, 30, textFont);
        cardNumberInput = new MyTextField(x_star + 70, y_star, 150, 40, textFont);
        cardBalanceTitle = new MyLabel("余额", x_star, y_star += mergin, 100, 30, textFont);
        cardBalanceInput = new MyTextField(x_star + 70, y_star, 150, 40, textFont);

        okButton = new MyButton("添加", x_star + 70, y_star + 170, 100, 40, textFont, MyButton.TYPE_OK);

        myFrame = new JFrame("银行卡");
        myFrame.setBounds(ConstantsUtils.LOGIN_X + 50, ConstantsUtils.LOGIN_Y + 100, ConstantsUtils.LOGIN_WIDTH - 100,
                ConstantsUtils.LOGIN_HEIGH - 200);
        myFrame.add(cardBalanceInput);
        myFrame.add(cardNumberTitle);
        myFrame.add(okButton);
        myFrame.add(cardNumberInput);
        myFrame.add(cardBalanceTitle);
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
