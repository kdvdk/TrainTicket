package com.ui;

import com.Main;
import com.activity.UserActivity;
import com.base.BaseActivity;
import com.base.BaseFragment;
import com.bean.IdCard;
import com.db.SqlUser;
import com.utils.ChangeUtiles;
import com.utils.ConstantsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class IdCardDialog extends BaseActivity {

    private JFrame myFrame;
    private JTextField idNumberText;
    private JTextField idName;
    private JTextField idSex;
    private JTextField idBirthday;
    private JButton okButton;
    private BaseFragment informationFragment;
    private int CODE;
    private IdCard idCard = null;

    public static int CHANGE = 1;
    public static int ADD = 0;

    public IdCardDialog(BaseFragment informationFragment, int CODE) {
        this.informationFragment = informationFragment;
        this.CODE = CODE;
    }

    public IdCardDialog(BaseFragment informationFragment, IdCard idCard, int CODE) {
        this.informationFragment = informationFragment;
        this.idCard = idCard;
        this.CODE = CODE;
    }

    @Override
    public void initView() {
        //背景图
        ImageIcon bg = new ImageIcon(UserActivity.class.getResource("images//idcard_bg.jpg"));//背景图案
        bg.setImage(bg.getImage().
                getScaledInstance(ConstantsUtils.LOGIN_WIDTH - 100,
                        ConstantsUtils.LOGIN_HEIGH - 200,
                        Image.SCALE_DEFAULT));
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, ConstantsUtils.LOGIN_WIDTH - 100, ConstantsUtils.LOGIN_HEIGH - 200);

        int x_star = 30;
        int y_star = 40;
        int mergin = 60;

        JLabel numberTitle = new MyLabel("身份证号", x_star, y_star, 80, 30, textFont);
        idNumberText = new MyTextField(x_star + 80, y_star, 150, 40, titleFont);
        if (CODE == CHANGE) {
            idNumberText.setText(idCard.getIdCardNumber());
            idNumberText.setEnabled(false);
        }

        JLabel nameTitle = new MyLabel("姓名", x_star, y_star += mergin, 80, 30, textFont);
        idName = new MyTextField(x_star + 80, y_star, 150, 40, titleFont);

        JLabel sexTitle = new MyLabel("性别", x_star, y_star += mergin, 80, 30, textFont);
        idSex = new MyTextField(x_star + 80, y_star, 150, 40, titleFont);

        JLabel birthdayTitle = new MyLabel("出生日期", x_star, y_star += mergin, 80, 30, textFont);
        idBirthday = new MyTextField(x_star + 80, y_star, 150, 40, titleFont);

        okButton = new MyButton("添加", x_star + 75, y_star += mergin + 10, 100, 40, textFont, 1);
        if (CODE == CHANGE) {
            okButton.setText("确认修改");
        }

        myFrame = new JFrame("添加身份证");
        myFrame.setBounds(ConstantsUtils.LOGIN_X + 50, ConstantsUtils.LOGIN_Y + 100, ConstantsUtils.LOGIN_WIDTH - 100,
                ConstantsUtils.LOGIN_HEIGH - 200);
        myFrame.setLayout(null);
        myFrame.add(idName);
        myFrame.add(okButton);
        myFrame.add(idBirthday);
        myFrame.add(idSex);
        myFrame.add(idNumberText);
        myFrame.add(sexTitle);
        myFrame.add(birthdayTitle);
        myFrame.add(nameTitle);
        myFrame.add(numberTitle);
        myFrame.add(bgLabel);
        myFrame.setVisible(true);
    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(Main.user.getType());
    }

    @Override
    public void addListener() {
        if (CODE == ADD) {
            okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String number = idNumberText.getText();
                    String name = idName.getText();
                    String sex = idSex.getText();
                    Date birthday = ChangeUtiles.createDate(idBirthday.getText());
                    if (getSqlUtiles().insertIdCard(new IdCard(number, name, sex, birthday), Main.user)) {
                        showMessageDialog("增添成功");
                        myFrame.dispose();
                    } else {
                        showMessageDialog("增添失败");
                    }
                    informationFragment.loadData();
                }
            });
        } else {

        }
    }

}
