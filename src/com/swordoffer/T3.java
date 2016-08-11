package com.swordoffer;

import java.util.ArrayList;
import java.util.Collections;

public class T3 {
	public static void main(String[] args) {
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
		
		ArrayList<Integer> list = printListFromTailToHead(node0);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		
	}
	
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ListNode current = listNode;
		ArrayList<Integer> integers = new ArrayList<Integer>();
		
		if(current == null) {
			return null;
		}
		while(current.next != null) {
			integers.add(current.val);
			current = current.next;
		}
		
		integers.add(current.val);	
		Collections.reverse(integers);  
		return integers;
		
	}
}

class ListNode {
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
}
