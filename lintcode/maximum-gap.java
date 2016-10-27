/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        if (nums.length<2) return 0;
        int minNum = -1, maxNum = -1, n = nums.length;
        for (int i=0; i<n; ++i) {
            minNum = min(nums[i], minNum);
            maxNum = max(nums[i], maxNum);
        }
        if (maxNum==minNum) return 0;
        int average = (maxNum-minNum)/(n-1);
        if (average==0) ++average;
        int[] localMin = new int[n];
        int[] localMax = new int[n];
        for (int i=0; i<n; ++i) {
            localMin[i] = -1;
            localMax[i] = -1;
        }
        for (int i=0; i<n; ++i) {
            int t = (nums[i]-minNum)/average;
            localMin[t] = min(localMin[t], nums[i]);
            localMax[t] = max(localMax[t], nums[i]);
        }
        int ans = average, left = 0, right = 1;
        while (left<n-1) {
            while (right<n && localMin[right]==-1) ++right;
            if (right>=n) break;
            ans = max(ans, localMin[right]-localMax[left]);
            left = right;
            ++right;
        }
        return ans;
    }
    private int min(int a, int b) {
        if (a==-1) return b;
        else 
            if (b==-1) return a;
            else
                if (a<b) return a;
                else return b;
    }
    private int max(int a, int b) {
        if (a==-1) return b;
        else
            if (b==-1) return a;
            else
                if (a>b) return a;
                else return b;    
    }
}
