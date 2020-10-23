package com.gh.question.test.test1;

import java.util.List;

public class Test3 {
    public ListNode middleNode(ListNode head) {
        // write your code here
        ListNode mid = new ListNode(0);
        mid.next = head;
        int size = 0;
        while(head.next !=null){
            size ++;
            head = head.next;
            if(size/2==1){
                mid = mid.next;
            }
        }
        return mid;
    }
}


   class ListNode {
     int val;
     ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

