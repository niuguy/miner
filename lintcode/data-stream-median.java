/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    private PriorityQueue<Integer> maxHeap, minHeap;
	private int numOfElements = 0;

	public int[] medianII(int[] nums) {
        // write your code here
		Comparator<Integer> revCmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer left, Integer right) {
				return right.compareTo(left);
			}
		};
        int cnt = nums.length;
		maxHeap = new PriorityQueue<Integer>(cnt, revCmp);
		minHeap = new PriorityQueue<Integer>(cnt);
        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; ++i) {
		    addNumber(nums[i]);   
		    ans[i] = getMedian();
		}
        return ans;
	}
	void addNumber(int value) {
		maxHeap.add(value);
		if (numOfElements%2 == 0) {
			if (minHeap.isEmpty()) {
				numOfElements++;
				return;
			}
			else if (maxHeap.peek() > minHeap.peek()) {
				Integer maxHeapRoot = maxHeap.poll();
				Integer minHeapRoot = minHeap.poll();
				maxHeap.add(minHeapRoot);
				minHeap.add(maxHeapRoot);
			} 
		} 
		else {
			minHeap.add(maxHeap.poll());
		}
		numOfElements++;
	}
	int getMedian() {
		return maxHeap.peek();
	}
}
