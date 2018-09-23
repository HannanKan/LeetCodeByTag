/*
* leetcode: 120. Triangle
* */
import java.util.List;

public class Solution27 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null) return 0;
        int[][] dp=new int[triangle.size()][triangle.size()];
        int i;//i is the row number;[0,i] i=[0,triangle.size())
        dp[0][0]=triangle.get(0).get(0);
        for(int row=1;row<triangle.size();row++){
            for(int j=0;j<=row;j++){
                dp[row][j]=min3V(dp,j,row-1)+triangle.get(row).get(j);
            }
        }
        int min=((1<<31)-1);
        int row=triangle.size()-1;
        for(int j=0;j<=row;j++)
            min=Math.min(min,dp[row][j]);
        return min;

    }
    public int min3V(int[][] dp,int i,int row){
        int[] left=new int[1];
        int[] mid=new int[1];
        if(i-1<0) left[0]=((1<<31)-1);
        else left[0]=dp[row][i-1];
        if(i>row) mid[0]=((1<<31)-1);
        else mid[0]=dp[row][i];
        return Math.min(left[0],mid[0]);
    }
}
