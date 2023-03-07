public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;   // con trỏ pa trỏ vào linklist A
        ListNode pB = headB;    // con trỏ pB  trỏ vào linklist B
        while (pA != pB) {   // lặp khi nào pA = pB  -> trỏ vào 1 phần tử pA hoặc pB
            if (pA != null) {  // nếu pA khac null- chua tro den cuoi mang thi tiep tuc duyet
                pA = pA.next;
            } else {       // pA bang null thi tro pa vao headB
                pA = headB;
            }
            if (pB != null) {
                pB = pB.next;
            } else {
                pB = headA;
            }
        }
        return pA;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
