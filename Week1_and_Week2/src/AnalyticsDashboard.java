import java.util.*;

public class AnalyticsDashboard {
    static HashMap<String,Integer> page=new HashMap<>();
    static HashMap<String,Set<String>> users=new HashMap<>();
    static HashMap<String,Integer> source=new HashMap<>();

    static void process(String url,String user,String src){
        page.put(url,page.getOrDefault(url,0)+1);

        users.putIfAbsent(url,new HashSet<>());
        users.get(url).add(user);

        source.put(src,source.getOrDefault(src,0)+1);
    }

    public static void main(String[] args){
        process("news","u1","google");
        process("news","u2","facebook");

        System.out.println(page);
        System.out.println(source);
    }
}