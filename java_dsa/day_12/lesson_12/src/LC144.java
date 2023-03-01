import java.util.ArrayList;
import java.util.List;

public class LC144 {
    List<Integer> list = new ArrayList<>() ;
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return list;
        // process current node
        list.add(root.val);
        // left subtree
        preorderTraversal(root.left);
        // right subtree
        preorderTraversal(root.right);
        return list;
    }
}
