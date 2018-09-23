/*
 * leetcode: 105. Construct Binary Tree from Preorder and Inorder Traversal
 * */
import java.util.Arrays;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution23 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //todo: corner case
        if(preorder==null || preorder.length==0) return null;
        TreeNode root=recursive(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;

    }
    //[prel,prer] is close interval
    public TreeNode recursive(int[] preorder,int prel,int prer, int[] inorder,int inl,int inr ){
        TreeNode root=new TreeNode(preorder[prel]);
        //todo: only one element
        if(prel==prer){
            root.left=root.right=null;
            return root;
        }
        //todo: more than one element
        int leftLen=search(inorder,inl,inr+1,preorder[prel])-inl;//left len
        int rightLen=inr-search(inorder,inl,inr+1,preorder[prel]);//right len
        //todo: left subtree
        if(leftLen!=0)
            root.left=recursive(preorder,prel+1,prel+leftLen,inorder,inl,inl+leftLen-1);
        //todo: right subtree
        if(rightLen!=0)
            root.right=recursive(preorder,prel+leftLen+1,prer,inorder,inl+leftLen+1,inr);
        return root;
    }
    //[left,right)
    public static int search(int[] nums, int left, int right,int key){
        for(;left<right;left++)
            if(nums[left]==key) return left;
        return -1;
    }
}

