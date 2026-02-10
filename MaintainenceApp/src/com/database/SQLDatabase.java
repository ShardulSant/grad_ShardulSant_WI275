package com.database;

import java.sql.*;

public class SQLDatabase {

    static Connection con;

    public static Connection getCon() throws Exception {
        if (con == null) {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","postgres");
        }
        return con;
    }
}
