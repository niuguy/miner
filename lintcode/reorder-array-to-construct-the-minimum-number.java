/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        // Write your code here
        int n = nums.length;
        if (n < 1) return "";
        
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, new Cmp());
        
        String ans = "";
        for (int i = n - 1; i >= 0; i--) {
        	ans = ans.concat(strs[i]);
        }
        
        int i = 0;
        while (i < n && ans.charAt(i) == '0')
            i ++;

        if (i == n) return "0";
        return ans.substring(i);
    }
}
class Cmp implements Comparator<String>{
	@Override
	public int compare(String a, String b) {
		String ab = a.concat(b);
		String ba = b.concat(a);
		return ba.compareTo(ab);
	}
}
