package com.swordoffer;



public class T10 {
    public static ListNode Merge(ListNode list1,ListNode list2) {
    	ListNode root = null;
    	ListNode current1 = list1;
    	ListNode current2 = list2;
    	ListNode head = new ListNode(0);
    	if(list1 == null && list2 == null) {
            return null;
        } else if(list1 == null) {
            return list2;
        } else if(list2 == null) {
            return list1;
        }
    	if(list1.val <= list2.val) {
    		root = list1;
    	//	head = list1;
    	} else {
    		root = list2;
    	// = list2;
    	}
    	
    	while(current1 != null && current2 != null) {
    		if(current1.val <= current2.val) {
    			head.next = current1;
    			head = head.next;
    			current1 = current1.next;
    		} else {
    			head.next = current2;
    			head = head.next;
    			current2 = current2.next;
    		}
    	}
    	
    	if(current1 != null && current2 == null) {
    		head.next = current1;
    	} else if(current2 != null && current1 == null) {
    		head.next = current2;
    	}
    	
    	
    	return root;
        
    }
    
    public static void main(String[] args) {
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		node0.next = node2;
		node1.next = node3;
		node2.next = node4;
		node3.next = node5;
		node4.next = node6;
		node5.next = node7;
		node6.next = node8;
		ListNode merge = Merge(node0, node1);
		
		while(merge != null) {
			System.out.print(merge.val + ",");
			
			merge = merge.next;
		}
		
		
		
	}
    
    
}
