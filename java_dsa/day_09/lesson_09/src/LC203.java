import java.util.List;

public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        while(head != null && head.val== val){       // nếu head là giá trị val thì trả về thằng sau head
            head= head.next;
        }
        while (current!=null && current.next !=null ){ // nếu current.next và cur là null thì break vòng lặp
            if(current.next.val==val){      // nếu gia tri sau current bằng val thì trả về gia tri ke tiep node bị xóa
                current.next = current.next.next;
            }else{
                current = current.next;
            }

        }
        return head;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
