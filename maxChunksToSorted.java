import java.util.Arrays;

public class Solution9 {
    public static void main(String[]args){
        int []arr={2,1,3,4,4};
        System.out.println(new Solution9().maxChunksToSorted(arr));
    }
    public int maxChunksToSorted(int[] arr) {
        int[] narr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            narr[i]=arr[i];
        }
        Arrays.sort(narr);
        int arr_pre=0;
        int narr_pre=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            arr_pre+=arr[i];
            narr_pre+=narr[i];
            if(arr_pre==narr_pre) count++;
        }
        return count==0?1:count;
    }
}
