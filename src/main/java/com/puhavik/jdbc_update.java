package com.puhavik;

import java.sql.*;
import java.util.Scanner;

public class jdbc_update {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name");
            String enterName = scanner.nextLine();
            // Небезопасный вариант.
//            Statement statement = connection.createStatement();
//            String sqlQuery = "UPDATE students SET avg_grade = 7.5 WHERE name = '" + enterName + "'";
//
//            statement.executeUpdate(sqlQuery);
//
//            statement.close();

            PreparedStatement statement = connection.prepareStatement("UPDATE students SET avg_grade = 7.5 WHERE name = ?");
            statement.setString(1, enterName);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
