class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        int i = 0;

        ListNode p = head;
        while (p != null) {
            i++;
            if (i % k == 0) {
                prev = reverse(prev, p.next);
                p = prev.next;
            } else {
                p = p.next;
            }
        }

        return fake.next;
    }

    public ListNode reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = last.next;

        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }

        return last;
    }
}

class ListNode {
    int val;

    ListNode(int val) {
        this.val = val;
    }

    ListNode next = null;
}