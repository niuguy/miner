/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */    
    ArrayList<ArrayList<Integer> > ans;
    public void dfs(int A[], int K, int target, int index, ArrayList<Integer> tans)
    {

        if(K == 0 && target == 0) {
            ans.add(new ArrayList<Integer>(tans));
            return ;
        }
        if(K < 0 || target < 0 || index < 0)
            return ;
        dfs(A, K, target, index - 1, tans);
        tans.add(A[index]);
        dfs(A, K  - 1, target - A[index], index - 1, tans);
        tans.remove(tans.size() - 1);
        
    }
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int K, int target) {
        ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tans = new ArrayList<Integer>();
        dfs(A, K, target, A.length - 1, tans);
        return ans;
    }
}
