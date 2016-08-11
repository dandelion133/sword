package com.swordoffer;

public class T9 {
	public ListNode FindKthToTail(ListNode head,int k) {
		ListNode head1 = head;
		int sum = getNodeCount(head1);
		if(sum < k) {
			return null;
		}
		int i = sum - k;
		while(i != 0) {
			head = head.next;
			i --;
		}
		return head;
		
    }
	public int getNodeCount(ListNode head) {
		int sum = 0;
		if(head == null) {
			return 0;
		}
		if(head != null) {
			sum = 1;
		}
		while(head.next != null) {
			head = head.next;
			sum ++;
		}
		return sum;
		
	}
	
	
	
	public static void main(String[] args) {
		T9 t9 = new T9();
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		;
		System.out.println(t9.FindKthToTail(node0, 2).val);
	}
}
