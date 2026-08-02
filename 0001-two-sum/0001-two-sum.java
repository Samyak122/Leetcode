import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int exist = target - nums[i];

            if(map.containsKey(exist)){
                return new int[]{map.get(exist),i};
            }
            map.put(nums[i],i);

        }
        return new int[]{-1,-1};
    }
}