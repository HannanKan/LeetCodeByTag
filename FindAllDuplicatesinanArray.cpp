#include<vector>
#include<iostream>
#include<set>
using namespace std;

class Solution9 {
public:
	/*
    vector<int> findDuplicates(vector<int>& nums) {
        vector<int> res;
		set<int> s;
        for(int x:nums){
			if (s.find(x) == s.end()) s.insert(x);
			else res.push_back(x);
        }
		return res;
    }*/
	//more elegant answer
	vector<int> findDuplicates(vector<int>& nums) {
		vector<int> res;
		for (int i = 0; i < nums.size(); ++i) {
			int idx = abs(nums[i]) - 1;
			if (nums[idx] < 0) res.push_back(idx + 1);
			nums[idx] = -nums[idx];
		}
		return res;
	}

};
/*
void main(){
	vector<int> v = { 4, 3, 2, 7, 8, 2, 3, 1 };
	Solution9 s;
	for (int x : s.findDuplicates(v))
		cout << x << endl;

}*/