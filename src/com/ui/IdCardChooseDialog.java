package com.ui;

import com.Main;
import com.base.BaseActivity;
import com.db.SqlUser;

import javax.swing.*;

public class IdCardChooseDialog extends BaseActivity {
    private MyFrame myFrame;

    @Override
    public void initView() {

    }

    @Override
    public SqlUser initSqlUser() {
        return SqlUser.newInstance(Main.user.getType());
    }

    @Override
    public void addListener() {

    }
}
