#include<vector>
#include<iostream>
using namespace std;
class Solution18 {
public:
	vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
		int len = nums.size();
		int lenk = len - k + 1;
		int* ksum = new int[lenk];

		int sum = 0;
		for (int i = 0; i < k - 1; i++)
			sum += nums[i];
		for (int i = 0; i < lenk; i++){
			sum += nums[i+k-1];
			if (i - 1 >= 0)sum -= nums[i - 1];
			ksum[i] = sum;
		}

		int i, j, m;
		int max=0;
		int mi, mj, mk;
		for (i = 0; i < lenk; i++){
			for (j = i + k; j < lenk; j++){
				for (m = j + k; m < lenk; m++){
					int tmp = ksum[i] + ksum[j] + ksum[m];
					if (max < tmp){
						mi = i;
						mj = j;
						mk = m;
						max = tmp;
					}
				}
			}
		}
		vector<int> res = { mi, mj, mk };
		return res;
	}
};

/*
void main(){
	vector<int> nums = { 1, 2, 1, 2, 6, 7, 5, 1 };
	Solution18 s;
	for (int x : s.maxSumOfThreeSubarrays(nums, 2))
		cout << x << endl;
}
*/