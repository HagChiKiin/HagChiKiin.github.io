public class LC100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){   // p và q = rỗng tra vê true
            return true;
        }
        if (p==null || q== null || p.val != q.val){ // hai cây không giống nhau hoặc giá trị nút khác nhau tra ve false
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right); // tiep tuc de quy cho cay con ben trai va phai
        // neu tat ca nut cay con ben trai p giong cay con ben trai q va tuong tu ben phai thi tra ve true
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
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
