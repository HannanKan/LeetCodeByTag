#include<string>
#include<iostream>
using namespace std;

class Solution21 {
public:
	int numDecodings(string s) {
		int len = s.size();
		if (len == 0) return 0;
		if (s[0] == '0') return 0;
		if (len == 1) return 1;
		int*dp = new int[len];
			dp[0] = 1;
		if (legal(s, 0)&&s[1]!='0') {
			dp[1] = 2;
		}
		else if(!legal(s,0)&&s[1]=='0'){
			return 0;
		}
		else{
			dp[1] = 1;
		}

		for (int i = 2; i < len; i++){
			if (s[i] == '0'){
				int tmp = (s[i - 1] - '0');
				if (tmp == 1 || tmp == 2) dp[i] = dp[i-2];
				else return 0;
			}
			else{
				if (legal(s, i - 1))dp[i] = dp[i - 2] + dp[i - 1];
				else dp[i] = dp[i - 1];
			}
		}
		return dp[len - 1];

	}
	//s[start,start+1]='10,,26' return true;
	bool legal(string s, int start){
		if (s[start] == '0') return false;
		int tmp = (s[start] - '0') * 10 + (s[start + 1] - '0');
		if (tmp <= 26) return true;
		else return false;
	}
};
/*
void main(){
	string s = "110";
	Solution21 so;
	cout << so.numDecodings(s) << endl;
}
*/