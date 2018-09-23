/*
leetcode: 106. Construct Binary Tree from Inorder and Postorder Traversal
* */
/*class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }*/
public class Solution24 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //todo:corner case
        if(inorder==null||inorder.length==0) return null;

        TreeNode root=recursive(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return root;
    }
    //[inl,inr]
    public TreeNode recursive(int[] inorder,int inl,int inr,int[] postorder,int pl,int pr){
        TreeNode root=new TreeNode(postorder[pr]);
        //todo: one element
        if(pl==pr){
            root.left=root.right=null;
            return root;
        }

        int leftLen=search(inorder,inl,inr+1,postorder[pr])-inl;
        int rightLen=inr+1-inl-leftLen-1;
        if(leftLen!=0) root.left=recursive(inorder,inl,inl+leftLen-1,postorder,pl,pl+leftLen-1);
        if(rightLen!=0) root.right=recursive(inorder,inr-rightLen+1,inr,postorder,pr-rightLen,pr-1);
        return root;

    }
    //[left,right)
    public int search(int[] nums,int left,int right,int key){
        for(;left<right;left++)
            if(nums[left]==key) return left;
        return -1;
    }
}
