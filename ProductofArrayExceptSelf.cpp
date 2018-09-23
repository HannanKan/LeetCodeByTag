#include<vector>
#include<algorithm>
#include<iostream>
#include<string>
using namespace std;
class Solution6 {
public:
	vector<int> productExceptSelf(vector<int>& nums) {
		int* preProduct = new int[nums.size()];
		int* sufProduct=new int[nums.size()];
		int prePro = 1,sufPro=1;
		for (int i = 0; i < nums.size(); i++){
			if (i == 0)preProduct[i]=prePro;
			else{
				prePro = prePro*nums[i - 1];
				preProduct[i]=prePro;
			}
		}
		for (int i = nums.size() - 1; i >= 0; i--){
			if (i == nums.size() - 1) sufProduct[i]=sufPro;
			else{
				sufPro *= nums[i + 1];
				sufProduct[i]=sufPro;
			}
		}
		vector<int> result;
		for (int i = 0; i < nums.size(); i++){
			result.push_back(preProduct[i] * sufProduct[i]);
		}
		return result;
	}
};
/*
void main(){
	vector<int> v = { 1, 2, 3, 4 };
	Solution6 s;
	vector<int> res= s.productExceptSelf(v);
	for (int x : res)
		cout << x << endl;
}
*/