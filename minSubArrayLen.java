public class Solution32 {
    public static void main(String[] args){
        int[] nums={2,3,1,2,4,3};
        int target=7;
        System.out.println(new Solution32().minSubArrayLen(target,nums));
    }
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int res=DandC(nums,0,nums.length-1,s);
        if(res==((1<<31)-1)) return 0;
        else return res;
    }
    public int DandC(int[] nums,int left,int right,int target){
        if(left==right){
            if(nums[left]>=target) return 1;
            else return ((1<<31)-1);
        }
        int mid=(left+right)/2;
        int leftLen=DandC(nums,left,mid,target);
        int rightLen=DandC(nums,mid+1,right,target);

        int midLen;
        int midLeft=mid;
        int midRight=mid+1;
        int tmp=nums[mid]+nums[mid+1];
        int firstleft=0;
        int firstright=0;
        for(;;){
            if(midLeft<=left&&midRight>=right) break;
            if(tmp>=target) break;
            if(midLeft-1>=left){
                midLeft--;
                if(tmp+nums[midLeft]>=target) break;

            }
            if(midRight+1<=right){
                midRight++;
                if(tmp+nums[midRight]>=target) break;

            }
            if(firstleft==0&&firstright==0) tmp+=(nums[midLeft]+nums[midRight]);
            else if(firstleft==1&&firstright==0) tmp+=nums[midRight];
            else if(firstleft==0&&firstright==1) tmp+=nums[midLeft];
            else break;
            if(midLeft==left) firstleft=1;
            if(midRight==right) firstright=1;

        }

        if(tmp<target) return ((1<<31)-1);
        else midLen=(midRight-midLeft+1);

        int min=(leftLen<rightLen)?leftLen:rightLen;
        min=(min<midLen)?min:midLen;
        return min;

    }
}
