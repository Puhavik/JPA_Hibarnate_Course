package com.puhavik;

import java.sql.*;

public class jdbc_insert_v3 {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;
        Student student = new Student("Isaac", "Sharp", 9.8);

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);

            PreparedStatement statement = connection.prepareStatement("INSERT INTO students (name, surname, avg_grade) VALUES (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setDouble(3, student.getAvgGrade());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Failed to add student to DB");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                student.setId(generatedKeys.getLong(1)); // еденица - это индекс колонки
            } else {
                throw new SQLException("Failed to create ID");
            }

            System.out.println(student);
            statement.close(); // always close statement
            generatedKeys.close();

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
