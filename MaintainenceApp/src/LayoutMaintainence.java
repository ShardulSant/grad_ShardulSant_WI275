import java.io.*;
import java.sql.*;

interface User{
    public void editDetails();
}
class Admin implements User{
    public void editDetails(){
        int ch =1;
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(ch != 7)
        {   System.out.println("Enter 1. Add, 2.Edit , 3.Delete 4.View 7.Exit");
            ch = Integer.parseInt(br.readLine());
            switch(ch){
                case 1: SiteDatabase.add(Site.createSite());
                        break;
                case 2: SiteDatabase.update();
                        break;
                case 3: SiteDatabase.delete();
                        break;
                case 4: SiteDatabase.display();
                        break;
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class SiteOwner implements User{

    OwnerDatabase o1 = null;
    public SiteOwner(OwnerDatabase o1){
        this.o1 = o1;
    }
    public void editDetails(){
        int ch =1;
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(ch != 7)
        {   System.out.println("Enter 1. View Site Details , 2.View Owner Details , 3.Pay Maintainence ,  7.Exit");
            ch = Integer.parseInt(br.readLine());
            switch(ch){
                case 1: SiteDatabase.display(o1.o1.siteId);
                        break;
                case 2: o1.display();
                        break;
                case 3: o1.editMaintainence();
                        break;
                case 4: SiteDatabase.update();
                        break;
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Site{
    String type;
    int size_x;
    int size_y;
    int maintainence;
    int paid;
    int id;
    static Site createSite(){
        Site s = new Site();
        try{
            int cost = 9;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter type :");
            s.type = br.readLine();
            if(s.type.equals("OpenSite")) cost = 6;
            System.out.println("Enter size (x) :");
            s.size_x = Integer.parseInt(br.readLine());
            System.out.println("Enter size (x) :");
            s.size_y = Integer.parseInt(br.readLine());
            s.maintainence = s.size_x*s.size_y*cost;
            s.paid = 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }
} 

class SQLDatabase{
    static Connection con = null;
    public static Connection getCon(){
        try{
            if(con == null) con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","postgres");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;

    }
}
class SiteDatabase {

    static Connection con = SQLDatabase.getCon();
    static void add(Site s){
        try{
        PreparedStatement s1 = con.prepareStatement("INSERT INTO SiteDetails(Type,Size_X,Size_y,Maintainence,Paid) VALUES(?,?,?,?,?)");
        s1.setString(1,s.type);
        s1.setInt(2,s.size_x);
        s1.setInt(3,s.size_y);
        s1.setInt(4,s.maintainence);
        s1.setInt(5,s.paid);
        s1.execute();
        System.out.println("Added the site");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void update(){
        try{
        PreparedStatement s1 = con.prepareStatement("Update SiteDetails set Type = ?,size_x = ? , size_y = ?,maintainence = ?,paid = ? where Siteid = ?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter id to Update :");
        int id = Integer.parseInt(br.readLine());
        Site s = Site.createSite();
        s1.setString(1,s.type);
        s1.setInt(2,s.size_x);
        s1.setInt(3,s.size_y);
        s1.setInt(4,s.maintainence);
        s1.setInt(5,s.paid);
        s1.setInt(6,id);
        s1.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void delete(){
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter id to delete :");
        int id = Integer.parseInt(br.readLine());
        PreparedStatement s1 = con.prepareStatement("Select * from SiteDetails where siteid = ?");
        s1.setInt(1,id);
        ResultSet rs = s1.executeQuery();
        if(rs.next()){
            System.out.println("Site Details : "+rs.getString(1)+" "+rs.getInt(2)+" "+ rs.getInt(3)+" "+rs.getInt(4)+ " "+rs.getInt(5)+" "+rs.getInt(6));
            System.out.println("Are you sure you want to delete (1/0) :");
            int ch = Integer.parseInt(br.readLine());
            if(ch == 1){
                Statement s2 = con.createStatement();
                s2.executeUpdate("Delete from SiteDetails where siteId = "+id);
            }
        }
        
        else{
            System.out.println("Site id not found");
        }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    static void display(){
        try{
        Statement s1 = con.createStatement();
        ResultSet rs = s1.executeQuery("Select * from SiteDetails");
        while(rs.next()){
            System.out.println("_________________________________");
            System.out.println("Type :"+rs.getString(1)+" Size_x:"+rs.getInt(2)+" Size_y: "+rs.getInt(3)+" Maintainence: "+rs.getInt(4)+" Paid: "+rs.getInt(5)+" SiteId :"+rs.getInt(6));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void display(int id){
        try{
        Statement s1 = con.createStatement();
        ResultSet rs = s1.executeQuery("Select * from SiteDetails where siteid = "+id);
        while(rs.next()){
            System.out.println("_________________________________");
            System.out.println("Type :"+rs.getString(1)+" Size_x:"+rs.getInt(2)+" Size_y: "+rs.getInt(3)+" Maintainence: "+rs.getInt(4)+" Paid: "+rs.getInt(5)+" SiteId :"+rs.getInt(6));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Owner{
    int id = 0;
    String name;
    int paidAmount;
    int siteId;

    private Owner(){};
    Owner(int id){
        try{
        this.id = id;
        Connection con = SQLDatabase.getCon();
        PreparedStatement s1 = con.prepareStatement("Select * from OwnerDetails where id = ?");
        s1.setInt(1,id);
        ResultSet rs = s1.executeQuery();
        if(rs.next()){
            name = rs.getString(1);
            paidAmount = rs.getInt(2);
            id = rs.getInt(3);
            siteId = rs.getInt(4);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
class OwnerDatabase{
    Owner o1 = null;
    OwnerDatabase(int id ){
        o1 = new Owner(id);
    }
    public void display(){
        System.out.println("Owner Details : "+" Name: "+o1.name+" Paid Amount : "+o1.paidAmount+" Id : "+o1.id+" SiteId : "+o1.siteId);
    };
    public void editMaintainence(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter amount to be paid :");
            int amount = Integer.parseInt(br.readLine());
            updateMaintainence(amount);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void updateMaintainence(int amount){
        try{
            Connection con = SQLDatabase.getCon();
            PreparedStatement s1 = con.prepareStatement("Update OwnerDetails set PaidAmount = PaidAmount + ? where id = ?;");
            s1.setInt(1,amount);
            s1.setInt(2,o1.id);
            s1.execute();
            o1.paidAmount = o1.paidAmount + amount;
            display();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

class LayoutMaintainence{
    static User getUser(){
        try{
        String role = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Login as User/Admin :");
        role = br.readLine().toLowerCase();
        if(role.equals("admin")){
            System.out.println("Enter password :");
            String password = br.readLine();
            if(password.equals("abc")) return new Admin();
            
        }
        else{
            System.out.println("Enter Owner Id :");
            int id = Integer.parseInt(br.readLine());
            return new SiteOwner(new OwnerDatabase(id));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String args[]) {
        try{
        String role = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ch = 0;
        User u1 = getUser();
        while(ch != 7){
            
            System.out.println("Enter Choice  : 1. Edit Site Details , 2. Pending 3. Collect Maintainence");
            ch = Integer.parseInt(br.readLine());
            switch(ch){
                case 1 : u1.editDetails();
                case 2 : 
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}