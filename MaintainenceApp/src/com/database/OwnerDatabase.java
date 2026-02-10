package com.database;

import java.io.*;
import java.sql.*;
import com.entity.Owner;

public class OwnerDatabase {

    public Owner o1;

    public OwnerDatabase(int id) throws Exception {
        Connection con = SQLDatabase.getCon();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM OwnerDetails WHERE id=?"
        );
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            o1 = new Owner(id);
            o1.name = rs.getString("Name");
            o1.paidAmount = rs.getInt("PaidAmount");
            o1.siteId = rs.getInt("SiteId");
            o1.status = rs.getString("Status");
        }
    }

    public void display() {
        System.out.println(
            o1.id + " " + o1.name + " " + o1.paidAmount + " " +
            o1.siteId + " " + o1.status
        );
    }

    public void payMaintainence() throws Exception {

        if (!o1.status.equals("APPROVED")) {
            System.out.println("Owner not approved yet");
            return;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter amount: ");
        int amount = Integer.parseInt(br.readLine());

        Connection con = SQLDatabase.getCon();
        PreparedStatement ps1 = con.prepareStatement(
            "SELECT Maintainence, COALESCE(Paid,0) FROM SiteDetails WHERE SiteId=?"
        );
        ps1.setInt(1, o1.siteId);
        ResultSet rs = ps1.executeQuery();
        rs.next();

        int maintainence = rs.getInt(1);
        int paid = rs.getInt(2);
        int pending = maintainence - paid;

        if (amount > pending) {
            System.out.println("Amount exceeds pending: " + pending);
            return;
        }




        PreparedStatement ps2 = con.prepareStatement(
            "UPDATE OwnerDetails SET PaidAmount = PaidAmount + ? WHERE id=?"
        );
        ps2.setInt(1, amount);
        ps2.setInt(2, o1.id);
        ps2.executeUpdate();

        PreparedStatement ps3 = con.prepareStatement(
            "UPDATE SiteDetails SET Paid = COALESCE(Paid,0) + ? WHERE SiteId=?"
        );
        ps3.setInt(1, amount);
        ps3.setInt(2, o1.siteId);
        ps3.executeUpdate();

        o1.paidAmount += amount;
        System.out.println("Payment successful");
        display();
    }
}
