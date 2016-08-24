package com.swordoffer.chapter6;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * ����������˼·�� 1��ֱ�Ӳ������У�֮�������ѳߴ�֮�����1(Ҳ����2)����Ӵ���е����Ѷ�Ԫ�ز����뵽С����
 * ������֮�����1����ֱ�Ӳ������м��ɡ� 2�������������뵽����У�ż���������뵽С���У� ����
 * ���ܻ���ֵ�ǰ�����������С�ѶѶ�Ԫ�ش󣬴�ʱ��Ҫ��Ԫ���Ȳ��뵽С�ѣ�Ȼ��С�ѶѶ�Ԫ�ص��������뵽����� ����ż��ʱ����С�ѵ������һ���ĵ���why?
 * ��ΪҪ��֤���ѵ�Ԫ��Ҫ����С�ѵ�Ԫ�ض�ҪС��
 * 
 * @param num
 *
 * @author QHF
 *
 */
public class T64 {
	
	int count;//�����Ԫ�صĸ���
	
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(100,new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1);
		}
		
	});
	//ArrayDeque
	
	
	public void Insert(Integer num) {
		if((count & 1) == 0) { //ż��   ������С��
			if(!maxHeap.isEmpty() && num < maxHeap.peek()) {
				maxHeap.offer(num);
				num = maxHeap.poll();
			}
			minHeap.offer(num);
			
		} else { //����  ��������
			if(!minHeap.isEmpty() && num > minHeap.peek()) {
				minHeap.offer(num);
				num = minHeap.poll();
			}
			maxHeap.offer(num);
			
		}
	}

	public Double GetMedian() {
		
		if(count == 0) {
			return null;
		}
		double rst;
		
		if((count & 1) == 0) { //ż��   
			rst = (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			rst = minHeap.peek();
		}
		
		return rst;

	}
}
