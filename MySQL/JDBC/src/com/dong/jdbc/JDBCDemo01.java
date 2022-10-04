package com.dong.jdbc;

import java.sql.*;

/**
 * @author MeidongXia
 * @date 2022/3/1 17:59
 */
public class JDBCDemo01 {

    public static void main(String[] args) throws SQLException {
        // 注册驱动
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigudb","root","xmd19980811");

        // 执行SQL
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employees");


        ResultSetMetaData metaData = resultSet.getMetaData();
        int count = metaData.getColumnCount();


        // 处理结果集
        while(resultSet.next()) { // 获取每一行数据
            // 获取每一列数据
            for (int i = 0; i < count; i++) {
                System.out.print(resultSet.getObject(i+1)+"\t");
            }
            System.out.println();
        }

        // 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
