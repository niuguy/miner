/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public void swapItem(ArrayList<Integer> nums, int i, int j) {
		Integer tmp = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, tmp);
	}
	public void swapList(ArrayList<Integer> nums, int i, int j) {
		while ( i < j) {
			swapItem(nums, i, j);
			i ++; j --;
		}
	}
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		int len = nums.size();
		if ( len <= 1)
			return nums;
		int i = len - 1;
		while ( i > 0 && nums.get(i) >= nums.get(i-1) )
			i --;
		swapList(nums, i, len - 1);     
		if ( i != 0) {
			int j = i;
			while ( nums.get(j) >= nums.get(i-1) ) j++;
			swapItem(nums, j, i-1);
		}
		
		return nums;
    }
}

