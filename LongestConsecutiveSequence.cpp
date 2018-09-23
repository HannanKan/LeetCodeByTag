#include<vector>
#include<algorithm>
#include<iostream>
#include<string>
using namespace std;
class Solution4 {
public:
	int longestConsecutive(vector<int>& nums) {
		sort(nums.begin(), nums.end());
		nums = removeDup(nums);
		int ans = 0;
		int cur = 0;
		for (int i = 0; i<nums.size(); i++){
			if (i == 0){
				cur = 1;
			}
			else{
				if (nums[i] == nums[i - 1] + 1)cur++;
				else{
					ans = (ans>cur ? ans : cur);
					cur = 1;
				}
			}
		}
		ans = (ans>cur ? ans : cur);
		return ans;
	}
	vector<int> removeDup(vector<int>& v){
		vector<int> res;
		for (int x : v){
			if (res.size() == 0 || res.back() != x) res.push_back(x);
		}
		return res;
	}
};
/*
void main(){
	vector<int> v = { 1,2,0,1 };
	Solution4 s;
	cout << s.longestConsecutive(v) << endl;

}
*/