package com.swordoffer.chapter6;

public class T58 {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {

		if (pNode == null)
			return null;

		TreeLinkNode pNext = null;
		// 如果一个节点有右子树 那么它的下一个节点就是它的右子树的左子节点
		if (pNode.right != null) { //
			System.out.println("11111111");
			TreeLinkNode pRight = pNode.right;
			while (pRight.left != null) {
				pRight = pRight.left;

			}
			pNext = pRight;

		} else if (pNode.next != null) { // 没有右子树
			if (pNode.next.left != null && pNode.next.left == pNode) { // 父节点的左子节点
				System.out.println("222222222222");
				pNext = pNode.next;
			} else if (pNode.next.right != null && pNode.next.right == pNode) { // 父节点的右子节点
				System.out.println("33333333333");
				while (pNode.next != null && pNode.next.left != pNode && pNode.next != null) {
					pNode = pNode.next;
				}
				if (pNode.next != null)
					if (pNode.next.left == pNode)
						pNext = pNode.next;
			}
		}

		return pNext;

	}

	public static void main(String[] args) {
		T58 t58 = new T58();
		TreeLinkNode node0 = new TreeLinkNode(0);
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		TreeLinkNode node7 = new TreeLinkNode(7);
		TreeLinkNode node8 = new TreeLinkNode(8);

		node0.left = node1;
		node0.right = node2;

		node1.next = node0;
		node1.left = node3;
		node1.right = node4;

		node2.next = node0;
		node2.left = node5;
		node2.right = node6;

		node3.next = node1;
		node3.left = null;

		node4.next = node1;
		node4.left = node7;
		node4.right = node8;

		node5.next = node2;
		node6.next = node2;

		node7.next = node4;
		node8.next = node4;

		TreeLinkNode getNext = t58.GetNext(node6);

		System.out.println(getNext);

	}

}
