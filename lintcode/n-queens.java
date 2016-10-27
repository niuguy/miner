/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        if (n <= 0) {
            return resultList;
        }
        int[] row = new int[n];
        solveNQueensCore(resultList, row, n, 0);
        return resultList;
    }
    
    private void solveNQueensCore(ArrayList<ArrayList<String>> resultList,
                              int[] row,
                              int n,
                              int index) {
        if (index == n) {
            ArrayList<String> singleResult = translateString(row);
            resultList.add(singleResult);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(row, index, i)) {
                row[index] = i;
                solveNQueensCore(resultList, row, n, index + 1);
                row[index] = 0;
            }
        }
    }
    
    private ArrayList<String> translateString(int[] row) {
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                if (j == row[i]) {
                    sb.append('Q');
                }
                else {
                    sb.append('.');
                }
            }
            resultList.add(sb.toString());
        }
        return resultList;
    }
    
    private boolean isValid(int[] row, int rowNum, int columnNum) {
        for (int i = 0; i < rowNum; i++) {
            if (row[i] == columnNum) {
                return false;
            }
            if (Math.abs(row[i] - columnNum) == Math.abs(i - rowNum)) {
                return false;
            }
        }
        return true;
    }
    
};
