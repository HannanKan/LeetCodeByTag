#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
	vector<int> majorityElement(vector<int>& nums) {
		vector<int> ans;
		if (nums.size() == 0) {
			return ans;
		}
		int** ans1 = majority(nums);
		if (ans1[0] != NULL&&verify(nums, *ans1[0])) ans.push_back(*ans1[0]);
		if (ans1[1] != NULL&&verify(nums, *ans1[1])) ans.push_back(*ans1[1]);
		return ans;

	}
	int** majority(vector<int>&nums){
		int** ans = new int*[2];
		ans[0] =ans[1]=NULL;
		int count[2] = { 0 };
		for (int x : nums){
			//assignment,following two if-clauses overlap with each other, but continue can avoid error
			if (ans[0] == NULL && (ans[1] == NULL || *ans[1] != x)) {
				ans[0] = new int;
				*ans[0] = x;
				count[0] = 1;
				continue;
			}
			if (ans[1] == NULL && (ans[0] == NULL || *ans[0] != x)){
				ans[1] = new int;
				*ans[1] = x;
				count[1] = 1;
				continue;
			}
			//addition
			if (ans[0]!=NULL && x == *ans[0]) count[0]++;
			else if (ans[1]!=NULL && x == *ans[1]) count[1]++;
			else{
				count[1]--;
				count[0]--;
				if (count[1] == 0){
					delete(ans[1]);
					ans[1] = NULL;
				}
				if (count[0] == 0){
					delete(ans[0]);
					ans[0] = NULL;
				}
			}
		}
		return ans;
	}
	bool verify(vector<int>&nums, int x1){
		int thresh = nums.size() / 3;
		int count = 0;
		for (int x : nums){
			if (x == x1) count++;
		}
		if (count > thresh) return true;
		else return false;
	}
};
/*
int main(){
	vector<int> nums = { 2,2,1,3 };
	Solution s1;
	vector<int> result = s1.majorityElement(nums);
	for (int x : result){
		cout << x << endl;
	}
	return 0;
}
*/