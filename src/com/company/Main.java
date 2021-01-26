package com.company;

import javax.swing.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final String DB_url = "jdbc:mysql://localhost:3306/titanicmanifest";
        final String DB_USER = "AlexsonSilva";
        final String DB_PASSWORD = ".,Familia*25";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    DB_url, DB_USER, DB_PASSWORD);

            Statement stmt = con.createStatement();
            String sqlQuery = "select * from titanic";
            ResultSet rs = stmt.executeQuery(sqlQuery);

            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++){
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }
            System.out.println();

//            System.out.println("before while");

            while (rs.next()) {
//                System.out.println(rs.getString(4) + " " + rs.getString(5) + " " +
//                        rs.getString(6));
                System.out.println(rs.getInt(1) + "\t  " + rs.getInt(2) + " \t " + rs.getInt(3) + " \t " + rs.getString(4));
            }
//            System.out.println("after while");

//            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());

        } finally {
//            System.out.println("finally");

        }

    }
}
