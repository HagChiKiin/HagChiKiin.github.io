import java.util.Stack;

public class Lc155 {
    class MinStack {
        Stack<Node> stack = new Stack<>();

        static class Node {
            int val;
            int min;

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        public MinStack() {
        }

        public void push(int val) {
            if (stack.isEmpty()) {   // nếu stack rỗng thì thêm vào phần tử có giá trị val và min la val
                stack.push(new Node(val, val));
            } else {  //  lấy min của phần tử trên cùng stack so sánh vs val
                int currMin = stack.peek().min;
                stack.push(new Node(val, Math.min(val, currMin))); // thêm vào stack phần tử có giá trị val và min (val ss currmin)
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }
}
