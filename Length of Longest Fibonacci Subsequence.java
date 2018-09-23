/**
 * leetcode:873. Length of Longest Fibonacci Subsequence
 */

import java.util.Arrays;

public class Solution33 {
    public static void main(String[]args){
        int[] a={1,3,7,11,12,14,18};
        System.out.println(new Solution33().lenLongestFibSubseq(a));
    }
    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1 || A.length == 2) return A.length;
        int max=0;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                int tmp=calculateLen(A,A[i],A[j],j);
                max=tmp>max?tmp:max;
            }
        }
        return max;
    }

    public int calculateLen(int[] nums, int a1, int a2, int index2) {
        int count = 2;
        do {
            int next = Arrays.binarySearch(nums, index2, nums.length, (a1 + a2));
            if(next<0) return count;
            a1=a2;
            a2=nums[next];
            index2=next;
            count++;
        } while (true);
    }
}
