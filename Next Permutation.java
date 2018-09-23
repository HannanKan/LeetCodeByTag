import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * leetcode: 31. Next Permutation
 * */
public class Solution28 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;

        int pos = invasionPos(nums);
        if (pos == -1) {
            Arrays.sort(nums);
            return;
        }else{
            int swapPos=bigALittle(nums,pos);
            int tmp=nums[swapPos];
            nums[swapPos]=nums[pos];
            nums[pos]=tmp;
            Arrays.sort(nums,pos+1,nums.length);
            reverse(nums,pos+1);
            return;
        }
    }
    public void reverse(int[] nums,int start){
        if(start>=nums.length)return;
        int counterpat=nums.length-1;
        while(counterpat>start){
            int tmp=nums[counterpat];
            nums[counterpat]=nums[start];
            nums[start]=tmp;
            start++;
            counterpat--;
        }
    }
    public int bigALittle(int[] nums,int start){
        int s=start+1;
        for(;s<nums.length;s++){
            if(nums[s]<=nums[start]) return s-1;   // <= rather than <
        }
        return s-1;
    }

    //@return -1 means it is the biggest
    // otherwise returnee means the first position whose value < next position
    public int invasionPos(int[] nums) {
        int slowPoint = nums.length - 1;
        int fastPoint = slowPoint - 1;
        while (fastPoint >= 0) {
            if (nums[fastPoint] < nums[slowPoint]) return fastPoint;
            fastPoint--;
            slowPoint--;
        }
        return -1;
    }
}
