public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        // root!= null
        if(key < root.val){
            // xet bai toan con subtree ben trai
            root.left = deleteNode(root.left,key);
        }else if(key> root.val) {
            root.right = deleteNode(root.right,key);
        }else {
            // key == root.val
            if(root.left ==null && root.right == null){
                return null;
            }
            if(root.left == null && root.right != null){
                return root.right;
            }
            if(root.right == null && root.left != null){
                return root.left;
            }
            // truong hop 2 con
            int temp = findMinOfRightSubTree(root.right);
            root.val = temp;
            root.right = deleteNode(root.right,temp);
        }
        return root;

    }
    private static int findMinOfRightSubTree(TreeNode root){
        TreeNode curr =root;
        while (curr.left != null){
            curr = curr.left;
        }
        return curr.val;
    }
}
