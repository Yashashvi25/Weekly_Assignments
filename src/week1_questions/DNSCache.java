package week1_questions;

import java.util.*;

class DNSEntry{

    String ip;
    long expiry;

    DNSEntry(String ip,long ttl){
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl*1000;
    }

    boolean expired(){
        return System.currentTimeMillis()>expiry;
    }
}

public class DNSCache {

    private HashMap<String,DNSEntry> cache = new HashMap<>();

    public String resolve(String domain){

        if(cache.containsKey(domain)){

            DNSEntry entry = cache.get(domain);

            if(!entry.expired()){
                return entry.ip;
            }
        }

        String ip = queryDNS(domain);

        cache.put(domain,new DNSEntry(ip,300));

        return ip;
    }

    private String queryDNS(String domain){

        return "192.168.1."+new Random().nextInt(255);
    }
}