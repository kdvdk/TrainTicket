package com.base;

import com.db.SqlUser;
import com.db.SqlHelper;

import javax.swing.*;
import java.awt.*;

public abstract class BaseActivity {
    protected Font titleFont;
    protected Font textFont;
    private JFrame dialogFrame;
    /**
     * 每个活动持有一个SQL对象
     */
    private SqlUser sqlUser = null;

    private SqlHelper sqlHelper;

    /**
     * View初始化自动调用
     */
    public BaseActivity() {
        dialogFrame = new JFrame();
        dialogFrame.setSize(400, 400);
        dialogFrame.setLocationRelativeTo(null);
        dialogFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.sqlUser = initSqlUser();
        sqlHelper = new SqlHelper(sqlUser);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initView();
                addListener();
            }
        });
        //全局字体初始化
        titleFont = new Font("黑体", Font.PLAIN, 18);
        textFont = new Font("黑体", Font.PLAIN, 16);

    }

    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(dialogFrame, message, "消息提示", JOptionPane.INFORMATION_MESSAGE);
    }

    //初始化SQL对象
    public SqlHelper getSqlHelper() {
        return sqlHelper;
    }

    public abstract SqlUser initSqlUser();

    //初始化界面
    public abstract void initView();

    //SQL对象的getter
    protected SqlUser getSqlUser() {
        return this.sqlUser;
    }

    //事件设置
    public abstract void addListener();

    public abstract void loadData();
}
