package com.swordoffer.chapter6;

public class T56 {
	
public ListNode meetingNode(ListNode node) {
		
		if(node == null)
			return null;
		ListNode pSlow = node.next;
		if(pSlow == null) 
			return null;
		
		ListNode pFast = pSlow.next;
		
		while(pFast != null && pSlow != null) {
			if(pFast == pSlow) {
				return pFast;
			}
			pSlow = pSlow.next;
			pFast = pFast.next;
			if(pFast != null) 
				pFast = pFast.next;
		}
		
		
		return null;
		
		
	}
	
	
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		
		ListNode meetNode = meetingNode(pHead);
		System.out.println("====" + meetNode.val);
		if(meetNode == null) 
			return null;
		//求出环中节点数量
		
		int numLoop = 1;
		ListNode p = meetNode; 
		while(p.next != meetNode) {
			p = p.next;
			numLoop ++;
			//System.out.println(numLoop);
		}
		System.out.println("====");
		//p1先前行n步
		ListNode p1 = pHead;
		
		for (int i = 0; i < numLoop; i++) {
			p1 = p1.next;
		}
		ListNode p2 = pHead;
		while(p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;

	}
	public static void main(String[] args) {
		T56 t56 = new T56();
		
		ListNode node1 = new ListNode(1); 
		ListNode node2 = new ListNode(2); 
		ListNode node3 = new ListNode(3); 
		ListNode node4 = new ListNode(4); 
		ListNode node5 = new ListNode(5); 
		ListNode node6 = new ListNode(6); 
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node3;
		
		
		ListNode node = node1;
		/*int i = 0;
		while(i < 9) {
			i ++;
			System.out.print(node.next.val + ",");;
		}*/
		System.out.println(t56.EntryNodeOfLoop(node1).val);
		
		
	}
}
