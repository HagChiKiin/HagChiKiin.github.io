public class MyLinkedListQueue {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static int size;
    static Node head;
    static Node tail;

    public static int getSize() {
        return size;
        // return size ò Queue  :so luong phan tu
    }

    public static int getFirst() {
        // return the first element in queue  : phan tu dau tien
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    public static int removeFirst() {
        // remove the first elenment and return
        // have only element -> head == tail
        // remove head -> head = null
        // tail -> null
        int val = -1;
        if (head == null) {
            return -1;
        }
        if (head == tail) {  // chir 1 phan tu
            val = head.val;
            head = head.next;
            tail = tail.next;
        } else {
            val = head.val;
            head = head.next;  // nhieu hon 1phan tu
        }
        size--;
        return val;
    }

    public static void push(int val) {
        // add a new element into queue
        // head= null , tail = null
        // head = tail = newNode
        // tail.next = newNode
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }
    public static boolean isEmpty() {
        return head == null;
    }
    private static void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        push(0);
        push(1);
        push(2);
        push(3);
        push(4);
        print(head);
        System.out.println("remove First: " + removeFirst());
        System.out.println("size: " + getSize());
        print(head);
        System.out.println("remove First: " + removeFirst());
        System.out.println("size: " + getSize());
        print(head);
        System.out.println("remove First: " + removeFirst());
        System.out.println("size: " + getSize());
        print(head);
        System.out.println("remove First: " + removeFirst());
        System.out.println("size: " + getSize());
        print(head);
        System.out.println("remove First: " + removeFirst());
        System.out.println("size: " + getSize());
        print(head);
        System.out.println("remove First: " + removeFirst());
        System.out.println("size: " + getSize());
        print(head);
    }
}
