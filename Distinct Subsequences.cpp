#include<vector>
#include<iostream>
#include<string>
#include<stack>
#include<list>
using namespace std;

class Solution24 {
public:
	int numDistinct(string s, string t) {
		int lens = s.size();
		int lent = t.size();
		int dprow = lent + 1;
		int dpcol = lens + 1;
		int** dp = new int*[dprow];
		for (int i = 0; i < dprow; i++)dp[i] = new int[dpcol];
		
		for (int i = 0; i < dpcol; i++) dp[0][i] = 1;
		for (int i = 1; i < dprow; i++) dp[i][0] = 0;

		for (int i = 1; i <dprow; i++){
			for (int j = 1; j < dpcol; j++){
				dp[i][j] = 0;
				if (t[i-1] != s[j-1])dp[i][j] = dp[i][j-1];
				else{
					dp[i][j] = dp[i][j - 1] + dp[i-1][j-1];
				}
			}
		}
		return dp[dprow-1][dpcol-1];
	}
	/*
	int numDistinct(string s, string t) {
		//t match s's sub

		int lens = s.size();
		int lent = t.size();
		int** dp = new int*[lent];
		for (int i = 0; i < lent; i++)dp[i] = new int[lens];

		for (int i = 0; i < lent; i++){
			for (int j = 0; j < lens; j++){
				dp[i][j] = 0;
				if (t[i] == s[j])dp[i][j] = 1;
			}
		}
		//(row,col)
		vector<pair<int, int>> v;
		for (int i = 0; i < lens; i++){
			if (dp[0][i] == 1){
				v.push_back(pair<int, int>(0, i));
			}
		}
		int count = 0;
		while (v.size() != 0){
			pair<int, int> cur = v.back();
			v.pop_back();
			if (cur.first == lent - 1){
				count++;
			}
			else{
				int tmprow = cur.first + 1;
				for (int i = cur.second + 1; i < lens; i++){
					if (dp[tmprow][i] == 1) v.push_back(pair<int,int>(tmprow,i));
				}
			}

		}
		return count;

		
	}*/
	/*
	int recursive(int**dp, int row,int col,int start_col, int match_row){
		if (match_row == row) return 1;
		if (start_col == col) return 0;//haven't match all
		int i = start_col;
		int count = 0;
		for (; i < col; i++){
			if (dp[match_row][i] == 1) count += recursive(dp, row, col, i + 1, match_row + 1);
		}
		return count;
	}
	*/
};
/*
void main(){
	Solution24 s;
	cout << s.numDistinct("babgbag", "bag") << endl;
}
*/