#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Solution17 {
public:
	int maximumSwap(int num) {
		vector<int> res;
		int tmpnum = num;
		while (tmpnum>0){
			int tmp = tmpnum / 10 * 10;
			res.push_back(tmpnum - tmp);
			tmpnum = tmpnum / 10;
		}
		vector<int> tmp;
		for (vector<int>::reverse_iterator it = res.rbegin(); it!=res.rend(); it++){
			tmp.push_back(*it);
		}
		int len = tmp.size();

		int pi = -1;
		int start = 0;
		for (start = 0; start < len; start++){
			pi = start;
			for (int m = start + 1; m < len; m++){
				if (tmp[m] >= tmp[pi]){
					pi = m;
				}
			}
			if (pi != start&&tmp[pi]!=tmp[start]){
				int ans = 0;
				int t = tmp[pi];
				tmp[pi] = tmp[start];
				tmp[start] = t;
				for (int index = 0; index < len; index++)
					ans = ans * 10 + tmp[index];
				return ans;
			}
		}
		return num;
	}
};

/*
void main(){
	int v = 98368;
	Solution17 s;
	cout << s.maximumSwap(v);
}

*/