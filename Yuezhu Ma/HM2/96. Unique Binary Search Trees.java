96. Unique Binary Search Trees

TEST CASE: n = 0;
           n = 1;
           n = 2;
           n = 3;
           n = 4;

/* 解题思路： 
      1         3     3      2      1
       \       /     /      / \      \
        3     2     1      1   3      2
       /     /       \                 \
      2     1         2                 3
 

    比如，以1为根的树有几个，完全取决于有二个元素(right subtree 2, 3)的子树有几种。同理，2为根的子

    树取决于一个元素(left subtree 1 and right subtree 2)的子树有几个。以3为根的情况，则与1相同

    (left subtree 1, 2)。* 以i为根节点的树，其左子树由[1, i-1]构成， 其右子树由[i+1, n]构成）*

    定义Count[i] 为以[0,i]能产生的Unique Binary Tree的数目。

    如果数组为空，毫无疑问，只有一种BST，即空树，Count[0] =1

    如果数组仅有一个元素{1}，只有一种BST，单个节点 Count[1] = 1

    如果数组有两个元素{1,2}， 那么有如下两种可能  1                       2
                                              \                    /
                                               2                  1
    
    Count[2] = Count[0] * Count[1]   (1为根的情况, left null, right 一个点2)
             + Count[1] * Count[0]   (2为根的情况, right 一个点1， right null)

    再看一遍三个元素的数组，可以发现BST的取值方式如下：

    Count[3] = Count[0]*Count[2]  (1为根的情况, left null, right 两个点 2，3)
             + Count[1]*Count[1]  (2为根的情况, left 一个点 1 right 一个点 2)
             + Count[2]*Count[0]  (3为根的情况, left 两个点 1，2 righ null)

    得出Count的递推公式为Count[i] = ∑ Count[0...k] * [ k+1....i]     0<=k<i-1

    原始的递推式是： Ct+1 += Ci*Ct-i (0<= i <=t)

    现在令变量num=t+1，那么t=num-1

    所以原始递推式做变量替换得：Cnum += Ci*Cnum-1-i (0<= i <=num-1) 

    而num的取值范围是[1, n]因为C0已知。 */


public class Solution {
	public int numTrees(int n) {
	    if (n == 0 || n == 1) return 1;
	    int[] c = new int[n + 1];
	    c[0] = 1;
	    
	    //递推式是Ct+1 += Ci*Ct-i(0<= i <= t)
	    //令num = t+1
	    //则 t = num-1;
	    //因此递推式化为：
	    //Cnum += Ci*Cnum-1-i(0<=i<=num-1, 1<=num<=n)
	    //C0 = 1 
	    
	    for (int num = 1; num < n + 1; num++) {
	        for (int i = 0; i < num; i++) {
	            c[num] += c[i] * c[(num - 1) - i];
	        }
	    }
	    return c[n];
	}
}

