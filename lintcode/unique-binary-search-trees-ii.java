/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    
    private ArrayList<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();   
    
        if(start > end){
            rst.add(null);
            return rst;
        }
     
            for(int i=start; i<=end; i++){
                ArrayList<TreeNode> left = generate(start, i-1);
                ArrayList<TreeNode> right = generate(i+1, end);
                for(TreeNode l: left){
                    for(TreeNode r: right){
// should new a root here because it need to 
// be different for each tree
                        TreeNode root = new TreeNode(i);  
                        root.left = l;
                        root.right = r;
                        rst.add(root);
                    }
                }
            }
        return rst;
    }
}

