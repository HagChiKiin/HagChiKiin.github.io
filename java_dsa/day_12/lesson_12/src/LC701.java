public class LC701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root == null){
            root = newNode;
            return  root;
        }
        // root != null
        // tim vi tri de add newNode vao
        TreeNode current = root;
        while (true){
            // neus val > root
            // xet subtre ben phải
            if(val > current.val){
                // xet subtree ben phai
                // neu subtree ben phai la null
                if(current.right == null){
                    current.right = newNode;
                    break;
                }else {
                    current = current.right; // di chuyen xuong subtree ben phai
                }
            }else {
                if(current.left == null){
                    current.left = newNode;
                    break;
                }else {
                    current = current.left; // di chuyen xuong subtree ben trai
                }
            }
        }
        return root;
    }
}
