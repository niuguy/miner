/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

// version 1
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) 
            return rst;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        while(count * 2 < rows && count * 2 < cols){
            for(int i = count; i < cols-count; i++)
                rst.add(matrix[count][i]);
            
            
            for(int i = count+1; i< rows-count; i++)
                rst.add(matrix[i][cols-count-1]);
            
            if(rows - 2 * count == 1 || cols - 2 * count == 1)  // if only one row /col remains
                break;
                
            for(int i = cols-count-2; i>=count; i--)
                rst.add(matrix[rows-count-1][i]);
                
            for(int i = rows-count-2; i>= count+1; i--)
                rst.add(matrix[i][count]);
            
            count++;
        }
        return rst;
    }
}

// version 2: easier to understand but more code
class Direction {
    public static int DOWN = 0;
    public static int RIGHT = 1;
    public static int LEFT = 2;
    public static int UP = 3;
    
    private static int[] dx = new int[]{1, 0, 0, -1};
    private static int[] dy = new int[]{0, 1, -1, 0};

    public static int turnRight(int direction) {
        if (direction == DOWN) {
            return LEFT;
        } else if (direction == RIGHT) {
            return DOWN;
        } else if (direction == LEFT) {
            return UP;
        } else if (direction == UP) {
            return RIGHT;
        }
        return -1;
    }
    
    public static int[] move(int[] cursor, int direction) {
        int[] nextCursor = new int[2];
        nextCursor[0] = cursor[0] + dx[direction];
        nextCursor[1] = cursor[1] + dy[direction];
        return nextCursor;
    }
}

public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        
        // check corner case
        if (matrix == null || matrix.length == 0) {
            return order;
        }
        int n = matrix.length;
        
        if (matrix[0] == null || matrix[0].length == 0) {
            return order;
        }
        int m = matrix[0].length;
        
        int direction = Direction.RIGHT;
        int[] cursor = new int[]{0, 0};
        
        for (int i = 0; i < n * m; i++) {
            order.add(matrix[cursor[0]][cursor[1]]);
            // mark the visited position as -1
            matrix[cursor[0]][cursor[1]] = -1;
            int[] nextCursor = Direction.move(cursor, direction);
            // if outside of matrix or marked before, turn right
            if (nextCursor[0] < 0 || nextCursor[0] >= n ||
                  nextCursor[1] < 0 || nextCursor[1] >= m ||
                  matrix[nextCursor[0]][nextCursor[1]] == -1) {
                direction = Direction.turnRight(direction);
                nextCursor = Direction.move(cursor, direction);
            }
            cursor = nextCursor;
        }
        
        return order;
    }
}
