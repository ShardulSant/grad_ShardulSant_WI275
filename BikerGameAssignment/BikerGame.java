import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.time.temporal.*;
import java.util.concurrent.atomic.*;
class BikerGame{
    public static void main(String args[]){
        ExecutorService es = Executors.newFixedThreadPool(10);
        CyclicBarrier cb = new CyclicBarrier(10);
        List<Biker> arr = new ArrayList<Biker>();
        arr.add(new Biker("A",cb));
        arr.add(new Biker("B",cb));
        arr.add(new Biker("C",cb));
        arr.add(new Biker("D",cb));
        arr.add(new Biker("E",cb));
        arr.add(new Biker("F",cb));
        arr.add(new Biker("G",cb));
        arr.add(new Biker("H",cb));
        arr.add(new Biker("I",cb));
        arr.add(new Biker("J",cb));
        try{
            es.invokeAll(arr);
        }catch(Exception e){
            System.out.println(e);
        }
        arr.stream().sorted((a,b)->a.currentRank-b.currentRank).forEach(b->b.display());
        es.shutdown();
    }
}

class Biker implements Callable<Long>{
    LocalTime startTime;
    LocalTime endTime;
    String name;
    CyclicBarrier cb;
    static AtomicInteger rank = new AtomicInteger(1);
    int currentRank;
    Biker(String n,CyclicBarrier c){
        name = n;
        cb = c;
    }
    public Long call(){
        try{
            cb.await();
            startTime = LocalTime.now();
        for(int i = 0;i<1000;i=i+100){
            try{
                System.out.println("Biker "+name+" has covered distance "+i+" mtrs");
                Thread.sleep((long)(Math.random()*1000));
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
            currentRank = rank.getAndIncrement();
            endTime = LocalTime.now();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return ChronoUnit.SECONDS.between(startTime,endTime);
    }
    public void display(){
        System.out.println("Biker name :"+name+" Rank :"+currentRank+" Time "+endTime);
    }
}