package week1_questions;

import java.util.*;

public class PlagiarismDetector {

    HashMap<String, Set<String>> index = new HashMap<>();

    int N = 5;

    public void indexDocument(String docId,String text){

        String[] words = text.split(" ");

        for(int i=0;i<=words.length-N;i++){

            String gram="";

            for(int j=i;j<i+N;j++){
                gram+=words[j]+" ";
            }

            index.putIfAbsent(gram,new HashSet<>());

            index.get(gram).add(docId);
        }
    }
}