public class Solution21 {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int fi=0,li=1;
        int res=1;
        for(;li<nums.length;li++){
            if(nums[fi]==nums[li]){
                continue;
            }else{
                int tmp=nums[li];
                nums[++fi]=tmp;
                res++;
            }
        }
        return res;
    }
}
