package com.database;

import java.io.*;
import java.sql.*;
import com.entity.Owner;

public class OwnerDatabase {
    public Owner o1;

    public OwnerDatabase(int id) {
        o1 = new Owner(id);
    }

    public void display() {
        System.out.println(
            o1.name + " " + o1.paidAmount + " " + o1.siteId);
    }

    public void editMaintainence() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter amount:");
        int amount = Integer.parseInt(br.readLine());

        Connection con = SQLDatabase.getCon();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE OwnerDetails SET PaidAmount = PaidAmount + ? WHERE id=?");
        ps.setInt(1, amount);
        ps.setInt(2, o1.id);
        ps.execute();

        o1.paidAmount += amount;
        display();
    }
}
