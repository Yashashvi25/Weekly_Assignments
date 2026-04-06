import java.util.*;

class Bucket{
    int tokens;
    long last;
    Bucket(int t){tokens=t; last=System.currentTimeMillis();}
}

public class RateLimiter {
    static HashMap<String,Bucket> map=new HashMap<>();
    static int LIMIT=5;

    static boolean allow(String id){
        map.putIfAbsent(id,new Bucket(LIMIT));
        Bucket b=map.get(id);

        if(b.tokens>0){
            b.tokens--;
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        for(int i=0;i<7;i++)
            System.out.println(allow("user1"));
    }
}