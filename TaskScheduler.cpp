#include<iostream>
#include<map>
#include<algorithm>
#include<vector>
using namespace std;
class Solution15 {
public:
	int leastInterval(vector<char>& tasks, int n) {
		vector<int> cnt(26, 0);
		for (char task : tasks) {
			++cnt[task - 'A'];
		}
		sort(cnt.begin(), cnt.end());
		int i = 25, mx = cnt[25], len = tasks.size();
		while (i >= 0 && cnt[i] == mx) --i;
		return max(len, (mx - 1) * (n + 1) + 25 - i);
	}
};
/*
void main(){
	vector<char> v = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D'};
	Solution15 s;
	cout << s.leastInterval(v, 2) << endl;
}*/

/* not optimal
int leastInterval(vector<char>& tasks, int n) {
int time = 0;
int numOftask = tasks.size();
if (n == 0) return numOftask;
map<char,int> m;
for (char c : tasks){
map<char,int>::iterator it = m.find(c);
if (it == m.end()) {
m.insert(pair<char, int>(c, 1));
}
else it->second += 1;
}

char* pool = new char[n+1];
for (int i = 0; i < n +1; i++)pool[i] = 'i';
int current = 0;
bool found = false;
while (numOftask != 0){
map<char, int>::iterator it = m.begin();
while (it != m.end()){
int j;
bool canRun = true;
for (j = 0; j < n + 1 && j != current;j++){
if (pool[j] == it->first) {
canRun = false;
break;
}
}
if (canRun){// can input
time++;
pool[current] = it->first;
current = (current + 1) % (n+1);
it->second -= 1;
if (it->second == 0) m.erase(it);
numOftask--;
found = true;
break;
}
else it++;
}
if (!found){
pool[current] = 'i';
time++;
current = (current + 1) % (n+1);
}
else found = false;
}
return time;

}*/


/*
int leastInterval(vector<char>& tasks, int n) {
int numOftask = tasks.size();
if (n == 0) return numOftask;
map<char, int> m;
for (char c : tasks){
map<char, int>::iterator it = m.find(c);
if (it == m.end()) {
m.insert(pair<char, int>(c, 1));
}
else it->second += 1;
}
vector<pair<char, int>> v;
for (pair<char, int> p : m){
v.push_back(p);
}
char* pool = new char[n + 1];
for (int i = 0; i < n + 1; i++)pool[i] = 'i';
int current = 0;
int time = 0;
vector<pair<char, int>>::iterator it = v.begin();
bool found = false;
while (numOftask != 0){
int j = 0;
bool canRun = true;
for (j = 0; j < n + 1 && j != current; j++){
if (pool[j] == it->first) {
canRun = false;
break;
}
}
if (canRun){
time++;
pool[current] = it->first;
current = (current + 1) % (n + 1);
it->second -= 1;
if (it->second == 0) it = v.erase(it);
else {
it++;
}
if (it == v.end()) it = v.begin();
numOftask--;
}
else{
pool[current] = 'i';
time++;
current = (current + 1) % (n + 1);
it++;
if (it == v.end()) it = v.begin();
}
/*
int tmplen = v.size();
int loop = 0;
while (loop<tmplen){
int j;
bool canRun = true;
for (j = 0; j < n + 1 && j != current; j++){
if (pool[j] == it->first) {
canRun = false;
break;
}
}
if (canRun){
time++;
pool[current] = it->first;
current = (current + 1) % (n + 1);
it->second -= 1;
if (it->second == 0) it=v.erase(it);
else {
it++;
}
if (it == v.end()) it = v.begin();
numOftask--;
found = true;
break;
}
else {
loop++;
it++;
if (it == v.end()) it = v.begin();
}
}
if (!found){
pool[current] = 'i';
time++;
current = (current + 1) % (n + 1);
}
else {
found = false;
}
		}
		return time;

	}
*/