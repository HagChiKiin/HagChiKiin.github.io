public class Main {
    // int a = 5  - a: là kiểu dữ liệu nguyên thủy và có value
    // String str = new String(" hello") .. str tham chiếu ở bộ nhớ stack cấp phát địa chỉ thằng hello trong bo nhớ heap
    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);


        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        printList(n0); // 0 ->1 ->2 ->
        // how to find the elenment with index = 4   expect = n4 (val = 4)
//        System.out.println(elementAt(n0,7));
//        insert(n0,3,15);
//        printList(n0);
//        Node newlist  = insertAtHead(n0,9);
//        printList(newlist);
//        insertAtTail(n0,10);
        deletaAt(n0,2);
        printList(n0);

    }
    public static void insert(Node head, int index, int valOfNewNode){
        // tìm vị trí previous of index
        // Link newNode to nexNode
        // nối newNode với nextNode of previous
        Node newNode = new Node(valOfNewNode);
        Node curNode = head;
        int count = 0;
        while (curNode != null){
            if(count == index -1 ){
                newNode.next = curNode.next;
                curNode.next = newNode;
                break;
            }
            count++;
            curNode = curNode.next;
        }
    }
    private static Node insertAtHead(Node head, int val){
        Node newNode = new Node(val);
        if(head == null){
            return newNode;
        }
        newNode.next = head;
        return newNode;
    }
    private static Node insertAtTail(Node head, int val){
        Node newNode = new Node(val);
        Node lastNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        return newNode;
    }

    private static int elementAt(Node head, int index){
        Node cur = head;
        int count = 0;
        while (cur != null ){
            count++;
            cur = cur.next;
            if(count == index){
               return cur.val;
            }
        }
        return -1;
    }
    private static void printList(Node head){
        Node current = head; // cur trỏ đến node đang được xét -  curren poin to the head of list
        while (current != null){
            // process curren node
            System.out.print(current.val+"->");
            //// process curren node complete

            // move to nex node
            current = current.next;
        }
    }
    private static void deletaAt(Node head, int index){
        Node current = head;
        int count = 0;
        while (current !=null){
            if(count == index -1){
                current.next = current.next.next;
                break;
            }
            count++;
            current = current.next;
        }
    }
    private static void deletaAtHead(Node head, int index){

    }

    static class Node{
        public int val;
        public Node next;

        Node(int val){
            this.val = val;
        }
    }
}
