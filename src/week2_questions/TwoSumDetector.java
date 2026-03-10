package week2_questions;

import java.util.*;

public class TwoSumDetector {

    public List<int[]> findTwoSum(int[] nums,int target){

        HashMap<Integer,Integer> map = new HashMap<>();

        List<int[]> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            int complement = target-nums[i];

            if(map.containsKey(complement)){

                result.add(new int[]{map.get(complement),i});
            }

            map.put(nums[i],i);
        }

        return result;
    }
}