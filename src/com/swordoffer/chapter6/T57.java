package com.swordoffer.chapter6;

public class T57 {
	public ListNode deleteDuplication(ListNode pHead) {
		
		if(pHead == null) return null;
		
		ListNode pPreNode = null;
		ListNode pCurrNode = pHead;
		while(pCurrNode != null) {
			ListNode pNext = pCurrNode.next;
			boolean isDelet = false;
			if(pNext != null && pNext.val == pCurrNode.val) {
				isDelet = true;
			}
			
			if(isDelet) {
				
				int value = pCurrNode.val;
				ListNode toBeDelNode = pCurrNode;
				while(toBeDelNode != null && toBeDelNode.val == value) {
					pNext = toBeDelNode.next;
					toBeDelNode = null;
					
					toBeDelNode = pNext;
				}
				
				if(pPreNode == null) { //头结点被删除
				//	pPreNode = pNext;
					pHead = pNext;
				} else {
					pPreNode.next = pNext;
				}
				
				pCurrNode = pNext;
				
				
			} else {
				pPreNode = pCurrNode;
				pCurrNode = pCurrNode.next;
			}
		}
		
		
		
		return pHead;

	}
	
	
	public static void main(String[] args) {
		
		T57 t57 = new T57();
		ListNode node1 = new ListNode(2); 
		ListNode node2 = new ListNode(2); 
		ListNode node3 = new ListNode(3); 
		ListNode node4 = new ListNode(3); 
		ListNode node5 = new ListNode(4); 
		ListNode node6 = new ListNode(4); 
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		
		
		ListNode node = t57.deleteDuplication(node1);
		
		while(node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
		
		
	}
}
