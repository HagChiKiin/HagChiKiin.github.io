public class MyLinkedList {
    int size;
    Node head;
    public MyLinkedList() {

    }

    public int get(int index) {
        if(size<=index)return -1;
        Node cur = head;
        int count = 0;
        while (cur != null ){
            if(count == index){
                return cur.val;
            }
            count++;
            cur = cur.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
       Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
       if(head==null){
           head = newNode;
       }else {
           Node current = head;
           while (current.next != null){
               current = current.next;
           }
           current.next = newNode;
       }
       size++;
    }


    public void addAtIndex(int index, int val) {
        if(index==0){
            addAtHead(val);
        } else if (index== size) {
            addAtTail(val);
        } else if (index < size) {
            Node current = head;
            int count = 0;
            while (current!=null){
                if(count == index-1){
                    Node newNode = new Node(val);
                    newNode.next = current.next;
                    current.next = newNode;
                }
                count++;
                current = current.next;
            }
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index==0){
            head = head.next;
            size--;
        } else if (index < size) {
            Node current = head;
            int count = 0;
            while (current!=null){
                if(count == index-1){
                    current.next = current.next.next;
                    break;
                }
                count++;
                current = current.next;
            }
            size--;
        }
    }
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
}
