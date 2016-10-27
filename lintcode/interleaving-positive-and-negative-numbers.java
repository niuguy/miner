/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    int[] subfun(int[] A,int [] B, int len) {
        int[] ans = new int[len];
        for(int i = 0; i * 2 + 1 < len; i++) {
            ans[i * 2] = A[i];
            ans[i * 2 + 1] = B[i];
            }
        if(len % 2 == 1)
            ans[len - 1] = A[len / 2];
        return ans;
    }
    public void rerange(int[] A) {
        int[] Ap = new int[A.length];
        int totp = 0;
        int totm = 0;
        int[] Am = new int[A.length];
        int[] tmp = new int[A.length];
        for(int i = 0; i < A.length; i++)
            if(A[i] > 0)
                {
                    Ap[totp] = A[i];
                    totp += 1;
                }
            else
                {
                    Am[totm] = A[i];
                    totm += 1;  
                }   
        if(totp > totm)
            tmp = subfun(Ap, Am, A.length);
        else
            tmp = subfun(Am, Ap, A.length);
        for (int i = 0; i < tmp.length; ++i)
            A[i] = tmp[i];
    }
}