package week2_questions;

import java.util.*;

public class Autocomplete {

    HashMap<String,Integer> frequency = new HashMap<>();

    public void addQuery(String query){

        frequency.put(query,frequency.getOrDefault(query,0)+1);
    }

    public List<String> search(String prefix){

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a,b)->frequency.get(b)-frequency.get(a)
        );

        for(String q:frequency.keySet()){

            if(q.startsWith(prefix)){
                pq.add(q);
            }
        }

        List<String> result = new ArrayList<>();

        for(int i=0;i<10 && !pq.isEmpty();i++){
            result.add(pq.poll());
        }

        return result;
    }
}