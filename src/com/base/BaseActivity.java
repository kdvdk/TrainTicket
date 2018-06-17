package com.base;

import com.db.SqlUser;

public abstract class BaseActivity {


    public BaseActivity() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initView();
            }
        });
    }

    protected SqlUser sqlUser;

    public abstract void initView();

    public abstract void initSqlUser();
}
