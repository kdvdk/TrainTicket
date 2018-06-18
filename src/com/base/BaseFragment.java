package com.base;

import com.db.SqlUser;

import javax.swing.*;

public abstract class BaseFragment extends JPanel {
    /**
     * 每个活动持有一个SQL对象
     */
    private SqlUser sqlUser = null;

    protected SqlUser getSqlUser() {
        return sqlUser;
    }

    public BaseFragment() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initView();
            }
        });
        this.sqlUser = initSqlUser();
    }

    public abstract void initView();

    public abstract SqlUser initSqlUser();
}
