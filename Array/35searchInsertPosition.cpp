class Solution {
public:
	// be weak in processing corner case
	//be weak in processing finishing condition of while/for loop
    int searchInsert(vector<int>& nums, int target) {
        // corner case 0
        if(nums.size()==0) return 0;
        //corner case 1
        if(nums.size()==1) {
            if(nums[0]==target) return 0;
            else if(nums[0]>target) return 0;
            else return 1;
        }
        if(target<nums[0]) return 0;
        if(target>nums[nums.size()-1]) return nums.size();
        int l=0,r=nums.size()-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) {r=mid;}
            else {l=mid;} 
            if(l+1==r) {
                if(nums[l]==target) return l;
                else return l+1;
            }
        }
        
    }
};