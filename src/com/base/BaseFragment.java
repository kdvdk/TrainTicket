package com.base;

import com.db.SqlUser;
import com.db.SqlHelper;

import javax.swing.*;
import java.awt.*;

public abstract class BaseFragment extends JPanel {
    protected Font titleFont;
    protected Font textFont;
    private JFrame dialogFrame;
    /**
     * 每个活动持有一个SQL对象
     */
    private SqlUser sqlUser = null;
    private SqlHelper sqlHelper = null;


    public BaseFragment() {
        dialogFrame = new JFrame();
        dialogFrame.setSize(400, 400);
        dialogFrame.setLocationRelativeTo(null);
        dialogFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.sqlUser = initSqlUser();
        this.sqlHelper = new SqlHelper(sqlUser);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initView();
                addListener();
            }
        });
        titleFont = new Font("黑体", Font.PLAIN, 18);
        textFont = new Font("黑体", Font.PLAIN, 16);
    }

    //初始化界面
    public abstract void initView();
    //初始化SQL对象
    public abstract SqlUser initSqlUser();
    //SQL对象getter
    public SqlHelper getSqlHelper() {
        return sqlHelper;
    }
    //加载数据
    public abstract void loadData();
    //消息窗口封装
    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(dialogFrame, message, "消息提示", JOptionPane.INFORMATION_MESSAGE);
    }
    //事件处理加载
    public abstract void addListener();
}
