#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
using namespace std;
class Solution12 {
public:
	int findPairs(vector<int>& nums, int k) {
		int count = 0;
		sort(nums.begin(), nums.end());
		vector<int>::iterator iter = nums.begin();
		for (; iter < nums.end();iter++){
			if (iter != nums.begin() && *(iter) == *(iter - 1)) continue;
			int pair = *iter + k;
			if (search(iter + 1, nums.end(), pair))count++;
		}
		return count;
	}
	bool search(vector<int>::iterator start,vector<int>::iterator end, int key){
		while (start < end&&*start != key) start++;
		if (start == end) return false;
		else return true;
	}
};