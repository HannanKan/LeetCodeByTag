#include<vector>
#include<algorithm>
#include<iostream>
#include<string>
using namespace std;
class EleStr{
public:
	int x;
public:
	EleStr(int x){
		this->x = x;
	}
};
bool Comparator(EleStr e1, EleStr e2){
	return (e1.x<e2.x);
}
bool ComparatorString(string s1, string s2){
	return (s1>s2);
}
/*
int main(){
	
	vector<EleStr> v;
	for (int i = 1000; i > 0; i--)
		v.push_back(*(new EleStr(i)));
	sort(v.begin(), v.end(),Comparator);

	for (EleStr e : v){
		cout << e.x << endl;
	}
	string s = "hannankan";
	string s2 = "ganhongnan";
	vector<string> v = { s, s2 };
	sort(v.begin(), v.end());
	for (string e : v)
		cout << e << endl;
	return 0;

}*/