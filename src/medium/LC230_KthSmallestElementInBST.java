package medium;

import entities.TreeNode;

public class LC230_KthSmallestElementInBST {


    /**
     * <b>1st Try.</b> <br />
     * Inorder traversal. (it starts from the smallest element and goes to the k<sup>th</sup> smallest).<br />
     * Solved: 2023-06-15
     */
    int i = 0;
    int smallest;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return smallest;
    }

    void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        i++;
        if (i == k){
            smallest = root.val;
        }
        inorder(root.right, k);
    }

}
