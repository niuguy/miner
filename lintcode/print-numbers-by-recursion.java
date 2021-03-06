/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        num(n, 0, res);
        return res;
    }
    
    public void num(int n, int ans,ArrayList<Integer> res){
        
        if(n==0){
            if(ans>0){
                res.add(ans);
            }
            return;
        }
        
        int i;
        for(i=0; i<=9; i++){
            num(n-1, ans*10+i, res);
        }
        
    }
}