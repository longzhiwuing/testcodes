package com.lzwing.testcode.audition.leetcode.addTwoNum;

@SuppressWarnings("AlibabaRemoveCommentedCode")
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode tmp = l1;
        int lenl1 = 0;
        while (tmp != null) {
            lenl1++;
            tmp = tmp.next;
        }

        tmp = l2;
        int lenl2 = 0;
        while (tmp != null) {
            lenl2++;
            tmp = tmp.next;
        }

        tmp = l1;
        int[] arrl1 = new int[lenl1];
        for (int i = 0; i < lenl1; i++) {
            arrl1[i] = tmp.val;
            tmp = tmp.next;
        }

        tmp = l2;
        int[] arrl2 = new int[lenl2];
        for (int i = 0; i < lenl2; i++) {
            arrl2[i] = tmp.val;
            tmp = tmp.next;
        }

        int maxlen = lenl1 > lenl2 ? lenl1 : lenl2;

        ListNode head = new ListNode(0);
        ListNode curr = head;
        boolean isOver10 = false;
        for (int i = 0; i < maxlen; i++) {
            int result = 0;
            int sum = 0;
            if (i < lenl1 && i < lenl2) {
                int v1 = arrl1[i];
                int v2 = arrl2[i];
                if (isOver10) {
                    sum = v1 + v2 + 1;
                } else {
                    sum = v1 + v2;
                }
            }

            if (i >= lenl1) {
                int v2 = arrl2[i];
                if (isOver10) {
                    sum = v2+1;
                }else{
                    sum = v2;
                }
            }

            if (i >= lenl2) {
                int v1 = arrl1[i];
                if (isOver10) {
                    sum = v1+1;
                }else{
                    sum = v1;
                }
            }
            isOver10 = sum >= 10;
            result = sum % 10;

            curr.next = new ListNode(result);
            curr = curr.next;
        }

        if (isOver10) {
            curr.next = new ListNode(1);
        }

        return head.next;

    }

    public static void main(String[] args) {

          /*String input1 = "[2,4,3]";
          String input2 = "[5,6,4]";*/

        /*String input1 = "[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]";
        String input2 = "[5,6,4]";*/

        /*String input1 = "[9,8]";
        String input2 = "[1]";*/

        String input1 = "[9,9,9,9,9,9]";
        String input2 = "[1]";

        ListNode l1 = getListNode(input1);
        ListNode l2 = getListNode(input2);

        ListNode result = new Solution().addTwoNumbers(l1, l2);

        show(result);

    }

    private static ListNode getListNode(String input) {
        String dataStr = input.substring(1, input.length() - 1);
        String[] data = dataStr.split(",");
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for(int i=0;i<data.length;i++) {
            curr.next = new ListNode(Integer.parseInt(data[i]));
            curr = curr.next;
        }
        return head.next;
    }

    public static void show(ListNode node) {
        while (node != null) {
            System.out.print(node.val+"->");
            node = node.next;
        }
    }
}