package com.dialog;

import com.Main;
import com.base.BaseDialog;
import com.bean.IdCard;
import com.bean.Ticket;
import com.db.SqlUser;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.utils.ChangeUtiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleDetailDialog extends BaseDialog {

    private JList<String> mList;
    private List<Ticket> datas = new ArrayList<>();
    private JButton okButton;
    private JScrollPane scrollPane;

    private ListModel<String> listModel;

    private JLabel name;
    private JLabel id;
    private JLabel sex;
    private JLabel birthday;
    private JLabel title;

    private IdCard idCard;

    private int x_star = 30;
    private int y_star = 30;
    private int mergin = 30;


    public PeopleDetailDialog(IdCard idCard) {
        this.idCard = idCard;
    }

    @Override
    public void initView() {
        name = new MyLabel("名字：" + idCard.getName(), x_star, y_star, 300, 30, textFont);
        id = new MyLabel("身份证：" + idCard.getIdCardNumber(), x_star, y_star += mergin, 300, 30, textFont);
        sex = new MyLabel("性别：" + idCard.getSex(), x_star, y_star += mergin, 300, 30, textFont);
        birthday = new MyLabel("出身日期：" + idCard.getBirthday(), x_star, y_star += mergin, 300, 30, textFont);
        title = new MyLabel("购票记录", x_star, y_star += mergin, 300, 30, textFont);

        mList = new JList<>();
        loadData();
        scrollPane = new JScrollPane(mList);
        scrollPane.setBounds(x_star, y_star += mergin + 10, 240, 120);

        okButton = new MyButton("确认", x_star + 80, y_star += 130, 100, 40, textFont, MyButton.TYPE_OK);

        myFrame.add(name);
        myFrame.add(title);
        myFrame.add(scrollPane);
        myFrame.add(id);
        myFrame.add(sex);
        myFrame.add(birthday);
        myFrame.add(okButton);

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
                myFrame.dispose();
            }
        });
    }

    @Override
    public void loadData() {
        datas.clear();
        try {
            datas = getSqlHelper().queryTicketById(idCard);
            listModel = new DefaultComboBoxModel<>(ChangeUtiles.ticketsListToArray(datas, getSqlHelper()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mList.setModel(listModel);
    }
}
