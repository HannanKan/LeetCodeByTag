/*
You are a professional robber planning to rob houses 
along a street. Each house has a certain amount of money 
stashed, the only constraint stopping you from robbing
 each of them is that adjacent houses have security system
 connected and it will automatically contact the police if 
 two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the 
amount of money of each house, determine the maximum amount 
of money you can rob tonight without alerting the police.
*/
/*algorithm: two arrays to memorize the result, 1 contains current element, the one does not;
each time update the two arrays.*/
class Solution{
    public int rob(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		int[] contain=new int[nums.length];
		int[] noContain=new int[nums.length];
		contain[0]=nums[0];
		noContain[0]=0;
		for(int i=1;i<nums.length;i++){
			contain[i]=noContain[i-1]+nums[i];
			noContain[i]=(contain[i-1]>noContain[i-1])?contain[i-1]:noContain[i-1];
		}
		return (noContain[nums.length-1]>contain[nums.length-1])?noContain[nums.length-1]:contain[nums.length-1];
    }
public static void main(String[] args){
int[] a={1,2,3,1};
System.out.println(new Solution().rob(a));
}
}