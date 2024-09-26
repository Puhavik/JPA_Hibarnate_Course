package com.puhavik;

import java.sql.*;

public class jdbc_insert_v2 {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;
        Student student = new Student("Leo", "Farrel", 8.4);

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);
            Statement statement = connection.createStatement();
            // INSERT INTO students (name, surname, avg_grade) VALUES ('Leo', 'Farrel',8.4)
//            String sqlQuery = "INSERT INTO students (name, surname, avg_grade) VALUES" + "('" + student.getName() +
//                    "','" +
//                    student.getSurname() +
//                    "'," +
//                    student.getAvgGrade() +
//                    ")";

            String sqlQuery = "INSERT INTO students (name, surname, avg_grade) VALUES ('Julia', 'Dinn',8.7)";
            statement.executeUpdate(sqlQuery);
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
