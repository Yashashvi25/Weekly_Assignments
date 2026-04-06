import java.util.*;

public class FlashSale {
    static HashMap<String,Integer> stock=new HashMap<>();
    static Queue<Integer> wait=new LinkedList<>();

    static synchronized void buy(String p,int user){
        if(stock.get(p)>0){
            stock.put(p,stock.get(p)-1);
            System.out.println("Success");
        } else {
            wait.add(user);
            System.out.println("Waitlist: "+wait.size());
        }
    }

    public static void main(String[] args){
        stock.put("IPHONE",2);
        buy("IPHONE",1);
        buy("IPHONE",2);
        buy("IPHONE",3);
    }
}