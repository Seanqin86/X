class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    public String getPermutation(int n, int k) {
        
        
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }
        
        int factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }
        StringBuilder res = new StringBuilder();
        int times = n - 1;
        k -= 1;
        while (times >= 0) {
            int indexInList = k / factorial;
            res.append(numList.get(indexInList));
            numList.remove(indexInList);
            
            k = k % factorial;
            if (times != 0) {
                factorial = factorial / times;
            }
            times--;
        }
        return res.toString();
    }
}

// 题解：

// 发现数学规律。

// 首先先捋捋这道题要干啥，给了我们n还有k，在数列 1，2，3，... , n构建的全排列中，返回第k个排列。

// 题目告诉我们：对于n个数可以有n!种排列；那么n-1个数就有(n-1)!种排列。

// 那么对于n位数来说，如果除去最高位不看，后面的n-1位就有 (n-1)!种排列。

// 所以，还是对于n位数来说，每一个不同的最高位数，后面可以拼接(n-1)!种排列。

// 所以你就可以看成是按照每组(n-1)!个这样分组。 

// 利用 k/(n-1)! 可以取得最高位在数列中的index。这样第k个排列的最高位就能从数列中的index位取得，此时还要把这个数从数列中删除。

// 然后，新的k就可以有k%(n-1)!获得。循环n次即可。

//  同时，为了可以跟数组坐标对其，令k先--。

//和题 Permutation Index 正好相反，这里给定第几个排列的相对排名，输出排列值。和不同进制之间的转化类似，这里的『进制』为1!, 2!..., 以n=3, k=4为例，我们从高位到低位转化，直觉应该是用 k/(n-1)!, 但以 n=3,k=5 和 n=3,k=6 代入计算后发现边界处理起来不太方便，故我们可以尝试将 k 减1进行运算，后面的基准也随之变化。第一个数可以通过(k-1)/(n-1)!进行计算，那么第二个数呢？联想不同进制数之间的转化，我们可以通过求模运算求得下一个数的k-1, 那么下一个数可通过(k2 - 1)/(n-2)!求得，这里不理解的可以通过进制转换类比进行理解。和减掉相应的阶乘值是等价的。

//method2

class Solution {
    /**
     * @param n: n
     * @param k: the kth permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k) {
        List<Integer> numList = new ArrayList<Integer>();
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
            numList.add(i);
        }
        StringBuilder res = new StringBuilder();
        k -= 1;
        fac /= n;
        for (int i = n - 1; i >= 0; i--) {
            int indexInList = k / fac;
            //System.out.println(indexInList)
            res.append(numList.get(indexInList));
            numList.remove(indexInList);
            
            k = k % fac;
            if (i != 0) {
                fac = fac / i;
            }
        }
        return numList.toString();
    }
}

//times = n - 1;或者循环从for(int i = n-1; i >= 0; i--)
//k = k - 1;
//此题的重点 numInList = k % factorial; 确定
//k = k % factorial
//factorial = factorial / times
//times--

