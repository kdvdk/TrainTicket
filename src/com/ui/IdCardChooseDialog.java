package com.ui;

import com.Main;
import com.activity.UserActivity;
import com.base.BaseActivity;
import com.bean.IdCard;
import com.db.SqlUser;
import com.utils.ChangeUtiles;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IdCardChooseDialog extends BaseActivity {
    private JFrame myFrame;
    private JButton okButton;
    //    private JButton cancelButton;
    private JLabel titleLabel;
    private JList<String> mList;
    private List<IdCard> dataList = new ArrayList<>();
    private JScrollPane scrollPane;


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
        int y_star = 30;
        int mergin = 60;
        titleLabel = new MyLabel("请选择乘客", x_star + 70, y_star, 400, 40, titleFont);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);


        mList = new JList<>();
        loadData();
        scrollPane = new JScrollPane(mList);
        scrollPane.setBounds(x_star, y_star + 50, 235, 200);

        okButton = new MyButton("确认", x_star + 70, y_star + 270, 100, 40, textFont, MyButton.TYPE_OK);

        myFrame = new JFrame();
        myFrame.setBounds(ConstantsUtils.LOGIN_X + 50, ConstantsUtils.LOGIN_Y + 100, ConstantsUtils.LOGIN_WIDTH - 100,
                ConstantsUtils.LOGIN_HEIGH - 200);
        myFrame.setTitle("选择乘客");
        myFrame.add(titleLabel);
        myFrame.add(scrollPane);
        myFrame.add(okButton);

        myFrame.add(bgLabel);
        myFrame.setLayout(null);
        myFrame.setVisible(true);
    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(Main.user.getType());
    }

    @Override
    public void addListener() {

    }

    public void loadData() {
        ListModel listModel = null;
        try {
            dataList = getSqlUtiles().queryIdCard(Main.user);
            listModel = new DefaultComboBoxModel<String>(ChangeUtiles.idCardListToArray(dataList));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mList.setModel(listModel);
    }
}
