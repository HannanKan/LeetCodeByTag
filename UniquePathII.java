class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		//corner case should be careful
        int row=obstacleGrid.length;
		int col=obstacleGrid[0].length;
		int[][] dp=new int[row][col];
		
		//following process first row and column
		boolean flag=true;//means can arrive at the destination
		for(int i=0;i<col;i++){
			if(flag&&obstacleGrid[0][i]!=1) dp[0][i]=1;
			else {
				flag=false;
				dp[0][i]=0;
			}
		}
		flag=true;
		for(int i=0;i<row;i++){
			if(flag&&obstacleGrid[i][0]!=1)
				dp[i][0]=1;
			else{
				flag=false;
				dp[i][0]=0;
			}
		}
		
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				if(obstacleGrid[i][j]!=1) dp[i][j]=dp[i-1][j]+dp[i][j-1];
				else dp[i][j]=0;
			}
		}
		return dp[row-1][col-1];
		
		
    }
	public static void main(String[]args){
		int[][] a={{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(new Solution().uniquePathsWithObstacles(a));
	}
}