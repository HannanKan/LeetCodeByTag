public class Solution5 {
    //todo: n^2 algorithm
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int[] dp=new int[nums.length];
        for(int i=0;i<nums.length;i++)
            dp[i]=0x7fffffff;
        dp[0]=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]>=(i-j)){
                    if(dp[i]>dp[j]+1) dp[i]=dp[j]+1;
                }
            }
        }
        return dp[nums.length-1];
    }

    //todo: O(n) algorithm
    public int jumpN(int[] nums){
        //corner case
        if(nums.length==1) return 0;
        return 0;
        
    }
    public static void main(String[] args){
        int[] x={1,3,2};
        System.out.print(new Solution5().jumpN(x));
    }

}
