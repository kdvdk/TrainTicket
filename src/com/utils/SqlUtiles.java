package com.utils;

import com.bean.User;
import com.db.SqlUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtiles {

    private Connection connection = null;

    String INSERT_SQL = "INSERT INTO table VALUES(x);";
    String QUERY_SQL = "SELECT sth FROM table ";
    /**
     * |构造函数，实例化Connection
     * @param sqlUser
     */
    public SqlUtiles(SqlUser sqlUser) {
        this.connection = sqlUser.getConnection();
    }

    /**
     * 添加用户
     * @param user
     */
    public Boolean InsertUser(User user) {
        String sql = INSERT_SQL.replace("table","UserTrain");
        String values = "'"+user.getUserPhone()+"','"+user.getUserPassWord()+"','"+user.getUserEmail()+"','"+user.getUserAvatarName()
                +"',"+user.getUserIdCardNumber()+",'"+user.getUsualDepature()+"',"+user.getType();
        sql = sql.replace("x",values);
        System.out.println(sql);
        if(executeUpdate(sql)){
            System.out.println("插入用户成功");
            return true;
        }else{
            System.out.println("插入用户失败");
            return false;
        }
    }


    /**
     * 查询用户
     * @param limit
     * @return
     */
    public User queryUser(String limit){
        User user = new User() ;
        user.setUserPhone("-");
        String sql = QUERY_SQL.replace("sth",
                "UserPhoneNumber,UserPassWord,UserEmail,UserAppName,UserIdCardNumber,UserUsualDepature,UserType");
        sql = sql.replace("table","UserTrain");
        sql = sql+limit;
        System.out.println(sql);
        ResultSet resultSet = executeQuery(sql);
        try {
            while (resultSet.next()){
                user = new User(
                        resultSet.getString("UserPhoneNumber"),
                        resultSet.getString("UserPassWord"),
                        resultSet.getString("UserEmail"),
                        resultSet.getString("UserAppName"),
                        resultSet.getString("UserIdCardNumber"),
                        resultSet.getString("UserUsualDepature"),
                        resultSet.getInt("UserType")
                );
            }
            System.out.println("查询成功");
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询失败："+e.toString());
            return user;
        }
    }

    /**
     * 更新类sql语言执行者
     * @param sql
     * @return
     */
    private boolean executeUpdate(String sql){
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            if (result>0){
                System.out.println("SqlUtiles :SQL 执行成功");
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SqlUtiles :SQL update 执行失败 "+e.toString());
            return false;
        }

    }

    /**
     * 查询类sql语句执行者
     * @param sql
     * @return
     */
    private ResultSet executeQuery(String sql){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //statement.close();
            return resultSet;
        } catch (SQLException e) {
            System.out.println("SqlUtiles :SQL query 执行失败 "+e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
