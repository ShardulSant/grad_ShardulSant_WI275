package com.database;

import java.sql.*;

public class SQLDatabase {
    static Connection con;

    public static Connection getCon() {
        try {
            if (con == null)
                con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/test",
                    "postgres",
                    "postgres"
                );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
