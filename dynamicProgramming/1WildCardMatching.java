public class Solution{
    public boolean isMatch(String s, String p) {
		//either is "" or null
		
		
		//todo: neither is ""
		int row=s.length()+1;
		int col=p.length()+1;
		boolean[][] dp=new boolean[row][col];
		for(int i=0;i<row;i++)
			dp[i][0]=(i==0)?true:false;
		for(int j=1;j<col;j++){
			if(p.charAt(j-1)=='*') dp[0][j]=dp[0][j-1];
			else dp[0][j]=false;
		}
		
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				if(p.charAt(j-1)=='*'){ 
					if(j==1) dp[i][j]=true;
					else{//j>1{
						int tmp=0;
						while(tmp<=i&&!dp[tmp][j-1]) tmp++;
						if(tmp<=i) dp[i][j]=true;
						else dp[i][j]=false;
					}
				}
				else{
					dp[i][j]=(dp[i-1][j-1]&&(p.charAt(j-1)=='?'||p.charAt(j-1)==s.charAt(i-1)));
				}
			}
		}
		
		return dp[row-1][col-1];
		
			
        
    }
	public static void main(String[] args){
		String s= "";
		String p="";
		System.out.println(new Solution().isMatch(s,p));
	}
}