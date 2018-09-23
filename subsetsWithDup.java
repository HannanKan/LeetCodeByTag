/*
leetcode: 90. Subsets II
* */

import java.util.*;

public class Solution22 {
    public static void main(String[] args){
        int[] nums={1,2,2};
        List<List<Integer>> res=new Solution22().subsetsWithDup(nums);
        for(List<Integer> ele: res){
            System.out.println(ele.toString());
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //null set
        ArrayList<Integer> ele = new ArrayList<>();
        //todo: corner cases
        if (nums == null || nums.length == 0){
            res.add(ele);
            return res;
        }

        //todo: common cases
        int len = nums.length;
        //cnt is the cardinality of subset
        for (int cnt = 1; cnt <=len; cnt++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            getSubSet(nums, 0, cnt, tmp,ele);
            res.addAll(tmp);
        }
        HashMap<String, List<Integer>> hashMap=new HashMap<>();
        for(List<Integer> element: res){
            hashMap.put(element.toString(),new ArrayList<>(element));
        }
        res.clear();
        res.addAll(hashMap.values());
        res.add(new ArrayList<>());
        return res;
    }

    public void getSubSet(int[] nums, int start, int leftNum, List<List<Integer>> tmp,ArrayList<Integer> ele) {
        if (leftNum == 0) {
            //important
            ArrayList<Integer> tmpEle=new ArrayList<>(ele);
            Collections.sort(tmpEle);
            tmp.add(tmpEle);
            return;
        }
        if((nums.length-start)<leftNum)
            return;
        for(int i=start;i<=(nums.length-leftNum);i++){
            ele.add(nums[i]);
            getSubSet(nums,i+1,leftNum-1,tmp,ele);
            ele.remove(ele.size()-1);
        }
    }

}
