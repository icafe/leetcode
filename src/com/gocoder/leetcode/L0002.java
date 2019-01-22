package com.gocoder.leetcode;

/**
 * 两数相加
 *
 * <p>#002 https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author gocoder
 */
public class L0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode n1 = l1, n2 = l2, t = node;
        int sum = 0;

        while (n1 != null || n2 != null) {
            sum /= 10;
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }

            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }
            t.next = new ListNode(sum % 10);
            t = t.next;
        }
        if (sum / 10 != 0) {
            t.next = new ListNode(1);
        }
        return node.next;
    }

    public static void main(String[] args) {
        L0002 solution = new L0002();
        solution.print(
                solution.addTwoNumbers(
                        solution.buildListNode(new int[]{1, 2, 3}),
                        solution.buildListNode(new int[]{1})
                )
        );
    }

    private ListNode buildListNode(int[] array) {
        int len = array.length;
        ListNode node = new ListNode(array[0]);
        ListNode t = node;
        for (int i = 1; i < len; i++) {
            t.next = new ListNode(array[i]);
            t = t.next;
        }
        return node;
    }

    private void print(ListNode node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder("[").append(node.val);
        ListNode p = node.next;
        while (p != null) {
            sb.append(",").append(p.val);
            p = p.next;
        }
        System.out.println(sb.append("]"));
    }

    class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
