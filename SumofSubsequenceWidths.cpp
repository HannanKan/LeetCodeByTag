#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
class Solution16 {
public:
	/*int sumSubseqWidths(vector<int>& A) {
		int ans = 0;
		vector<int> sub;
		for (int i = 1; i <= A.size(); i++){
			sub.clear();
			int one=recursive(A,0, i,sub);
			cout << "one" << one << endl;
			ans = ans + one;
		}
		return ans;
	}
	int recursive(vector<int> nums, int start,int lenSub,vector<int> sub){
		if (lenSub == 0){
			int maxi = 0, mini = 20000;
			cout << "one round" << endl;
			for (int x : sub){
				cout << x <<" ";
				maxi = max(maxi, x);
				mini = min(mini, x);
			}
			cout <<maxi-mini<< endl;
			return (maxi - mini);
		}
		int count = 0;
		for (int i = start; i < nums.size() - lenSub+1; i++){
			sub.push_back(nums[i]);
			count+=recursive(nums, i + 1, lenSub - 1, sub);
			sub.pop_back();
		}
		return count;
	}*/
	
	int sumSubseqWidths(vector<int>& A) {
		int sum = 0;
		int maxi, mini;
		for (int i = 0; i < A.size(); i++){
			maxi =mini= A[i];
			for (int j = i + 1; j < A.size(); j++){
				maxi = max(maxi, A[j]);
				mini = min(mini, A[i]);
				sum += pow(2, j - i-1)*(maxi-mini);
			}
		}
		return sum;
	}
};
/*
void main(){
	vector<int> v = { 2,1,3 };
	Solution16 s;
	cout << s.sumSubseqWidths(v) << endl;

}
*/