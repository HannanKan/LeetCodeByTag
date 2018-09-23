#include<vector>
#include<algorithm>
#include<iostream>
#include<string>
using namespace std;
class Solution7 {
public:
	//i<=j<=k<10
	vector<vector<int>> combinationSum3(int k, int n) {
		vector<int>ele;
		vector<vector<int>> res = recursive(1,k, n, ele,0);
		return res;
	}
	vector<vector<int>> recursive(int start,int level, int n, vector<int>& ele,int sum){
		vector<vector<int>> res;
		if (level == 0){
			if(sum==n) res.push_back(ele);
			return res;
		}
		for (; start <=10 - level; start++){
			ele.push_back(start);
			for (vector<int> e : recursive(start+1, level - 1, n, ele,sum+=start))
				res.push_back(e);
			sum -= start;
			ele.erase(ele.end()-1);
		}
		return res;
	}
};
/*
void main(){
	Solution7 s;
	vector<vector<int> >v = s.combinationSum3(3, 9);
	for (vector<int> ele : v){
		for (int x : ele){
			cout << x << " ";
		}
		cout << endl;
	}

}
*/