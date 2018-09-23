#include<vector>
#include<algorithm>
#include<iostream>
#include<string>
using namespace std;
class Solution5 {
public:
	int maxProfit(vector<int>& prices) {
		int len = prices.size();
		int* prePro = new int[len];
		int * sufPro = new int[len];
		for (int i = 0; i < len; i++){
			prePro[i] = sufPro[i] = 0;
		}
		int minV = prices[0];
		for (int i = 1; i < len; i++){
			minV = min(minV, prices[i]);
			prePro[i] =max( prices[i] - minV,prePro[i-1]);
		}
		int maxV = prices[len-1];
		for (int i = len - 2; i >= 0; i--){
			maxV = max(maxV,prices[i]);
			sufPro[i] = max(maxV - prices[i],sufPro[i+1]);
		}
		int res = 0;
		for (int i = 0; i < len; i++)
			res = max(res,prePro[i]+sufPro[i]);
		return res;
	}
};
/*
void main(){
	vector<int> v = { 3, 3, 5, 0, 0, 3, 1, 4 };
	Solution5 s;
	cout << s.maxProfit(v) << endl;

}
*/