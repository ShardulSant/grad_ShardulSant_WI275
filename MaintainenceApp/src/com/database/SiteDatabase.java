package com.database;

import java.sql.*;
import java.io.*;
import com.entity.Site;

public class SiteDatabase {

    static Connection con = SQLDatabase.getCon();

    public static void add(Site s) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO SiteDetails(Type,Size_X,Size_Y,Maintainence,Paid) VALUES(?,?,?,?,?)");
        ps.setString(1, s.type);
        ps.setInt(2, s.size_x);
        ps.setInt(3, s.size_y);
        ps.setInt(4, s.maintainence);
        ps.setInt(5, s.paid);
        ps.execute();
    }

    public static void update() throws Exception { /* same as your code */ }
    public static void delete() throws Exception { /* same as your code */ }
    public static void display() throws Exception { /* same as your code */ }

    public static void display(int id) throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT * FROM SiteDetails WHERE siteid=" + id);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
}
