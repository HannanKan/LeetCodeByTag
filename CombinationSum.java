import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args){
        List<List<Integer>> res;
        int[] x={1,2,3};
        res=new Solution().combinationSum(x,5);
        for(List<Integer> item : res){
            for(Integer i:item){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> item=new ArrayList<>();
        if(candidates==null ||candidates.length==0) return null;
        Arrays.sort(candidates);
        helper(res,item,target,candidates,0);
        return res;
    }
    private void helper(List<List<Integer>> res,ArrayList<Integer> item, int target, int[] candidates,int start){
        if(target==0) {
            List<Integer> tmp= new ArrayList<>(item);
           // Collections.sort(tmp);
            res.add(tmp);
            return;
        }
        if(target<0) return;
        for(int i=start;i<candidates.length&&candidates[i]<=target;i++){
            int t=target/candidates[i];
            int remain=target;
            for(int j=0;j<t;j++){
                item.add(candidates[i]);
                remain-=candidates[i];
                helper(res,item,remain,candidates,i+1);
            }
            for(int j=0;j<t;j++)
                item.remove(item.size()-1);
        }
    }
}