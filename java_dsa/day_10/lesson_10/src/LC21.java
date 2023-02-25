import java.util.Stack;

public class LC21 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') { // nếu kí tự l mở ngoặc thì thêm vào stack
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') { //  nếu là ký tự đóng ngoặc thì
                stack.pop();    // kiểm tra rỗng và kiểm tra phần tử đầu tiên có phải mở ngoặc ko. Nếu có thì loại bỏ ký tự mo ngoặc ơ top
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {   // tra về false nếu ký tự đó không phải là một ký tự mở hoặc đóng ngoặc,
                return false;
            }
        }
        return stack.isEmpty(); // Nếu stack rỗng, chuỗi hợp lệ và ta trả về giá trị true.
        // Nếu không, chuỗi không hợp lệ và ta trả về giá trị false.
    }

    public static void main(String[] args) {
        System.out.println(isValid("[]{}"));
    }
}
