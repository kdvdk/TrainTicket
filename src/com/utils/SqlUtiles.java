package com.utils;

import com.bean.Train;
import com.bean.TrainClass;
import com.bean.User;
import com.db.SqlUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                        resultSet.getString("UserPhoneNumber").trim(),
                        resultSet.getString("UserPassWord").trim(),
                        resultSet.getString("UserEmail").trim(),
                        resultSet.getString("UserAppName").trim(),
                        resultSet.getString("UserIdCardNumber").trim(),
                        resultSet.getString("UserUsualDepature").trim(),
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
                        resultSet.getString("TrainNumber").trim(),
                        resultSet.getString("TrainName").trim(),
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
//        String sql = "INSERT INTO Classes VALUES(?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, formatString1(trainClass.getClassNumber()));
//            preparedStatement.setString(2, formatString1(trainClass.getTrainNumber()));
//            preparedStatement.setString(3, formatString1(trainClass.getDepaturePlace()));
//            preparedStatement.setString(4, formatString1(trainClass.getGoalPlace()));
//            preparedStatement.setFloat(5,trainClass.getDinstance());
//            preparedStatement.setDate(6,formatString1(trainClass.getDepatureTime().toString()));
//            preparedStatement.setInt(7,trainClass.getPassengerNumber());
//            System.out.println(preparedStatement);
//            return executeUpdate(preparedStatement);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
        String sql = "INSERT INTO Classes VALUES(cn,ctn,cdp,cgp,cdis,cde,cpn)";
        sql = sql.replace("cn",formatString1(trainClass.getClassNumber()));
        sql = sql.replace("ctn",formatString1(trainClass.getTrainNumber()));
        sql = sql.replace("cdp",formatString1(trainClass.getDepaturePlace()));
        sql = sql.replace("cgp",formatString1(trainClass.getGoalPlace()));
        sql = sql.replace("cdis",trainClass.getDinstance()+"");
        sql = sql.replace("cde",formatString1(trainClass.getDepatureTime().toString()));
        sql = sql.replace("cpn",trainClass.getPassengerNumber()+"");
        System.out.println(sql);
        return executeUpdate(sql);

    }

    /**
     * 查询班次
     * @return
     */
    public List<TrainClass> queryClasses() throws SQLException {
        ResultSet resultSet;
        List<TrainClass> mList = new ArrayList<>();
        String sql = "SELECT ClassesNumber,ClassesTrainNumber,ClassesDepaturePlace,ClassesGoalPlace,ClassesDistance,ClassesDepatureTime,ClassesPassengerNumber FROM Classes";
        resultSet = executeQuery(sql);
        while (resultSet.next()){
            mList.add(new TrainClass(
                        resultSet.getString("ClassesNumber").trim(),
                        resultSet.getString("ClassesTrainNumber").trim()   ,
                        resultSet.getString("ClassesDepaturePlace").trim(),
                        resultSet.getString("ClassesGoalPlace").trim(),
                        resultSet.getFloat("ClassesDistance"),
                        resultSet.getDate("ClassesDepatureTime") ,
                        resultSet.getInt("ClassesPassengerNumber")
                    ));
        }
        return mList;
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

    private String formatString20(String input){
        StringBuffer re = new StringBuffer("'"+input);
        int length = input.length();
        int add_number = 20 - length;
        for(int i = 0; i < add_number -1 ; i++) {
             re =  re.append(" ");
        }
        re.append("'");
        System.out.println(re);
        return new String(re);
    }

    private String formatString1(String input){
        System.out.println("'"+input+"'");
        return  "'"+input+"'";
    }

}
