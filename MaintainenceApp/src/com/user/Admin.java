package com.user;

import java.io.*;
import java.sql.*;
import com.database.SiteDatabase;
import com.database.SQLDatabase;
import com.entity.Site;

public class Admin implements User {

    public void editDetails() {
        int ch = 1;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (ch != 7) {
                System.out.println(
                    "1.Add Site 2.Edit Site 3.Delete Site 4.View Sites 5.Approve Owner 7.Exit"
                );
                ch = Integer.parseInt(br.readLine());

                switch (ch) {
                    case 1 -> SiteDatabase.add(Site.createSite());
                    case 2 -> SiteDatabase.update();
                    case 3 -> SiteDatabase.delete();
                    case 4 -> SiteDatabase.display();
                    case 5 -> approveOwner(br);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void approveOwner(BufferedReader br) throws Exception {
        System.out.print("Enter Owner ID to approve: ");
        int id = Integer.parseInt(br.readLine());

        Connection con = SQLDatabase.getCon();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE OwnerDetails SET Status='APPROVED' WHERE id=?"
        );
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Owner approved successfully");
    }
}
