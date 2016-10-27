/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        int x, y, dx, dy, count, m, n;
        x = y = 0;
        count = 1;
        dx = -1; dy = 1;
        m = matrix.length;
        n = matrix[0].length;
        int[] z = new int[m*n];
        z[0] = matrix[0][0];
        while (count<m*n) {
            if (x+dx>=0 && y+dy>=0 && x+dx<m && y+dy<n) {
                x += dx; y += dy;
            }
            else
                if (dx==-1 && dy ==1) {
                    if (y+1<n) ++y; else ++x;
                    dx = 1; dy = -1;
                }
                else {
                    if (x+1<m) ++x; else ++y;
                    dx = -1; dy = 1;
                }
            z[count] = matrix[x][y]; ++count;
        }
        return z;
    }
}
