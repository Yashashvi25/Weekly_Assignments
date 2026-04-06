import java.util.*;

public class TwoSum {
    static void find(int[] arr,int target){
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int x:arr){
            if(map.containsKey(target-x)){
                System.out.println(x+" "+(target-x));
            }
            map.put(x,1);
        }
    }

    public static void main(String[] args){
        int[] arr={300,200,500};
        find(arr,500);
    }
}