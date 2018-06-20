package com.base;

import com.db.SqlUser;
import com.utils.SqlUtiles;

import javax.swing.*;
import java.awt.*;

public abstract class BaseActivity {
    protected Font titleFont;
    protected Font textFont;
    /**
     * 每个活动持有一个SQL对象
     */
    private SqlUser sqlUser = null;

    private SqlUtiles sqlUtiles ;

    /**
     * View初始化自动调用
     */
    public BaseActivity() {
        this.sqlUser = initSqlUser();
        sqlUtiles = new SqlUtiles(sqlUser);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initView();
            }
        });
        titleFont = new Font("黑体", Font.PLAIN, 18);
        textFont = new Font("黑体", Font.PLAIN, 16);

    }

    public SqlUtiles getSqlUtiles() {
        return sqlUtiles;
    }

    public abstract void initView();

    public abstract SqlUser initSqlUser();

    protected SqlUser getSqlUser(){
        return this.sqlUser;
    }
}
