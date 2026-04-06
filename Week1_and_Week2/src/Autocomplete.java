import java.util.*;

public class Autocomplete {
    static HashMap<String,Integer> map=new HashMap<>();

    static void add(String q){
        map.put(q,map.getOrDefault(q,0)+1);
    }

    static List<String> search(String prefix){
        List<String> res=new ArrayList<>();
        for(String s:map.keySet()){
            if(s.startsWith(prefix)) res.add(s);
        }
        return res;
    }

    public static void main(String[] args){
        add("java");
        add("javascript");
        System.out.println(search("jav"));
    }
}