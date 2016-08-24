package com.swordoffer.chapter6;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * 插入有两种思路： 1：直接插入大堆中，之后若两堆尺寸之差大于1(也就是2)，则从大堆中弹出堆顶元素并插入到小堆中
 * 若两队之差不大于1，则直接插入大堆中即可。 2：奇数个数插入到大堆中，偶数个数插入到小堆中， 但是
 * 可能会出现当前待插入的数比小堆堆顶元素大，此时需要将元素先插入到小堆，然后将小堆堆顶元素弹出并插入到大堆中 对于偶数时插入小堆的情况，一样的道理。why?
 * 因为要保证最大堆的元素要比最小堆的元素都要小。
 * 
 * @param num
 *
 * @author QHF
 *
 */
public class T64 {
	
	int count;//插入的元素的个数
	
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
		if((count & 1) == 0) { //偶数   插入最小堆
			if(!maxHeap.isEmpty() && num < maxHeap.peek()) {
				maxHeap.offer(num);
				num = maxHeap.poll();
			}
			minHeap.offer(num);
			
		} else { //奇数  插入最大堆
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
		
		if((count & 1) == 0) { //偶数   
			rst = (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			rst = minHeap.peek();
		}
		
		return rst;

	}
}
