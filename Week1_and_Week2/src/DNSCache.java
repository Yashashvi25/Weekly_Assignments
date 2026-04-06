import java.util.*;

class Entry{
    String ip;
    long expiry;
    Entry(String ip,long ttl){
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl;
    }
}

public class DNSCache {
    static HashMap<String,Entry> map=new HashMap<>();

    static String resolve(String domain){
        Entry e=map.get(domain);
        long now=System.currentTimeMillis();

        if(e!=null && now<e.expiry){
            return "HIT: "+e.ip;
        }

        String newIP="1.1.1."+new Random().nextInt(100);
        map.put(domain,new Entry(newIP,5000));
        return "MISS: "+newIP;
    }

    public static void main(String[] args){
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
    }
}