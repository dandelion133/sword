package com.swordoffer;

public class T37 {

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		
		int length1 = getListLength(pHead1);
		int length2 = getListLength(pHead2);
		ListNode longNode = null;
		ListNode shortNode = null;
		int lengthDif = 0;
		if(length1 > length2) {
			lengthDif = length1 - length2;
			longNode = pHead1;
			shortNode = pHead2;
		} else {
			lengthDif = length2 - length1;
			longNode = pHead2;
			shortNode = pHead1;
		}
				
		for (int i = 0; i < lengthDif; i++) {
			longNode = longNode.next;
		}
		
		while(longNode != null && shortNode != null && longNode != shortNode) {
			longNode = longNode.next;
			shortNode = shortNode.next;
		}
		
		
		return shortNode;
		
		

	}
	
	public int getListLength(ListNode pHead) {
		int length = 0;
		ListNode node = pHead;
		
		while(node != null) {
			node = node.next;
			length ++;
		}
		return length;
		
	}
	
	
	

	private class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
