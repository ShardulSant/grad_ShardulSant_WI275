package com.user;

import java.io.*;
import com.database.SiteDatabase;
import com.entity.Site;

public class Admin implements User {

    public void editDetails() {
        int ch = 1;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (ch != 7) {
                System.out.println("1.Add 2.Edit 3.Delete 4.View 7.Exit");
                ch = Integer.parseInt(br.readLine());

                switch (ch) {
                    case 1 -> SiteDatabase.add(Site.createSite());
                    case 2 -> SiteDatabase.update();
                    case 3 -> SiteDatabase.delete();
                    case 4 -> SiteDatabase.display();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
