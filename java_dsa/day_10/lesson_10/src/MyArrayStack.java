public class MyArrayStack {
    static int[]arr;
    static int top = -1;
    public static void push(int val){
        arr[++top] = val;
    }
    public static int pop(){  // poor của queue == removeFirst
        if(top == -1){
            return -1;
        }
        int val = arr[top];
        top--;
        return val;
    }
    public static int peek(){
        return arr[top];
    }
    public static int size(){
        return top+1;
    }
    public static boolean isEmpty(){
        return top == -1;
    }

    public static void main(String[] args) {
        arr= new int[100];
        push(1);
        push(2);
        push(3);
        push(4);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());

    }
}
