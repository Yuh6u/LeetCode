class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode result = new ListNode();
        ListNode current = result;
        ListNode prev = null;
        int sum;
        while (true){
            int a = 0, b = 0;
            if (l1 != null){
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                b = l2.val;
                l2 = l2.next;
            }
            sum = a + b + (carry ? 1 : 0);
            if (sum == 0 && l1 == null && l2 == null)
                return result;
            if (current == null)
                current = prev.next = new ListNode();
            carry = sum > 9;
            if (carry)
                current.val = sum - 10;
            else
                current.val = sum;
            prev = current;
            current = current.next;
        }
    }
}
