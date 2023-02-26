import java.util.Stack;

public class Lc155 {
    class MinStack {
        static Stack<Node> stack = new Stack<>();

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

        public static void push(int val) {
            if (stack.isEmpty()) {   // nếu stack rỗng thì thêm vào phần tử có giá trị val và min la val
                stack.push(new Node(val, val));
            } else {  //  lấy min của phần tử trên cùng stack so sánh vs val
                int currMin = stack.peek().min;
                stack.push(new Node(val, Math.min(val, currMin))); // thêm vào stack phần tử có giá trị val và min (val ss currmin)
            }
        }

        public static void pop() {
            stack.pop();
        }

        public static int top() {
            return stack.peek().val;
        }

        public static int getMin() {
            return stack.peek().min;
        }
    }
}
