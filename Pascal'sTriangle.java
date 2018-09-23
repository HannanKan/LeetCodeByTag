/*
Leetcode:118. Pascal's Triangle
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution25 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        //todo: corner case;
        if(numRows==0) return res;

        res.add(Arrays.asList(1));
        //i is the row number  0-numRows-1
        // row length numRows
        for(int i=1;i<numRows;i++){
            ArrayList<Integer> tmp=new ArrayList<>(Arrays.asList(1));
            for(int j=1;j<i;j++){
                List<Integer> up=res.get(i-1);
                tmp.add(up.get(j-1)+up.get(j));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
}
