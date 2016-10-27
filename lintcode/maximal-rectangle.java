/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1) return 0;
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int[][] height = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0)
                    height[i][j] = ((matrix[i][j] == '1') ? 1 : 0);
                else
                    height[i][j] += ((matrix[i][j] == '1') ? height[i-1][j] + 1 : 0);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; ++i) {
            Stack<Integer> S = new Stack<Integer>();  
            for (int j = 0; j < m; j++) {
                while (!S.empty() && height[i][j] < height[i][S.peek()]) {
                    int pos = S.peek();
                    S.pop();
                    answer = Math.max(answer, height[i][pos]*(S.empty()? j : j-S.peek()-1));
                }
                S.push(j);
            }
            while (!S.empty()) {
                int pos = S.peek();
                S.pop();
                answer = Math.max(answer, height[i][pos]*(S.empty()? m : m-S.peek()-1));
            }
        }
        return answer;
    }
}