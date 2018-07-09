class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size()==0) return{-1,-1};
        if(nums.size()==1) {
            if(nums[0]==target) return{0,0};
            else return {-1,-1};
        }
        //find left bound
        int l,r;
        l=0;
        r=nums.size()-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]<target) l=mid+1;
            else if(nums[mid]==target) r=mid;
            else r=mid-1;
            
        }
        if(nums[l]!=target) return{-1,-1};
        int start=l;
        //find right bound
        l=0;
        r=nums.size()-1;
        while(l<r){
            int mid=(l+r+1)/2;//ceiling
            if(nums[mid]==target) l=mid;
            else if(nums[mid]<target) l=mid+1;
            else r=mid-1;
            
        }
        vector<int> result;
        result.push_back(start);
        result.push_back(l);
        return result;
        
    }
};