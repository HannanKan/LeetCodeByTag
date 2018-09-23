import java.util.ArrayList;

public class Solution14 {
    public int[] plusOne(int[] digits) {
        int rem=1;
        for(int i=digits.length-1;i>=0;i--){
            int tmp=digits[i];
            digits[i]=(rem+tmp)%10;
            rem=(rem+tmp)/10;
        }
        if(rem==0) return digits;
        else{
            int[] res=new int[digits.length+1];
            res[0]=rem;
            for(int i=1;i<res.length;i++){
                res[i]=digits[i-1];
            }
            return res;
        }


    }
}
