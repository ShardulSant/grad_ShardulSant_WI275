package com.main;

import java.io.*;
import com.user.*;
import com.database.OwnerDatabase;

public class LayoutMaintainence {

    static User getUser() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Login as admin/user:");
        String role = br.readLine();

        if (role.equalsIgnoreCase("admin")) {
            System.out.println("Password:");
            if (br.readLine().equals("abc"))
                return new Admin();
        } else {
            System.out.println("Owner ID:");
            return new SiteOwner(
                new OwnerDatabase(Integer.parseInt(br.readLine())));
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        User u = getUser();
        if (u != null) u.editDetails();
    }
}
