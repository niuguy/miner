/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        int len = A.size();
        ArrayList<Long> B = new  ArrayList<Long>();
        long[] f = new long[len];

        long tmp = 1;
        long now = 1;
        f[len-1] = A.get(len-1);
        int i ;
        for ( i = len-2; i >= 0; --i)
        {
            f[i] = A.get(i);
            f[i] = f[i] * f[i+1];
        }

        for ( i = 0; i < len; ++i) {
			
            now = tmp;
            if(i+1<len)
                B.add( now * f[i+1] );
            else
                B.add( now );
            now = A.get(i);
            tmp = tmp * now;

        }
        return B;
    }
}