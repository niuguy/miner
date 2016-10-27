/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        if (str == null || str.length() < 1)
		return 0;
        
	    // trim white spaces
	    str = str.trim();
 
	    char flag = '+';
 
	    // check negative or positive
	    int i = 0;
	    if (str.charAt(0) == '-') {
		    flag = '-';
		    i++;
	    } else if (str.charAt(0) == '+') {
		    i++;
	    }
	    // use double to store result
	    double result = 0;
    
	    // calculate value
	    while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
		    result = result * 10 + (str.charAt(i) - '0');
		    i++;
	    }
 
	    if (flag == '-')
		    result = -result;
 
	    // handle max and min
	    if (result > Integer.MAX_VALUE)
		    return Integer.MAX_VALUE;
 
	    if (result < Integer.MIN_VALUE)
		    return Integer.MIN_VALUE;
 
	    return (int) result;
    }
}
