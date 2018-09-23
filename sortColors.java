public class Solution17 {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length==0) return;
        int s=-1,e=nums.length;
        int scan=0;
        for(;scan<e;){
            if(nums[scan]==0){
                s=s+1;
                nums[scan]=nums[s];
                nums[s]=0;
                if(scan==s) {
                    scan++;
                    continue;
                }
            }
            else if(nums[scan]==2){
                e-=1;
                nums[scan]=nums[e];
                nums[e]=2;
            }
            else{
                scan++;
            }
        }
    }
}
