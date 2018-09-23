#include<iostream>
#include<vector>
using namespace std;

class Solution13 {
public:
	int subarraySum(vector<int>& nums, int k) {
		int len = nums.size();
		int count = 0;
		/*int**dp = new int*[len];
		for (int i = 0; i < len; i++)
			dp[i] = new int[len];*/
		int x = 0;
		for (int i = 0; i < len; i++){
			x = 0;
			for (int j = i; j < len; j++){
				x += nums[j];
				if (x == k)count++;
				//dp[i][j] = x;
			}
		}
		return count;
	}
};
/*
void main(){
	vector<int> v = { 1, 1, 1 };
	Solution13 s;
	cout << s.subarraySum(v, 2) << endl;

}
*/