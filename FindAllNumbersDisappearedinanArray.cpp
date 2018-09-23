#include<iostream>
#include<vector>
using namespace std;
class Solution10 {
public:
	vector<int> findDisappearedNumbers(vector<int>& nums) {
		for (int i = 0; i < nums.size(); i++){
			if (nums[i] != i + 1) {
				int tmp = nums[nums[i] - 1];
				if (tmp == nums[i]) continue;//avoid repeated swap
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
				i--;
			}
		}
		vector<int> res;
		for (int i = 0; i < nums.size(); i++){
			if (nums[i] != i + 1) res.push_back(i + 1);
		}
		return res;
	}
};
/*
void main(){
	vector<int> v = { 4, 3, 2, 7, 8, 2, 3, 1 };
	Solution10 s;
	for (int x : s.findDisappearedNumbers(v))
		cout << x << endl;

}*/