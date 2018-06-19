package com.fragment;

import com.activity.UserActivity;
import com.base.BaseFragment;
import com.db.SqlUser;
import com.ui.MyButton;
import com.ui.MyLabel;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;

public class InformationFragment extends BaseFragment {
    private JLabel avatarName;
    private JLabel email;
    private JScrollPane scrollPane;
    private JList list;
    private JButton addButton;
    private JButton deleteButton;
    private JButton changeButton;
    private JLabel line;
    private JLabel line2;
    private JLabel titleText;
    private JLabel titleText2;

    private JScrollPane moneyScrollPane ;
    private JList moneyList;


    @Override
    public void initView() {
        titleFont = new Font("仿宋",Font.PLAIN,20);
        this.setLayout(null);
        //背景图
        ImageIcon bg = new ImageIcon(UserActivity.class.getResource("images//user_bg_3.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH,
                        ConstantsUtils.LOGIN_HEIGH - 70,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH, ConstantsUtils.LOGIN_HEIGH - 70);


        //头像
        int size = 100;
        ImageIcon avatar = new ImageIcon(UserActivity.class.getResource("images//avatar.png"));//背景图案
        avatar.setImage(avatar.getImage().
                getScaledInstance(size,
                        size,
                        Image.SCALE_DEFAULT));
        JLabel avatarLabel = new JLabel(avatar);
        avatarLabel.setBounds(40, 20, size, size);


        //avatarName = new MyLabel(Main.user.getUserAvatarName(),100,40,100,40,titleFont);
        avatarName = new MyLabel("ScorpioMiku",180,30,200,40,titleFont);
        email = new MyLabel("1056992492@qq.com",180,70,200,40,titleFont);


        line = new MyLabel("---------------------------------------------",30,130,360,10,titleFont);
        line.setForeground(Color.lightGray);

        titleText = new MyLabel("常用个人信息：",30,140,200,30,textFont);
        titleText.setForeground(Color.GRAY);

        list = new JList();
        moneyList = new JList();
        loadData();
        scrollPane = new JScrollPane(list);
        scrollPane.setBounds(30,180,200,150);
        moneyScrollPane = new JScrollPane(moneyList);
        moneyScrollPane.setBounds(30,370,345,100);

        int x_start = 280 ;
        int y_start = 200 ;
        int mergin = 40 ;
        Font buttonFont = new Font("黑体",Font.PLAIN,15);
        changeButton = new MyButton("修改",x_start,y_start,80,25,buttonFont,0);
        addButton = new MyButton("新增",x_start,y_start+=mergin,80,25,buttonFont,1);
        deleteButton = new MyButton("删除",x_start,y_start+=mergin,80,25,buttonFont,2);

        line2 = new MyLabel("---------------------------------------------",30,350,360,10,titleFont);
        line2.setForeground(Color.lightGray);
        titleText2 = new MyLabel("我的钱包:",30,340,200,30,textFont);
        titleText2.setForeground(Color.GRAY);


        this.add(moneyScrollPane);
        this.add(titleText2);
        //this.add(line2);
        this.add(addButton);
        this.add(changeButton);
        this.add(deleteButton);
        this.add(scrollPane);
        this.add(titleText);
        this.add(line);
        this.add(email);
        this.add(avatarName);
        this.add(avatarLabel);
        this.add(bgLabel);
    }

    @Override
    public SqlUser initSqlUser() {
        return null;
    }

    private void loadData(){
        ListModel listModel = new DefaultComboBoxModel(new String[]{
                ConstantsUtils.TESTIDCARD.getName()+"  "+ConstantsUtils.TESTIDCARD.getIdCardNumber()  ,
                ConstantsUtils.TESTIDCARD.getName()+"  "+ConstantsUtils.TESTIDCARD.getIdCardNumber()  ,
                ConstantsUtils.TESTIDCARD.getName()+"  "+ConstantsUtils.TESTIDCARD.getIdCardNumber()  ,
                ConstantsUtils.TESTIDCARD.getName()+"  "+ConstantsUtils.TESTIDCARD.getIdCardNumber()  ,
                ConstantsUtils.TESTIDCARD.getName()+"  "+ConstantsUtils.TESTIDCARD.getIdCardNumber()  ,
                ConstantsUtils.TESTIDCARD.getName()+"  "+ConstantsUtils.TESTIDCARD.getIdCardNumber()  ,
                ConstantsUtils.TESTIDCARD.getName()+"  "+ConstantsUtils.TESTIDCARD.getIdCardNumber()  ,
                ConstantsUtils.TESTIDCARD.getName()+"  "+ConstantsUtils.TESTIDCARD.getIdCardNumber()  ,
                ConstantsUtils.TESTIDCARD.getName()+"  "+ConstantsUtils.TESTIDCARD.getIdCardNumber()  ,
                ConstantsUtils.TESTIDCARD.getName()+"  "+ConstantsUtils.TESTIDCARD.getIdCardNumber()  ,
                ConstantsUtils.TESTIDCARD.getName()+"  "+ConstantsUtils.TESTIDCARD.getIdCardNumber()  ,
        });
        list.setModel(listModel);

        ListModel moneyModel = new DefaultComboBoxModel(new String[]{
           "卡号："+ConstantsUtils.TESTCARD.getCardNumber()+"  余额："+ConstantsUtils.TESTCARD.getBalace(),
                "卡号："+ConstantsUtils.TESTCARD.getCardNumber()+"  余额："+ConstantsUtils.TESTCARD.getBalace()
        });
        moneyList.setModel(moneyModel);
    }
}
