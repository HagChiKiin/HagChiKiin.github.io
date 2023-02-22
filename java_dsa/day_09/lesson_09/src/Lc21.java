public class Lc21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode fakeNode = new ListNode(0); // Tạo node giả
        ListNode  current = fakeNode;  // con trỏ current trỏ toi node giả
        while (list1 != null && list2 != null) { // break vòng lặp khi 1 trong 2 vòng null
            if (list1.val < list2.val) {
                current.next = list1;// nếu giá trị list 1 < list 2 thì gán ta sẽ gán newList.next = list1,
                list1 = list1.next; // và di chuyển list1 đến phần tử kế tiếp của nó
            } else  {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1 == null){   // Nếu list nào còn phần tử, chèn phần tử còn lại vào cuối danh sách mới
            current.next= list2;
        }else {
            current.next=  list1;
        }
        return fakeNode.next;  // trả về node sau node giả

    }
    public class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

}
