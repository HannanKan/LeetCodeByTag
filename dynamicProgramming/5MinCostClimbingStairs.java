/*
746. Min Cost Climbing Stairs
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
Once you pay the cost, you can either climb one or two steps. You need to find minimum
 cost to reach the top of the floor, and you can either start from the step with index 0, 
 or the step with index 1.
*/
//alg: the state transferring equation is same to fibbonacci array
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //corner case
		
		//general case
		// last2-->last1-->current
		// former-->latter-->current
		int[] dp=new int[cost.length];
		dp[0]=0;dp[1]=0;
		for(int i=2;i<cost.length;i++){
			int x=dp[i-1]+cost[i-1];
			int y=dp[i-2]+cost[i-2];
			dp[i]=(x<y)?x:y;
		}
		int result1=dp[cost.length-1]+cost[cost.length-1];
		int result2=dp[cost.length-2]+cost[cost.length-2];
		return (result1<result2)?result1:result2;
    }
	public static void main(String[]args){
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(new Solution().minCostClimbingStairs(cost));
	}
}