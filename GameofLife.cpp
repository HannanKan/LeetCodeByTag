#include<vector>
#include<algorithm>
#include<iostream>
#include<string>
using namespace std;
class Solution8 {
public:
	void gameOfLife(vector<vector<int>>& board) {
		int** tmp = new int*[board.size()];
		for (int i = 0; i < board.size(); i++)
			tmp[i] = new int[board[0].size()];
		int rowlen = board.size();
		int collen = board[0].size();
		for (int i = 0; i < board.size(); i++){
			for (int j = 0; j < board[0].size(); j++){
				int num = 0;
				if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) num += 1;
				if (i - 1 >= 0 && board[i - 1][j] == 1) num += 1;
				if (j + 1 < collen && i - 1 >= 0 && board[i - 1][j + 1] == 1) num += 1;
				if (j + 1 < collen && board[i][j + 1] == 1) num += 1;
				if (j + 1 < collen && i + 1 < rowlen && board[i + 1][j + 1] == 1) num += 1;
				if (i + 1 < rowlen && board[i + 1][j] == 1) num += 1;
				if (i + 1 < rowlen&&j - 1 >= 0 && board[i + 1][j - 1] == 1) num += 1;
				if (j - 1 >= 0 && board[i][j - 1] == 1) num += 1;
				if (num<2 || num>3 || (board[i][j] == 0 && num == 2)) tmp[i][j] = 0;
				else tmp[i][j] = 1;
			}
		}
		for (int i = 0; i < board.size(); i++){
			for (int j = 0; j < board[0].size(); j++){
				board[i][j] = tmp[i][j];
			}
		}
	}
};