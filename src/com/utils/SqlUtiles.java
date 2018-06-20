package com.utils;

import com.bean.Train;
import com.bean.TrainClass;
import com.bean.User;
import com.db.SqlUser;

import java.sql.*;

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
     * 查询列车
     * @param trainNumber
     * @return
     */
    public Train queryTrain(String trainNumber){
        String sql = "SELECT TrainNumber,TrainName,TrainCompartmentNumber,TrainCapacityOfCompartment,TrainSpeed FROM Train WHERE TrainNumber = ?";
        Train train = new Train();
        train.setTrainNumber(" ");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,trainNumber.trim());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                train = new Train(
                        resultSet.getString("TrainNumber"),
                        resultSet.getString("TrainName"),
                        resultSet.getInt("TrainCompartmentNumber"),
                        resultSet.getInt("TrainCapacityOfCompartment"),
                        resultSet.getFloat("TrainSpeed")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return train;
    }

    /**
     * 添加班次
     * @param trainClass
     */
    public boolean addClass(TrainClass trainClass){
        String sql = "INSERT INTO TABLE CLASSES VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,trainClass.getClassNumber());
            preparedStatement.setString(2,trainClass.getTrainNumber());
            preparedStatement.setString(3,trainClass.getDepaturePlace());
            preparedStatement.setString(4,trainClass.getGoalPlace());
            preparedStatement.setFloat(5,trainClass.getDinstance());
            preparedStatement.setDate(6,trainClass.getDepatureTime());
            preparedStatement.setInt(7,trainClass.getPassengerNumber());
            return executeUpdate(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 更新类sql语言执行者
     * @param sql
     * @return
     */
    private boolean executeUpdate(String sql){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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


    /**
     * 更新类sql语言执行者
     * @param preparedStatement
     * @return
     */
    private boolean executeUpdate(PreparedStatement preparedStatement){
        try {
            int result = preparedStatement.executeUpdate();
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
     * @param preparedStatement
     * @return
     */
    private ResultSet executeQuery(PreparedStatement preparedStatement){
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            //statement.close();
            return resultSet;
        } catch (SQLException e) {
            System.out.println("SqlUtiles :SQL query 执行失败 "+e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
