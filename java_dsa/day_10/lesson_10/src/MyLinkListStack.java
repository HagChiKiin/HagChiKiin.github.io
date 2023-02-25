import java.util.Stack;

public class MyLinkListStack {
    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    static Node head ;
    static int size;
    public static void push(int val){
        // add at head
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode; // cập nhật lại head
        size++;
    }
    public static int pop(){
        if(head == null){
            return -1;
        }
        int val = head.val;
       head = head.next;
       size--;
       return val;

    }
    public static int peek(){
        if(head==null)return -1;
        return head.val;
    }
    public static boolean isEmpty(){
        return head == null;
    }

    public static void main(String[] args) {
//        push(0);
//        push(1);
//        push(2);
//        push(3);
//        push(4);
//        System.out.println(peek());
//        System.out.println(pop());
//        System.out.println(peek());
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());

    }
}
