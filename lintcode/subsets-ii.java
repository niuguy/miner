/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if ( S == null || S.size() == 0){
            return rst;
        }
        
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(rst,list,S,0);
        return rst;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list,
    ArrayList<Integer> S, int pos) {
        rst.add( new ArrayList(list));
        for ( int i = pos; i < S.size();i++){
            if ( i != pos && S.get(i) == S.get(i-1)){
                continue;
            }
  
            list.add(S.get(i));
            helper(rst,list,S,i+1);
            list.remove(list.size()-1);
        }
    }
}