package com.base;

import com.db.SqlUser;
import com.utils.SqlUtiles;

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
    private SqlUtiles sqlUtiles = null;

    protected SqlUser getSqlUser() {
        return sqlUser;
    }

    public BaseFragment() {
        dialogFrame = new JFrame();
        dialogFrame.setSize(400, 400);
        dialogFrame.setLocationRelativeTo(null);
        dialogFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.sqlUser = initSqlUser();
        this.sqlUtiles = new SqlUtiles(sqlUser);
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

    public abstract void initView();

    public abstract SqlUser initSqlUser();

    public SqlUtiles getSqlUtiles() {
        return sqlUtiles;
    }

    public abstract void loadData();

    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(dialogFrame, message, "消息提示", JOptionPane.INFORMATION_MESSAGE);
    }
    public abstract void addListener();
}
