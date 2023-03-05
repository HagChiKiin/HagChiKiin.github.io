import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();  // lay nut dau tien trong q va gan = curr
                level.add(curr.val);       // them gia tri cua curr
                if(curr.left!= null){    // neu curr co nut con trai thi them nut con trai
                    q.add(curr.left);
                }
                if(curr.right!= null){  // neu curr co nut con phai thi them nut con phai
                    q.add(curr.right);
                }
            }
            result.add(level);   // them level vao rsult
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
