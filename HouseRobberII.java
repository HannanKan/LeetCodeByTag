/*Leetcode
213. House Robber II
*/
/*
algorithm: divide all the state into two parts: nums[0] contains, nums[0] exclude
in state which contains nums[0], the last element should be deleted, cause last one
and first one can not exist at the same time.
*/
import java.lang.Math;

class Solution {
    public int rob(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		if(nums.length==2) return Math.max(nums[0],nums[1]);
		int maxA0PreContain=nums[1];
		int maxA0PreExclude=0;
		int maxA1PreContain=nums[0];
		int maxA1PreExclude=0;
		int currC;
		int currE;
		for(int i=1;i<nums.length;i++){
			currC=nums[i]+maxA1PreExclude;
			currE=Math.max(maxA1PreContain,maxA1PreExclude);
			maxA1PreContain=currC;
			maxA1PreExclude=currE;
		}
		maxA1PreContain-=nums[0];//this variable contains last one element
		for(int i=2;i<nums.length;i++){
			currC=nums[i]+maxA0PreExclude;
			currE=Math.max(maxA0PreContain,maxA0PreExclude);
			maxA0PreContain=currC;
			maxA0PreExclude=currE;
		}
		return Math.max(Math.max(maxA0PreContain,maxA0PreExclude),Math.max(maxA1PreContain,maxA1PreExclude));
		
	}
	public static void main(String[] args){
		int[] a={2,3,2};
		System.out.println(new Solution().rob(a));
	}
}