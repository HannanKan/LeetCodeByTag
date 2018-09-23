#include<iostream>
#include<vector>
#include<string>
using namespace std;
class Solution25 {
public:
	int minCut(string s) {
		int len = s.size();
		int* plen = new int[len];
		bool* v = new bool[len];
		for (int i = 0; i < len; i++){
			if (i == 0){
				plen[i] = 1;
				v[i] = true;
			}
			else{
				if (v[i - 1] == true && s[i] == s[i - 1]){
					v[i] = true;
					plen[i] = plen[i - 1] + 1;
					continue;
				}
				if (i - 1 - plen[i - 1] < 0) { //no palindrome char
					v[i] = true;
					plen[i] = 1;
					continue;
				}
				if (s[i - 1 - plen[i - 1]] == s[i]){
					v[i] = false;
					plen[i] = plen[i - 1] + 2;
					continue;
				}
				v[i] = true;
				plen[i] = 1;
			}
		}
		int count = 0;
		cout << "plen" << endl;
		for (int i = 0; i < len; i++){
			cout << plen[i] << endl;
		}
		for (int i = len - 1; i >= 0;){
			i = i - plen[i];
			count++;
		}
		return count - 1;
	}
};
#include<stdio.h>
#include<fstream>
void main(){
	/*string s = "cabababcbc";
	Solution25 sp;
	cout<<"ans\n"<<sp.minCut(s) << endl;*/
	ofstream out("test.txt", ios::out);
	for (int i = 0; i < 100; i++)
		out << "i:hello Mr." << i << endl;
	ifstream fin("test.txt", ios::in);
	char s;
	cout << EOF << endl;
}