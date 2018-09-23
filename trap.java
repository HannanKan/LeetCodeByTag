public class Solution4 {
    public int trap(int[] height) {
        int len=height.length;
        int[] left=new int[len];
        int[] right=new int[len];
        int max=0;
        //max value from left
        for(int i=0;i<len;i++){
            if(height[i]>max)
                max=height[i];
            left[i]=max;
        }
        max=0;
        for(int i=len-1;i>=0;i--){
            if(height[i]>max)
                max=height[i];
            right[i]=max;
        }
        int sum=0;
        for(int i=0;i<len;i++){
            int min=(left[i]<right[i]?left[i]:right[i]);
            sum+=(min-height[i]);
        }
        return sum;
    }
}
