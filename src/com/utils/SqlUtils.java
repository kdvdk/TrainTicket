package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlUtils {

    //最高权限
    private static SqlUtils sqlUtilsRoot = null;
    //用户权限
    private static SqlUtils sqlUtilsUser = null;
    //火车站管理员
    private static SqlUtils sqlUtilsTrainManager = null;

    private Connection connection = null;

    /**
     * maker
     * @return
     */
    public static SqlUtils newInstance() {
        if (sqlUtilsRoot == null) {
            sqlUtilsRoot = new SqlUtils();
        }
        return sqlUtilsRoot;
    }

    /**
     * 构造函数私有
     */
    private SqlUtils() {
        if (connection == null) {
            try {
                Class.forName(ConstantsUtils.DRIVER_NAME);
                this.connection = DriverManager
                        .getConnection(ConstantsUtils.DBURL, ConstantsUtils.NAME, ConstantsUtils.PWD);
                System.out.println("数据库链接成功");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("数据库链接失败");
            }
        }
    }
}
