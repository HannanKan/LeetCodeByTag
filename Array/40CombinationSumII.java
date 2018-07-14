import java.util.*;

public class Solution2 {

    public static void main(String[] args){
        List<List<Integer>> res;
        int[] x={1,2,3};
        res=new Solution2().combinationSum2(x,5);
        for(List<Integer> item : res){
            for(Integer i:item){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null||candidates.length==0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> item=new ArrayList<>();
        helper(candidates,res,item,0,target);
        Map<String,List<Integer>> map=new HashMap<>();
        for(List<Integer> ele: res){
            map.put(ele.toString(),ele);
        }
        res=new ArrayList<>();
        for(List<Integer> ele: map.values()){
            res.add(ele);
        }
        return res;
    }
    //todo: corner case--> when duplicate elements exist, may output duplicate result;
    //todo: avoid this kind of error, to read and think problem carefully
    //method of remove duplicate: toString() + HashMap(), and then fetch the values()
    private void helper(int[] candidates,List<List<Integer>> res,ArrayList<Integer> item,int start,int target){
        if(target==0){
            res.add(new ArrayList<>(item));
            return ;
        }
        if(target<0) return;

        for(int i=start;i<candidates.length&&candidates[i]<=target;i++){
            item.add(candidates[i]);
            helper(candidates,res,item,i+1,target-candidates[i]);
            item.remove(item.size()-1);
        }
    }
}
