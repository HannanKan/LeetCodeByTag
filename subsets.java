import org.omg.CORBA.ARG_IN;

import java.util.ArrayList;
import java.util.List;

public class Solution18 {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null|| nums.length==0) return new ArrayList<>();
        ArrayList<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=1;i<=nums.length;i++){
            ArrayList<Integer> ele=new ArrayList<>();
            recursiveAdd(res,0,i,ele,nums);
        }
        return res;
    }
    public void recursiveAdd(List<List<Integer>> res,int start, int depth,List<Integer> ele,int[] nums){
        if(ele.size()==depth) {
            List<Integer> addEle=new ArrayList<>(ele);
            res.add(addEle);
            return;
        }
        if(ele.size()+(nums.length-start)<depth) return;
        for(;start<nums.length;start++){
            ele.add(nums[start]);
            recursiveAdd(res,start+1,depth,ele,nums);
            ele.remove(ele.size()-1);
        }

    }
}
