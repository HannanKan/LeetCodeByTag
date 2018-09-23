#include<vector>
#include<iostream>
using namespace std;
class Solution14 {
public:
	int arrayNesting(vector<int>& nums) {
		int len = nums.size();
		int* mark = new int[len];
		for (int i = 0; i < len; i++)mark[i] = 0;
		int max = 0;
		int cur = 0;
		for (int i = 0; i < len; i++){
			cur = traverse(nums, mark, i);
			max = (max>cur ? max : cur);
		}
		return max;
	}
	int traverse(vector<int>& nums,int* mark,int start){
		if (mark[start] == 1) return 0;
		mark[start] = 1;
		int count = 1;
		int travel = nums[start];
		while (travel != start&&mark[travel]!=1){
			mark[travel] = 1;
			travel = nums[travel];
			count++;
		}
		return count;
	}
};
/*
void main(){
	vector<int> v = { 5, 4, 0, 3, 1, 6, 2 };
	Solution14 s;
	cout << s.arrayNesting(v) << endl;
}
*/