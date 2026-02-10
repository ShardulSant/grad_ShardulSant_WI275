package com.entity;

import java.sql.*;
import com.database.SQLDatabase;

public class Owner {

    public int id, paidAmount, siteId;
    public String name, status;

    public Owner(int id) {
        try {
            this.id = id;

            Connection con = SQLDatabase.getCon();
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM OwnerDetails WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("Name");
                paidAmount = rs.getInt("PaidAmount");
                siteId = rs.getInt("SiteId");
                status = rs.getString("Status");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
