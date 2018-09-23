#include<vector>
#include<algorithm>
#include<iostream>
using namespace std;
class Solution3 {
public:
	int findMin(vector<int>& nums) {
		sort(nums.begin(),nums.end());
		return nums[0];
	}
};
/*
void main(){
	vector<int> v = {1,2,3,0};
	Solution3 s;
	cout << s.findMin(v) << endl;
}*/