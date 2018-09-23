
/*
 *leetcode:  119. Pascal's Triangle II
 *
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution26 {
    public List<Integer> getRow(int rowIndex) {
        int rowLen=rowIndex+1;
        //todo: corner case
        if(rowIndex==0) return Arrays.asList(1);

        int[] former=new int[rowLen];
        int fLen=0;
        int[] latter=new int[rowLen];
        int lLen=0;

        //todo: initialize
        former[0]=1;
        fLen=1;
        // is row number
        for(int i=1;i<=rowIndex;i++){
            lLen=i+1;
            computeLatter(former,fLen,latter,lLen);
            //todo: swap arrays
            int[] tmp=former;
            former=latter;
            latter=tmp;
            fLen+=1;
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<rowLen;i++){
            res.add(former[i]);
        }
        return res;
    }
    public void computeLatter(int[] former,int fLen,int[] latter,int lLen){
        latter[0]=1;
        for(int i=1;i<fLen;i++)
            latter[i]=former[i]+former[i-1];
        latter[lLen-1]=1;
    }
}
