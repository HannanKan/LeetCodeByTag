#include<iostream>
#include<vector>
using namespace std;
class Solution20 {
public:
	/*
	int numSubarrayProductLessThanK(vector<int>& nums, int k) {
		int sum = 0;
		for (int i = 1; i <= nums.size(); i++){
			sum += recursive(nums, 0, i, 1,k);
		}
		return sum;

	}
	int recursive(vector<int>&nums, int start, int level,int subproduct,int k){
		if (level == 0){
			if (subproduct < k) return 1;
			else return 0;
		}
		int cum = 0;
		for (int i = start; i < nums.size(); i++){
			subproduct *= nums[start];
			cum += recursive(nums, i + 1, level - 1, subproduct, k);
				subproduct /= nums[start];
		}
		return cum;
	}
	*/
	int numSubarrayProductLessThanK(vector<int>& nums, int k) {
		int cum = 0;
		for (int i = 0; i < nums.size(); i++){
			int subproduct = 1;
			int j = i;
			while(j<nums.size()){
				subproduct *= nums[j];
				if (subproduct < k){ 
					cum += 1; 
					j++;
				}
				else break;
			}
		}
		return cum;
	}
};
/*
void main(){
	vector<int> v = { 10, 5, 2, 6 };
	Solution20 s;
	cout << s.numSubarrayProductLessThanK(v, 100);
}
*/