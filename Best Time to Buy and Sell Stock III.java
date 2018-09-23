/*
 *leetcode: 123. Best Time to Buy and Sell Stock III
 * */
public class Solution30 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;

        int maxL = 0;
        int maxR = 0;
        int max1=0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if(prices[j]-prices[i]>max1){
                    max1=prices[j]-prices[i];
                    maxL=i;
                    maxR=j;
                }
            }
        }
        return 0;
    }
}
