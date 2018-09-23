/*
* leetcode:152. Maximum Product Subarray
*
* */
public class Solution31 {

    public static void main(String[] args){
        int[] nums={-2,0,-1};
        System.out.println(new Solution31().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int result=subMax(nums,0,nums.length-1);
        return result;

    }
    public int subMax(int[] nums, int left, int right){
        if(left==right) return nums[left];
        int mid=(left+right) /2;
        int leftMax=subMax(nums,left,mid);
        int rightMax=subMax(nums,mid+1,right);
        int maxLeft=nums[mid],maxRight=nums[mid+1];
        int minLeft=nums[mid],minRight=nums[mid+1];
        int tmpLeft=nums[mid],tmpRight=nums[mid+1];
        //left
        for(int i=mid-1;i>=left;i--){
            tmpLeft*=nums[i];
            if(tmpLeft>maxLeft) maxLeft=tmpLeft;
            if(tmpLeft<minLeft) minLeft=tmpLeft;
        }
        //right
        for(int i=mid+2;i<=right;i++){
            tmpRight*=nums[i];
            if(tmpRight>maxRight) maxRight=tmpRight;
            if(tmpRight<minRight) minRight=tmpRight;
        }
        int max=minLeft*minRight;
        if(maxLeft*maxRight>max) max=maxLeft*maxRight;
        max=(max<leftMax)?leftMax:max;
        max=(max<rightMax)?rightMax:max;
        return max;
    }
}
