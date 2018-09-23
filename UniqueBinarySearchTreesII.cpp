#include<vector>
#include<iostream>
using namespace std;
/**
* Definition for a binary tree node.*/
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution22 {
public:

	vector<TreeNode*> generateTrees(int n) {
		if (n == 0) return*(new vector<TreeNode*>);
		return build(n, 1);//1...n
	}
	vector<TreeNode*> build(int n,int start_v){
		if (n <= 0){
			vector<TreeNode*> res;
			res.push_back(NULL);
			return res;
		}
		if (n == 1){
			vector<TreeNode*> res;
			res.push_back(new TreeNode(start_v));
			return res;
		}
		else{
			vector<TreeNode*>res;
			for (int i = 0; i < n; i++){
				//number of left sub tree node: 0...n-1( last one is root)
				vector<TreeNode*> l = build(i, start_v);
				vector<TreeNode*> r = build(n - i - 1, start_v + i + 1);

				for (TreeNode* ls : l){
					for (TreeNode* rs : r){
						TreeNode* root = new TreeNode(start_v+i);
						root->left = ls;
						root->right = rs;
						res.push_back(root);
					}
				}
			}
			return res;
		}
	}
};