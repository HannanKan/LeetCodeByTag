public class Solution10 {
    public boolean canJump(int[] nums) {
        int endindex=0;
        for(int i=0;i<nums.length;i++){
            if(endindex<i) return false;
            endindex=(endindex<nums[i]+i)?nums[i]+i:endindex;
            if(endindex==nums.length-1) return true;
        }
        return true;
    }
}
