#include<vector>
#include<iostream>
using namespace std;

class Solution23 {
public:
	//字符串匹配问题/字串问题，直接上DP
	bool isInterleave(string s1, string s2, string s3) {
		int len1 = s1.size();
		int len2 = s2.size();
		int len3 = s3.size();
		if (len1 + len2 != len3) return false;
		bool** dp = new bool*[len1+1];
		for (int i = 0; i < len1 + 1; i++){
			dp[i] = new bool[len2 + 1];
		}
		dp[0][0] = true;
		for (int i = 1; i < len1 + 1; i++)
			dp[i][0] = dp[i - 1][0] && (s1[i - 1] == s3[i - 1]);
		for (int i = 1; i < len2 + 1; i++){
			dp[0][i] = dp[0][i - 1] && (s2[i - 1] == s3[i - 1]);
		}

		for (int i = 1; i < len1 + 1; i++){
			for (int j = 1; j < len2 + 1; j++){
				dp[i][j] = (dp[i][j-1]&&s2[j-1]==s3[i+j-1]) || (dp[i-1][j]&&s1[i-1]==s3[i+j-1]);
			}
		}
		return dp[len1][len2];
	}
};
/*
void main(){
	Solution23 s;
	cout << s.isInterleave("aabcc", "dbbca", "aadbbcbcac") << endl;
}
*/
