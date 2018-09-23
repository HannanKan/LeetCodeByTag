#include<iostream>
#include<map>
#include<vector>
using namespace std;

class Solution19 {
public:
	int findShortestSubArray(vector<int>& nums) {
		int len = nums.size();
		map<int, int> m;
		for (int i = 0; i<len; i++){
			map<int, int>::iterator tmp = m.find(nums[i]);
			if (tmp != m.end())tmp->second++;
			else {
				m.insert(pair<int, int>(nums[i], 1));
			}
		}
		int max = 0;
		for (pair<int, int> p : m){
			if (p.second>max) max = p.second;
		}
		vector<int> ans;
		for (pair<int, int> p : m){
			if (p.second == max) ans.push_back(p.first);
		}
		int min = 50000;
		for (int x : ans){
			int tmp = length(nums, x);
			if (tmp < min) min = tmp;
		}
		return min;

	}
	int length(vector<int> nums, int key){
		int i, j;
		for (i = 0; i < nums.size() && nums[i] != key; i++);
		for (j = nums.size()-1; j >= 0 && nums[j] != key; j--);
		return (j - i + 1);
	}
};
/*
void main(){
	vector<int> v = { 1, 2, 2, 3, 1 };
	Solution19 s;
	cout << s.findShortestSubArray(v);
}

*/