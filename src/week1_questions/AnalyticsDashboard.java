package week1_questions;

import java.util.*;

public class AnalyticsDashboard {

    HashMap<String,Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    HashMap<String,Integer> trafficSources = new HashMap<>();

    public void processEvent(String url,String userId,String source){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        uniqueVisitors.putIfAbsent(url,new HashSet<>());

        uniqueVisitors.get(url).add(userId);

        trafficSources.put(source,trafficSources.getOrDefault(source,0)+1);
    }
}