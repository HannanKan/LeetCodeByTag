/*
32. Longest Valid Parentheses
Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses substring.
*/
//algorithm: dynamic programming https://blog.csdn.net/accepthjp/article/details/52439449
//array dp; dp[i] means longest match end with str[i];
//every time str[i]=")", update the dp[i]
//if match...., else ....

class Solution {
    public int longestValidParentheses(String s) {
		s=')'+s;// it is very important to initialize
        char[] ch=s.toCharArray();
		int length=ch.length;
		int[] dp=new int[length];
		int max=0;
		for(int i=1;i<length;i++){
			if(ch[i]==')'&&ch[i-1-dp[i-1]]=='('){
				dp[i]+=(dp[i-1]+2); 
				dp[i]+=dp[i-dp[i]];//longest match before current match
			}
            max=(dp[i]>max)?dp[i]:max;
		}
		
		return max;
    }
	public static void main(String[] args){
		new Solution().longestValidParentheses(")()())");
	}
}