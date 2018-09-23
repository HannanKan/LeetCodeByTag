import java.util.Arrays;

public class Solution3 {

    public static void main(String[] args) {
        int nums[] = {0, 2, 2, 1, 1};
        System.out.println(new Solution3().firstMissingPositive(nums));
    }

    //todo: corner case: there exist duplicated elements
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //condition is critical
            //nums[nums[i]-1]!=nums[i] and i--; these two conditions ensure
            //that value in current position is either nonsense(<=0 or >nums.length) or
            // the right one(nums[nums[i]-1]=nums[i]), then 0...current position is well-processed
            //or will be processed decently.
            if (nums[i] > 0 && nums[i] <= nums.length) {
                swap(nums, i, nums[i] - 1);//A[i]=i+1;
                i--;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) return i + 1;
            }
            return nums.length + 1;
        }
        public void swap ( int[] nums, int index1, int index2){
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
