/*
*leetcode: 122. Best Time to Buy and Sell Stock II
* */
public class Solution29 {
    class Solution {
        public int maxProfit(int[] prices) {
            int maxprofit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    maxprofit += prices[i] - prices[i - 1];
            }
            return maxprofit;
        }
    }
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0|| prices.length==1) return 0;

        int max=0;
        int[] state=new int[prices.length];
        state[0]=0;
        int j=1;
        for(;j<state.length;j++){
            if(prices[j]-prices[j-1]>0){
                state[j]=state[j-1]+1;
            }else if(prices[j]-prices[j-1]<0){
                state[j]=0;
            }else{
                if(state[j-1]==0) state[j]=0;
                else state[j]=state[j-1]+1;
            }
        }
        for(int i=1;i<state.length;i++){
            if(state[i]==0&&state[i-1]!=0) max+=(prices[i-1]-prices[i-1-state[i-1]]);
        }
        //last one
        int len=state.length;
        if(state[len-1]!=0){
            max+=(prices[len-1]-prices[len-1-state[len-1]]);
        }
        return max;
    }
}
