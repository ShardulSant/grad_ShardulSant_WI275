package com.entity;

import java.sql.*;
import com.database.SQLDatabase;

public class Owner {
    public int id, paidAmount, siteId;
    public String name;

    public Owner(int id) {
        try {
            this.id = id;
            Connection con = SQLDatabase.getCon();
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM OwnerDetails WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString(1);
                paidAmount = rs.getInt(2);
                siteId = rs.getInt(4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
