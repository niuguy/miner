/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {
	/**
	 * @param A
	 *            an integer array
	 * @return a long integer
	 */
    long fac(int numerator) {
			
		long now = 1;
		for (int i = 1; i <= numerator; i++) {
			now *= (long) i;
		}
		return now;
	}
	long generateNum(HashMap<Integer, Integer> hash) {
		long denominator = 1;
		int sum = 0;
		for (int val : hash.values()) {
			if(val == 0 )	
				continue;
			denominator *= fac(val);
			sum += val;
		}
		if(sum==0) {
			return sum;
		}
		return fac(sum) / denominator;
	}

	public long permutationIndexII(int[] A) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < A.length; i++) {
			if (hash.containsKey(A[i]))
				hash.put(A[i], hash.get(A[i]) + 1);
			else {
				hash.put(A[i], 1);
			}
		}
		long ans = 0;
		for (int i = 0; i < A.length; i++) {
			HashMap<Integer, Integer> flag = new HashMap<Integer, Integer>();
			
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] < A[i] && !flag.containsKey(A[j])) {
				    	flag.put(A[j], 1);
				
					hash.put(A[j], hash.get(A[j])-1);
					ans += generateNum(hash);
					hash.put(A[j], hash.get(A[j])+1);
					
				}
			
			}
				hash.put(A[i], hash.get(A[i])-1);
		}
		
		return ans+1;

	}
}
