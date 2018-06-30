package com.db;

import com.utils.ConstantsUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlUser {

    public static int USER_TYPE = 1;
    public static int MANAGER_TYPE = 2;


    private Connection connection = null;

    /**
     * 三种构造器
     *
     * @param type
     * @return
     */
    public static SqlUser newInstance(int type) {
        return new SqlUser(type);
    }

    /**
     * 构造函数私有
     */
    private SqlUser(int type) {
        if (type == 0) {
            if (connection == null) {
                try {
                    Class.forName(ConstantsUtils.DRIVER_NAME);
                    this.connection = DriverManager
                            .getConnection(ConstantsUtils.DBURL, ConstantsUtils.NAME_ROOT, ConstantsUtils.PWD);
                    System.out.println("数据库连接成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("数据库连接失败");
                }
            }
        } else if (type == 1) {
            if (connection == null) {
                try {
                    Class.forName(ConstantsUtils.DRIVER_NAME);
                    this.connection = DriverManager
                            .getConnection(ConstantsUtils.DBURL, ConstantsUtils.NAME_USER, ConstantsUtils.PWD);
                    System.out.println("数据库连接成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("数据库连接失败");
                }
            }
        } else {
            if (connection == null) {
                try {
                    Class.forName(ConstantsUtils.DRIVER_NAME);
                    this.connection = DriverManager
                            .getConnection(ConstantsUtils.DBURL, ConstantsUtils.NAME_MANAGER, ConstantsUtils.PWD);
                    System.out.println("数据库连接成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("数据库连接失败");
                }
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
