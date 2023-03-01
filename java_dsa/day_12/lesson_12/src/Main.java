public class Main {
    public static void main(String[] args) {
        LC701 testBST = new LC701();
        TreeNode root = new TreeNode(5);
        root = testBST.insertIntoBST(root, 1);
        root = testBST.insertIntoBST(root, 7);
        root = testBST.insertIntoBST(root, 0);
        root = testBST.insertIntoBST(root, 3);
        root = testBST.insertIntoBST(root, 6);
        root = testBST.insertIntoBST(root, 8);

        System.out.println("Done");

    }

    private static void preorder(TreeNode root) {
        if (root == null) return;

        // process current node
        System.out.println(root.val + "->");
        // left subtree
        preorder(root.left);
        // right subtree
        preorder(root.right);
    }
        private static void inorder(TreeNode root){
            if (root == null) return;
            // L N R
            // left subtree
            inorder(root.left);
            // process root
            System.out.println(root.val+"->");
            // right subtree
            inorder(root.right);
        }
        private static void posorder(TreeNode root){
            if (root == null) return;
            // L R N
            // left subtree
            posorder(root.left);
            // right subtre
            posorder(root.right);
            // process root
            System.out.println(root.val+"->");
        }
}
