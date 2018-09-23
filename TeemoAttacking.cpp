#include<iostream>
#include<vector>
using namespace std;
class Solution11 {
public:
	int findPoisonedDuration(vector<int>& timeSeries, int duration) {
		int len = timeSeries.size();
		//corner case;
		if (len == 0) return 0;
		if (len == 1) return duration;

		int* mark = new int[len];
		for (int i = 0; i < len; i++) mark[i] = 0;
		for (int i = 0; i < len-1; i++){
			if (timeSeries[i] + duration>timeSeries[i + 1]) mark[i] = 1;
		}

		//last one must be 0
		int count = 0;
		for (int i = 0; i < len; i++){
			if (mark[i] == 0){
				int j = i - 1;
				while (j >= 0 && mark[j] == 1) j--;// last 0;
				if (j < 0) j = 0;
				else j = j+1;//mark[j]==0
				//mark[j]==1
				count += (timeSeries[i] - timeSeries[j] + duration);
			}
		}
		return count;
	}
};
/*
void main(){
	vector<int> v = { 1,2};
	Solution11 s;
	cout << s.findPoisonedDuration(v, 2) << endl;
}
*/