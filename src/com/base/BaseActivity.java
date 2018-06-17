package com.base;

import com.db.SqlUser;

public abstract class BaseActivity {

    /**
     * 每个活动持有一个SQL对象
     */
    private SqlUser sqlUser = null;

    /**
     * View初始化自动调用
     */
    public BaseActivity() {
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

    protected SqlUser getSqlUser(){
        return this.sqlUser;
    }
}
