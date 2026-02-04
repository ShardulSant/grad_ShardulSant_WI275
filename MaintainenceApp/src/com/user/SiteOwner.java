package com.user;

import java.io.*;
import com.database.*;
 
public class SiteOwner implements User {

    OwnerDatabase o1;

    public SiteOwner(OwnerDatabase o1) {
        this.o1 = o1;
    }

    public void editDetails() {
        int ch = 1;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (ch != 7) {
                System.out.println("1.View Site 2.View Owner 3.Pay 7.Exit");
                ch = Integer.parseInt(br.readLine());

                switch (ch) {
                    case 1 -> SiteDatabase.display(o1.o1.siteId);
                    case 2 -> o1.display();
                    case 3 -> o1.editMaintainence();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
