package com.utils;

import com.Main;
import com.bean.*;
import com.db.SqlUser;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlUtiles {

    private Connection connection = null;


    String INSERT_SQL = "INSERT INTO table VALUES(x);";
    String QUERY_SQL = "SELECT sth FROM table ";

    /**
     * |构造函数，实例化Connection
     *
     * @param sqlUser
     */
    public SqlUtiles(SqlUser sqlUser) {
        this.connection = sqlUser.getConnection();
    }

    /**
     * 添加用户
     *
     * @param user
     */
    public Boolean InsertUser(User user) {
        String sql = INSERT_SQL.replace("table", "UserTrain");
        String values = "'" + user.getUserPhone() + "','" + user.getUserPassWord() + "','" + user.getUserEmail() + "','" + user.getUserAvatarName()
                + "'," + user.getType();
        sql = sql.replace("x", values);
        System.out.println(sql);
        if (executeUpdate(sql)) {
            System.out.println("插入用户成功");
            return true;
        } else {
            System.out.println("插入用户失败");
            return false;
        }
    }


    /**
     * 查询用户
     *
     * @param limit
     * @return
     */
    public User queryUser(String limit) {
        User user = new User();
        user.setUserPhone("-");
        String sql = QUERY_SQL.replace("sth",
                "UserPhoneNumber,UserPassWord,UserEmail,UserAppName,UserType");
        sql = sql.replace("table", "UserTrain");
        sql = sql + limit;
        System.out.println(sql);
        ResultSet resultSet = executeQuery(sql);
        try {
            while (resultSet.next()) {
                user = new User(
                        resultSet.getString("UserPhoneNumber").trim(),
                        resultSet.getString("UserPassWord").trim(),
                        resultSet.getString("UserEmail").trim(),
                        resultSet.getString("UserAppName").trim(),
                        resultSet.getInt("UserType")
                );
            }
            System.out.println("查询成功");
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询失败：" + e.toString());
            return user;
        }
    }

    /**
     * 查询列车
     *
     * @param trainNumber
     * @return
     */
    public Train queryTrain(String trainNumber) {
        String sql = "SELECT TrainNumber,TrainName,TrainCompartmentNumber,TrainCapacityOfCompartment,TrainSpeed,firstPrice,secondPrice,bedPrice FROM Train WHERE TrainNumber = ?";
        Train train = new Train();
        train.setTrainNumber(" ");
        try {
            sql = sql.replace("?", formatString(trainNumber));
            ResultSet resultSet = executeQuery(sql);
            System.out.println(sql);
            while (resultSet.next()) {
                train = new Train(
                        resultSet.getString("TrainNumber").trim(),
                        resultSet.getString("TrainName").trim(),
                        resultSet.getInt("TrainCompartmentNumber"),
                        resultSet.getInt("TrainCapacityOfCompartment"),
                        resultSet.getFloat("TrainSpeed"),
                        resultSet.getFloat("firstPrice"),
                        resultSet.getFloat("secondPrice"),
                        resultSet.getFloat("bedPrice")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return train;
    }

    /**
     * 添加班次
     *
     * @param trainClass
     */
    public boolean addClass(TrainClass trainClass) {

        String sql = "INSERT INTO Classes VALUES(cn,ctn,cdp,cgp,cdis,cde,cpn,time)";
        sql = sql.replace("cn", formatString(trainClass.getClassNumber()));
        sql = sql.replace("ctn", formatString(trainClass.getTrainNumber()));
        sql = sql.replace("cdp", formatString(trainClass.getDepaturePlace()));
        sql = sql.replace("cgp", formatString(trainClass.getGoalPlace()));
        sql = sql.replace("cdis", trainClass.getDinstance() + "");
        sql = sql.replace("cde", formatString(trainClass.getDepatureDay().toString()));
        sql = sql.replace("cpn", trainClass.getPassengerNumber() + "");
        sql = sql.replace("time", formatString(trainClass.getTime() + ""));
        System.out.println(sql);
        return executeUpdate(sql);

    }

    /**
     * 管理员删除班次
     *
     * @param trainClass
     * @return
     */
    public Boolean deleteClasses(TrainClass trainClass) {
        String sql1 = "DELETE FROM Ticket WHERE TicketClassesNumber = " + formatString(trainClass.getClassNumber());

        String sql2 = "DELETE FROM Classes WHERE ClassesNumber = '" + trainClass.getClassNumber() + "'";
        executeUpdate(sql1);
        return executeUpdate(sql2);
    }

    /**
     * 查询班次
     *
     * @return
     */
    public List<TrainClass> queryClasses() throws SQLException {
        ResultSet resultSet;
        List<TrainClass> mList = new ArrayList<>();
        String sql = "SELECT ClassesNumber,ClassesTrainNumber,ClassesDepaturePlace,ClassesGoalPlace,ClassesDistance," +
                "ClassesDepatureTime,ClassesPassengerNumber,DepatureTime FROM Classes ORDER BY ClassesDepatureTime DESC";
        resultSet = executeQuery(sql);
        while (resultSet.next()) {
            mList.add(new TrainClass(
                    resultSet.getString("ClassesNumber").trim(),
                    resultSet.getString("ClassesTrainNumber").trim(),
                    resultSet.getString("ClassesDepaturePlace").trim(),
                    resultSet.getString("ClassesGoalPlace").trim(),
                    resultSet.getFloat("ClassesDistance"),
                    resultSet.getDate("ClassesDepatureTime"),
                    resultSet.getInt("ClassesPassengerNumber"),
                    resultSet.getString("DepatureTime").trim()
            ));

        }
        return mList;
    }

    /**
     * 按班次号查询
     *
     * @param classesNumber
     * @return
     * @throws SQLException
     */
    public TrainClass queryClasses(String classesNumber) throws SQLException {
        String sql = "SELECT ClassesNumber,ClassesTrainNumber,ClassesDepaturePlace,ClassesGoalPlace,ClassesDistance,ClassesDepatureTime,ClassesPassengerNumber,DepatureTime FROM Classes WHERE ClassesNumber = '" + classesNumber + "'";
        ResultSet resultSet = executeQuery(sql);
        TrainClass re = new TrainClass();
        re.setClassNumber(" ");
        while (resultSet.next()) {
            re = new TrainClass(
                    resultSet.getString("ClassesNumber").trim(),
                    resultSet.getString("ClassesTrainNumber").trim(),
                    resultSet.getString("ClassesDepaturePlace").trim(),
                    resultSet.getString("ClassesGoalPlace").trim(),
                    resultSet.getFloat("ClassesDistance"),
                    resultSet.getDate("ClassesDepatureTime"),
                    resultSet.getInt("ClassesPassengerNumber"),
                    resultSet.getString("DepatureTime").trim()
            );
        }
        return re;
    }

    /**
     * 买票
     *
     * @param trainClass
     * @param idCard
     * @return
     */
    public boolean buyTicket(TrainClass trainClass, IdCard idCard, int nearWindow, int seatType, CreditCard creditCard) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(" ");
        Train train = queryTrain(trainClass.getTrainNumber());
        TrainClass trainClassQuery = queryClasses(trainClass.getClassNumber());
        int passengerNumber = trainClassQuery.getPassengerNumber();
        if (passengerNumber + 1 >= train.getCapacityOfCompartment() * train.getCompartmentNumber()) {
            System.out.println("该班次已满");
            return false;
        }
        int seatNumber = passengerNumber;
        if (nearWindow == 1) {
            ConstantsUtils.temp++;
            seatNumber = ConstantsUtils.temp * 4;
            seatNumber += 1;
            while (seatNumber % 4 != 0 && seatNumber % 4 != 1) {
                System.out.println(seatNumber);
                seatNumber++;
            }
        } else {
            seatNumber += 1;
            while (seatNumber % 4 == 0 || seatNumber % 4 == 1) {
                seatNumber++;
            }
        }
        //更新班次
        trainClass.setPassengerNumber(passengerNumber + 1);
        boolean update = updateClassesPassengerNumber(trainClass);
        Seat seat = null;

        switch (seatType) {
            case 0:
                //一等座
                seat = new Seat(
                        train.getTrainNumber(),
                        seatNumber + "",
                        train.getFirstPrice()
                );
                break;
            case 1:
                seatNumber += 120;
                seat = new Seat(
                        train.getTrainNumber(),
                        seatNumber + "",
                        train.getSecondPrice()
                );
                break;
            case 2:
                seatNumber += 240;
                seat = new Seat(
                        train.getTrainNumber(),
                        seatNumber + "",
                        train.getBedPrice()
                );
                break;
            default:
                break;
        }
        ticket.setClassNumber(trainClass.getClassNumber());
        ticket.setTicketNumber(trainClass.getClassNumber() + idCard.getIdCardNumber().substring(1, 5));
        ticket.setSeatNumber(seatNumber + "");
        ticket.setIdCardNumber(idCard.getIdCardNumber());
        ticket.setTicketTrainNumber(train.getTrainNumber());
        ticket.setTicketPrice(seat.getPrice());
        ticket.setCompartment(seatNumber / 40 + 1);
        String sql = "INSERT INTO Ticket VALUES(" + formatString(ticket.getTicketNumber()) + ","
                + formatString(ticket.getClassNumber()) + "," + formatString(ticket.getSeatNumber()) + ","
                + formatString(ticket.getIdCardNumber()) + "," + ticket.getTicketPrice() + "," + ticket.getCompartment()
                + ")";
        boolean insert = false;
        if (useCreditCard(creditCard, ticket.getTicketPrice())) {
            insert = executeUpdate(sql);
        } else {
            insert = false;
        }
        System.out.println(sql);
//        System.out.println(updateSQL);
        return insert && update;
    }


    /**
     * 查票
     *
     * @param user
     * @return
     */
    public List<Ticket> queryTickets(User user) {
        String sql = "SELECT * FROM Ticket WHERE TicketIdCardNumber = ";
        List<IdCard> idCards = null;
        List<Ticket> tickets = new ArrayList<>();
        try {
            idCards = queryIdCard(user);
            for (IdCard idCard : idCards) {
                sql = sql + formatString(idCard.getIdCardNumber());
                ResultSet resultSet = executeQuery(sql);
                System.out.println(sql);
                while (resultSet.next()) {
                    tickets.add(new Ticket(
                            resultSet.getString(1).trim(),
                            resultSet.getString(2).trim(),
                            resultSet.getString(3).trim(),
                            resultSet.getString(4).trim(),
                            resultSet.getFloat(5),
                            resultSet.getInt(6)
                    ));
                }
                sql = "SELECT * FROM Ticket WHERE TicketIdCardNumber = ";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    /**
     * 退票
     *
     * @param ticket
     * @return
     */
    public boolean returnTheTicket(Ticket ticket) {
        String sql = "DELETE FROM Ticket WHERE TicketTrainNumber = " + formatString(ticket.getTicketNumber());
        try {
            TrainClass trainClass = queryClasses(ticket.getClassNumber());
            trainClass.setPassengerNumber(trainClass.getPassengerNumber() - 1);
            updateClassesPassengerNumber(trainClass);
            useCreditCard(queryCreditCard(Main.user).get(0), -(ticket.getTicketPrice()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeUpdate(sql);
    }

    /**
     * 按起终点查询
     *
     * @param startplace
     * @param goalplace
     * @return
     * @throws SQLException
     */
    public List<TrainClass> queryClasses(String startplace, String goalplace, Date depatureDay) throws SQLException {
        String sql = "SELECT ClassesNumber,ClassesTrainNumber,ClassesDepaturePlace,ClassesGoalPlace,ClassesDistance," +
                "ClassesDepatureTime,ClassesPassengerNumber,DepatureTime FROM Classes WHERE ClassesDepaturePlace = '"
                + startplace + "' AND ClassesGoalPlace = '" + goalplace + "' AND ClassesDepatureTime = '" + depatureDay + "'";
        ResultSet resultSet;
        resultSet = executeQuery(sql);
        List<TrainClass> mList = new ArrayList<>();
        while (resultSet.next()) {
            mList.add(new TrainClass(
                    resultSet.getString("ClassesNumber").trim(),
                    resultSet.getString("ClassesTrainNumber").trim(),
                    resultSet.getString("ClassesDepaturePlace").trim(),
                    resultSet.getString("ClassesGoalPlace").trim(),
                    resultSet.getFloat("ClassesDistance"),
                    resultSet.getDate("ClassesDepatureTime"),
                    resultSet.getInt("ClassesPassengerNumber"),
                    resultSet.getString("DepatureTime").trim()
            ));
        }
        return mList;
    }


    /**
     * 更新班次信息
     *
     * @param trainClass
     * @return
     */
    public boolean updateClassesPassengerNumber(TrainClass trainClass) {
        String sql = "UPDATE Classes SET ClassesPassengerNumber = " + trainClass.getPassengerNumber()
                + " WHERE ClassesNumber = " + trainClass.getClassNumber();
        System.out.println(sql);
        return executeUpdate(sql);
    }

    /**
     * 添加、删除、使用、查银行卡
     *
     * @param creditCard
     * @return
     */
    public boolean insertCreditCard(CreditCard creditCard) {
        String sql = "INSERT INTO CreditCard VALUES( " + formatString(creditCard.getCardNumber())
                + "," + formatString(Main.user.getUserPhone()) + "," + creditCard.getBalace() + ")";
        return executeUpdate(sql);
    }

    public boolean deleteCreditCard(CreditCard creditCard) {
        String sql = "DELETE FROM CreditCard WHERE CreditNumber = " + creditCard.getCardNumber();
        return executeUpdate(sql);
    }

    public boolean useCreditCard(CreditCard creditCard, float balance) {
        float newBalance = creditCard.getBalace() - balance;
        if (newBalance > 0) {
            String sql = "UPDATE CreditCard set CreditBalace = " + newBalance + " WHERE CreditNumber = "
                    + creditCard.getCardNumber();
            return executeUpdate(sql);
        } else {
            return false;
        }
    }

    public List<CreditCard> queryCreditCard(User user) throws SQLException {
        String sql = "SELECT * FROM CreditCard WHERE CreditOwner = " + formatString(user.getUserPhone());
        ResultSet resultSet;
        resultSet = executeQuery(sql);
        List<CreditCard> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new CreditCard(
                    resultSet.getString(1).trim(),
                    resultSet.getString(2).trim(),
                    resultSet.getFloat(3)
            ));
        }
        return list;
    }


    /**
     * 添加身份证
     *
     * @param idCard
     * @return
     */
    public boolean insertIdCard(IdCard idCard, User user) {
        String sql = "INSERT INTO IdCard VALUES(" + formatString(idCard.getIdCardNumber()) + ","
                + formatString(idCard.getName()) + "," + formatString(idCard.getSex()) + ","
                + formatString(idCard.getBirthday().toString()) + "," + formatString(user.getUserPhone()) + ")";
        System.out.println(sql);
        return executeUpdate(sql);
    }

    /**
     * 查询身份证
     *
     * @param user
     * @return
     */
    public List<IdCard> queryIdCard(User user) throws SQLException {
        String sql = "SELECT IdCardNumber,IdCardName,IdCardSex,IdCardBirthday FROM IdCard WHERE OwnerUser = "
                + formatString(user.getUserPhone());
        ResultSet resultSet;
        resultSet = executeQuery(sql);
        List<IdCard> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new IdCard(
                    resultSet.getString("IdCardNumber").trim(),
                    resultSet.getString("IdCardName").trim(),
                    resultSet.getString("IdCardSex").trim(),
                    resultSet.getDate("IdCardBirthday")
            ));
        }
        return list;
    }


    public boolean deleteIdCard(IdCard idCard) {
        String sql = "DELETE FROM IdCard WHERE IdCardNumber = " + formatString(idCard.getIdCardNumber());
        return executeUpdate(sql);
    }


    /**
     * 查询车票记录
     *
     * @param idCard
     * @return
     */
    public List<Ticket> queryTicketById(IdCard idCard) throws SQLException {
        String sql = "SELECT * FROM Ticket WHERE TicketIdCardNumber = " + formatString(idCard.getIdCardNumber())
                + " ORDER BY TicketClassesNumber DESC";
        List<Ticket> mList = new ArrayList<>();
        ResultSet resultSet = executeQuery(sql);
        while (resultSet.next()) {
            mList.add(new Ticket(
                    resultSet.getString(1).trim(),
                    resultSet.getString(2).trim(),
                    resultSet.getString(3).trim(),
                    resultSet.getString(4).trim(),
                    resultSet.getFloat(5),
                    resultSet.getInt(6)
            ));
        }
        return mList;
    }


    /**
     * 查询身份证
     *
     * @param id
     * @return
     */
    public IdCard queryIdCard(String id) throws SQLException {
        String sql = "SELECT IdCardNumber,IdCardName,IdCardSex,IdCardBirthday FROM IdCard WHERE IdCardNumber = "
                + formatString(id);
        IdCard idCard = new IdCard();
        idCard.setIdCardNumber(" ");
        ResultSet resultSet = executeQuery(sql);
        while (resultSet.next()) {
            idCard.setIdCardNumber(resultSet.getString("IdCardNumber").trim());
            idCard.setName(resultSet.getString("IdCardName").trim());
            idCard.setBirthday(resultSet.getDate("IdCardBirthday"));
            idCard.setSex(resultSet.getString("IdCardSex").trim());
        }
        return idCard;
    }

    /**
     * 修改idcard信息
     *
     * @param idCard
     * @return
     */
    public boolean changeIdCard(IdCard idCard) {
        String sql = "UPDATE IdCard SET IdCardName=" + formatString(idCard.getName()) + "," + "IdCardSex="
                + formatString(idCard.getSex()) + ",IdCardBirthday=" + formatString(idCard.getBirthday().toString())
                + " WHERE IdCardNumber=" + formatString(idCard.getIdCardNumber());
        System.out.println(sql);
        return executeUpdate(sql);
    }

    /**
     * 更新类sql语言执行者
     *
     * @param sql
     * @return
     */
    private boolean executeUpdate(String sql) {
        System.out.println(sql);
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            if (result > 0) {
                System.out.println("SqlUtiles :SQL 执行成功");
//                statement.close();
                return true;
            } else {
                statement.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SqlUtiles :SQL update 执行失败 " + e.toString());
            return false;
        }


    }

    /**
     * 查询类sql语句执行者
     *
     * @param sql
     * @return
     */
    private ResultSet executeQuery(String sql) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //statement.close();
//            statement.close();
            return resultSet;
        } catch (SQLException e) {
            System.out.println("SqlUtiles :SQL query 执行失败 " + e.toString());
            e.printStackTrace();
            return null;
        }
    }


    private String formatString(String input) {
        System.out.println("'" + input + "'");
        return "'" + input + "'";
    }

}
