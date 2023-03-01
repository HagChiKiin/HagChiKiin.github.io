public class LC112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return check(root,0,targetSum);

    }
    public static boolean isleaf(TreeNode node){  // phuong thuc kiem tra nut la
        return node.left == null && node.right == null;
    }
    public boolean check(TreeNode current, int sum, int targetSum){
        // dieu kien dung
        if(current == null ) return false;
        sum = sum + current.val;   //
        if(isleaf(current)){     // neu curr la nut la thi return luon sum = target
            return sum == targetSum;
        }
        boolean resLeft = check(current.left,sum,targetSum);   // neu khong thi check tiep nut ben trai va phai
        boolean resRight = check(current.right,sum,targetSum);
        return  resRight || resLeft;

    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
