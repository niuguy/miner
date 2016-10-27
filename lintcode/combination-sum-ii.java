/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {

    private ArrayList<ArrayList<Integer>> results;

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
            int target) {
        if (candidates.length < 1) {
            return results;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        java.util.Arrays.sort(candidates);
        results = new ArrayList<ArrayList<Integer>> ();
        combinationSumHelper(path, candidates, target, 0);

        return results;
    }

    private void combinationSumHelper(ArrayList<Integer> path, int[] candidates, int sum, int pos) {
        if (sum == 0) {
            results.add(new ArrayList<Integer>(path));
        }

        if (pos >= candidates.length || sum < 0) {
            return;
        }

        int prev = -1;
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] != prev) {
                path.add(candidates[i]);
                combinationSumHelper(path, candidates, sum - candidates[i], i + 1);
                prev = candidates[i];
                path.remove(path.size()-1);
            }
        }
    }

}
