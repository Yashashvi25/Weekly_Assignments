package week1_questions;

import java.util.*;

public class InventoryManager {

    private HashMap<String,Integer> stock = new HashMap<>();
    private HashMap<String, Queue<Integer>> waitingList = new HashMap<>();

    public void addProduct(String productId,int quantity){

        stock.put(productId,quantity);
        waitingList.put(productId,new LinkedList<>());
    }

    public synchronized String purchaseItem(String productId,int userId){

        int count = stock.getOrDefault(productId,0);

        if(count>0){
            stock.put(productId,count-1);
            return "Success. Remaining: "+(count-1);
        }

        waitingList.get(productId).add(userId);

        return "Added to waiting list position "+waitingList.get(productId).size();
    }

    public int checkStock(String productId){
        return stock.getOrDefault(productId,0);
    }
}