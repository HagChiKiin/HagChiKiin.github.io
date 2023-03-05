public class Lc98 {
    public boolean isValidBST(TreeNode root) {
        return isSubtree(root, null, null);
    }

    public boolean isSubtree(TreeNode root, Integer min, Integer max) {  //min: gtri nho nhat trong cay, maX: lon nhat
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min || max != null && root.val >= max) { // neu root nho hon mid hoac max nho hon root ->false
            return false;
        }
        return isSubtree(root.left, min, root.val) && isSubtree(root.right, root.val, max);
        // đệ quy với cây con bên trái  và cây con bên phải
        // subtree trai min = min va max = root,,
        // subtree phai min = root va max = max

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSubtree1(TreeNode root, long min, long max) {  //min: gtri nho nhat trong cay, maX: lon nhat
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) { // neu root nho hon mid hoac max nho hon root ->false
            return false;
        }
        return isSubtree(root.left, (int) min, root.val) && isSubtree(root.right, root.val, (int) max);

    }
}
