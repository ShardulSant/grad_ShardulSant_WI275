package com.database;

import java.sql.*;
import java.io.*;
import com.entity.Site;

public class SiteDatabase {
    static Connection con = null;
    static{
        try{
            con = SQLDatabase.getCon();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void add(Site s) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO SiteDetails(Type, Size_X, Size_Y, Maintainence, Paid) VALUES (?,?,?,?,?)"
        );
        ps.setString(1, s.type);
        ps.setInt(2, s.size_x);
        ps.setInt(3, s.size_y);
        ps.setInt(4, s.maintainence);
        ps.setInt(5, s.paid);
        ps.execute();

        System.out.println("Site added");
    }

    // UPDATE SITE MAINTENANCE
    public static void update() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Site ID: ");
        int id = Integer.parseInt(br.readLine());

        System.out.print("Enter new maintenance amount: ");
        int m = Integer.parseInt(br.readLine());

        PreparedStatement ps = con.prepareStatement(
            "UPDATE SiteDetails SET Maintainence=? WHERE siteid=?"
        );
        ps.setInt(1, m);
        ps.setInt(2, id);
        ps.execute();

        System.out.println("Site updated");
    }

    // DELETE SITE
    public static void delete() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Site ID: ");
        int id = Integer.parseInt(br.readLine());

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM SiteDetails WHERE siteid=?"
        );
        ps.setInt(1, id);
        ps.execute();

        System.out.println("Site deleted");
    }

    // DISPLAY ALL SITES
    public static void display() throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM SiteDetails");

        System.out.println("SiteID  Type  SizeX  SizeY  Maintenance  Paid");

        while (rs.next()) {
            System.out.println(
                rs.getInt("siteid") + "   " +
                rs.getString("Type") + "   " +
                rs.getInt("Size_X") + "   " +
                rs.getInt("Size_Y") + "   " +
                rs.getInt("Maintainence") + "   " +
                rs.getInt("Paid")
            );
        }
    }

    // DISPLAY SINGLE SITE (for OWNER)
    public static void display(int id) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM SiteDetails WHERE siteid=?"
        );
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println(
                rs.getInt("siteid") + " " +
                rs.getString("Type") + " " +
                rs.getInt("Size_X") + " " +
                rs.getInt("Size_Y") + " " +
                rs.getInt("Maintainence") + " " +
                rs.getInt("Paid")
            );
        } else {
            System.out.println("Site not found");
        }
    }
}
