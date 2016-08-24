package com.swordoffer;

public class T26 {
	public static void main(String[] args) {

	}

	public RandomListNode Clone(RandomListNode pHead) {
		
		
		cloneNodes(pHead);
		connectRandomNodes(pHead);
		return reConnectNodes(pHead);
		
		
		

	}

	private RandomListNode reConnectNodes(RandomListNode pHead) {
		
		RandomListNode pNode = pHead;
		RandomListNode pCloneHead = null;
		RandomListNode pCloneNode = null;
		
		if(pNode != null) {
			pCloneHead = pCloneNode = pNode.next;
			pNode.next = pCloneNode.next;
			pNode = pNode.next;
		}
		while(pNode != null) {
			pCloneNode.next = pNode.next;
			pCloneNode = pCloneNode.next;
			pNode.next = pCloneNode.next;
			pNode = pNode.next;
		}
		
		return pCloneHead;
		
	}

	private void connectRandomNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		while(pNode != null) {
			RandomListNode pClone = pNode.next;
			if(pNode.random != null) {
				pClone.random = pNode.random.next;
			}
			pNode = pClone.next;
		}
		
	}

	private void cloneNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		
		while(pNode != null) {
			RandomListNode pClone = new RandomListNode(pNode.label);
			pClone.next = pNode.next;
			pNode.next = pClone;
			
			pClone.random = null;
			
			pNode = pClone.next;
			
		}
	}

}

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}