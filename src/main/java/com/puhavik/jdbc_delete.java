package com.puhavik;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc_delete {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);

            PreparedStatement statement = connection.prepareStatement("Delete from students where surname=?");
            statement.setString(1, "Tregulov");
            int deletedRows = statement.executeUpdate();
            System.out.println("Deleted rows = " + deletedRows);
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
