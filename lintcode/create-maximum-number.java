/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {
    /**
     * @param nums1 an integer array of length m with digits 0-9
     * @param nums2 an integer array of length n with digits 0-9
     * @param k an integer and k <= m + n
     * @return an integer array
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // Write your code here
        if (k == 0)
            return new int[0];

        int m = nums1.length, n = nums2.length;
        if (m + n < k) return null;
        if (m + n == k) {
            int[] results = merge(nums1, nums2, k);
            return results;
        } else {
            int max = m >= k ? k : m;
            int min = n >= k ? 0 : k - n;

            int[] results = new int[k];
            for(int i=0; i < k; ++i)
                results[i] = -0x7ffffff;
            for(int i = min; i <= max; ++i) {
                int[] temp = merge(getMax(nums1, i), getMax(nums2, k - i), k);
                results = isGreater(results, 0, temp, 0) ? results : temp;
            }
            return results;
        }
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] results = new int[k];
        if (k == 0) return results;
        int i = 0, j = 0;
        for(int l = 0; l < k; ++l) {
            results[l] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return results;
    }

    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        for(; i < nums1.length && j < nums2.length; ++i, ++j) {
            if (nums1[i] > nums2[j])
                return true;
            if (nums1[i] < nums2[j])
                return false;
        }
        return i != nums1.length;
    }

    private int[] getMax(int[] nums, int k) {
        if (k == 0)
            return new int[0];
        int[] results = new int[k];
        int i = 0;
        for(int j = 0; j < nums.length; ++j) {
            while(nums.length - j + i > k && i > 0 && results[i-1] < nums[j])
                i--;
            if (i < k)
                results[i++] = nums[j];
        }
        return results;
    }
}
