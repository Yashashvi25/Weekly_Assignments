import java.util.*;

public class PlagiarismDectector {
    static HashMap<String,Set<String>> map=new HashMap<>();

    static void addDoc(String id,String text){
        String[] words=text.split(" ");
        for(int i=0;i<words.length-2;i++){
            String gram=words[i]+" "+words[i+1]+" "+words[i+2];
            map.putIfAbsent(gram,new HashSet<>());
            map.get(gram).add(id);
        }
    }

    static void check(String text){
        String[] words=text.split(" ");
        int match=0;

        for(int i=0;i<words.length-2;i++){
            String gram=words[i]+" "+words[i+1]+" "+words[i+2];
            if(map.containsKey(gram)) match++;
        }

        System.out.println("Matches: "+match);
    }

    public static void main(String[] args){
        addDoc("doc1","this is a sample text for test");
        check("this is a sample text");
    }
}