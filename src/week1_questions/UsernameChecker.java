package week1_questions;

import java.util.*;

public class UsernameChecker {

    private HashMap<String, Integer> usernames = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username){

        attempts.put(username, attempts.getOrDefault(username,0)+1);

        return !usernames.containsKey(username);
    }

    public void registerUser(String username, int userId){
        usernames.put(username,userId);
    }

    public List<String> suggestAlternatives(String username){

        List<String> list = new ArrayList<>();

        for(int i=1;i<=5;i++){
            list.add(username+i);
        }

        list.add(username.replace("_","."));

        return list;
    }
}