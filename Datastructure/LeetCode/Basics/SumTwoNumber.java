public class SumTwoNumber {

    // Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Add two numbers
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(sum % 10);

            current = current.next;

            carry = sum / 10;
        }

        return dummyNode.next;
    }

    // Print Linked List
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // 342
        ListNode l1 = new ListNode(
            2,
            new ListNode(
                4,
                new ListNode(3)
            )
        );

        // 465
        ListNode l2 = new ListNode(
            5,
            new ListNode(
                6,
                new ListNode(4)
            )
        );

        ListNode result = addTwoNumbers(l1, l2);

        // Output: 7 -> 0 -> 8
        printList(result);
    }
}