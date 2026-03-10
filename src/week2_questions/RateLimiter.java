package week2_questions;

import java.util.*;

class TokenBucket{

    int tokens;
    int maxTokens;
    long lastRefill;
    int refillRate;

    TokenBucket(int maxTokens,int refillRate){

        this.maxTokens=maxTokens;
        this.refillRate=refillRate;
        this.tokens=maxTokens;
        this.lastRefill=System.currentTimeMillis();
    }

    synchronized boolean allow(){

        long now = System.currentTimeMillis();

        int refill = (int)((now-lastRefill)/1000)*refillRate;

        tokens=Math.min(maxTokens,tokens+refill);

        lastRefill=now;

        if(tokens>0){
            tokens--;
            return true;
        }

        return false;
    }
}

public class RateLimiter {

    HashMap<String,TokenBucket> clients = new HashMap<>();

    public boolean checkRateLimit(String clientId){

        clients.putIfAbsent(clientId,new TokenBucket(1000,1));

        return clients.get(clientId).allow();
    }
}