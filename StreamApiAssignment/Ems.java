import java.util.function.*;
import java.util.stream.*;
import java.util.*;
class Ems{
    public static void main(String args[]){
        List<Emp> list = new ArrayList<Emp>();
        list.add(new Emp("A",26,200000,"Male","Manager","IT"));
        list.add(new Emp("B",28,40000,"Female","Programmer","Research"));
        list.add(new Emp("C",29,30000,"Female","Programmer","HR"));
        list.add(new Emp("D",30,50000,"Male","Manager","IT"));
        list.add(new Emp("E",31,60000,"Male","Programmer","IT"));
        list.add(new Emp("F",32,70000,"Female","Manager","Research"));
        list.add(new Emp("G",33,20000,"Male","Clerk","IT"));
        list.add(new Emp("AB",26,202000,"Male","Manager","IT"));
        list.add(new Emp("BC",28,43200,"Female","Programmer","Research"));
        list.add(new Emp("CD",29,36000,"Female","Programmer","HR"));
        list.add(new Emp("DE",30,521000,"Male","Manager","IT"));
        list.add(new Emp("EF",31,60300,"Male","Programmer","IT"));
        list.add(new Emp("FG",32,72000,"Female","Manager","Research"));
        list.add(new Emp("GH",33,20400,"Male","Clerk","IT"));
        list.add(new Emp("ABC",26,120000,"Male","Manager","IT"));
        list.add(new Emp("BCD",28,43000,"Female","Programmer","Research"));
        list.add(new Emp("CDE",29,305000,"Female","Programmer","HR"));
        list.add(new Emp("DEF",30,507500,"Male","Manager","IT"));
        list.add(new Emp("EFG",31,64500,"Male","Programmer","IT"));
        list.add(new Emp("FGH",32,700210,"Female","Manager","Research"));
        list.add(new Emp("GHI",33,200120,"Male","Clerk","IT"));
        //1
        list.stream().sorted((a,b)->a.salary-b.salary).skip(list.size()-1).forEach(e->e.display());
        //2
        Map<Boolean,Long> hashmap = list.stream().collect(Collectors.partitioningBy(e->e.gender.equals("Male"),Collectors.counting()));
        System.out.println("Male : "+hashmap.get(true)+" Female:"+hashmap.get(false));
        //3
        Map<String,Integer> hashmap3 = list.stream().collect(Collectors.groupingBy(e->e.department,Collectors.summingInt(e->e.salary)));
        hashmap3.entrySet().stream().forEach(e->{
                System.out.println("Department : "+e.getKey()+" Cost :"+e.getValue());
            });
        //4
        list.stream().sorted((a,b)->b.age-a.age).limit(5).forEach(e->e.display());
        //5
        list.stream().filter(e->e.designation.equals("Manager")).map(e->e.name).forEach(System.out::println);
        //6
        list.stream().filter(e->!e.designation.equals("Manager"))
        .map(e->{
            e.salary = (int)(e.salary*1.2);
            return e;
            }
        )
        .forEach(e->e.display());
        System.out.println(list.stream().count());
    }
}

class Emp{
    String name;
    int age;
    int salary;
    String gender;
    String designation;
    String department;
    Emp(String name,int age,int salary,String gender,String designation,String department){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.designation = designation;
        this.department = department;
    }

    public void display(){
        System.out.println("Name :"+name+ " Age :"+age+" Salary :"+salary+" Gender :"+gender+" Designation :"+designation+" Department :"+department);
    }
    
}