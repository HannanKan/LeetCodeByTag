//62. Unique Paths
class Solution {
	/* brute force 
	
	public static int times =0;
    public int uniquePaths(int m, int n) {
		aux(1,1,m,n);
        int tmp=times;
        times=0;
		return tmp;

    }
	public void aux(int row,int col,int m,int n){
		if(row==m||col==n) {times+=1;return;}
		else{
			aux(row+1,col,m,n);
			aux(row,col+1,m,n);
		}
	}*/
	/*alg: dynamic programming---> something like fibbonacci*
	*/
	public int uniquePaths(int m, int n) {
		if(m==1||n==1) return 1;
        int[][] dp=new int[m][n];
		for(int i=0;i<m;i++){
			dp[i][0]=1;
		}
		for(int i=0;i<n;i++){
			dp[0][i]=1;
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
    }
	public static void main(String[]args){
		System.out.println(new Solution().uniquePaths(51,9));
	}
	
}