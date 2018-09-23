#include<vector>
#include<map>
#include<iostream>
using namespace std;
class Solution1 {
public:
	/* naive method
	bool containsNearbyDuplicate(vector<int>& nums, int k) {
		for (int i = 0; i < nums.size();i++){
			int key = nums[i];
			for (int j = 1; j <= k; j++){
				if ((i+j)<nums.size()&&key == nums[i + j]) return true;
			}
		}
		return false;
	}
	*/
	bool containsNearbyDuplicate(vector<int>& nums, int k) {
		map<int, int> keyIndex;
		for (int i = 0; i < nums.size(); i++){
			map<int, int>::iterator iter = keyIndex.find(nums[i]);
			if (keyIndex.end() == iter){
				keyIndex.insert(pair<int,int>(nums[i],i));
			}
			else{
				if ((i - iter->second) <= k) return true;
				else iter->second = i;
			}
		}
		return false;
	}
};
/*
int main(){
	vector<int> v = { 1, 2, 3, 1, 2, 3 };
	Solution1 s;
	cout << s.containsNearbyDuplicate(v, 2) << endl;
	return 0;
}
*/