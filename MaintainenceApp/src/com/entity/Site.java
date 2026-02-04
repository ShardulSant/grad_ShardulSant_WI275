package com.entity;

import java.io.*;

public class Site {
    public String type;
    public int size_x, size_y, maintainence, paid;

    public static Site createSite() {
        Site s = new Site();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int cost = 9;

            System.out.println("Enter type:");
            s.type = br.readLine();
            if (s.type.equalsIgnoreCase("OpenSite")) cost = 6;

            System.out.println("Enter size x:");
            s.size_x = Integer.parseInt(br.readLine());

            System.out.println("Enter size y:");
            s.size_y = Integer.parseInt(br.readLine());

            s.maintainence = s.size_x * s.size_y * cost;
            s.paid = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
