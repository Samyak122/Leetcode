class Solution {
    public int jump(int[] nums) {
        int totalJump = 0;
        int destination = nums.length - 1;
        int covarage = 0, lastJumpIdx = 0;

        if(nums.length == 1) return 0;

        for(int i =0; i<nums.length; i++){
            covarage = Math.max(covarage, i+nums[i]);

            if(i == lastJumpIdx){
                lastJumpIdx = covarage;
                totalJump++;

            
            if(covarage >= destination){
                return totalJump;
            }
            }
        }
           return totalJump;
    }
 
}