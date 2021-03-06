public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        if (A == null || A.length == 0) {
            return 0L;
        }
        long result = 1;
        long fac = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            long rank = 0;
            for (int j = i + 1;  j < A.length; j++) {
                if (A[j] < A[i]) rank++;
            }
            result += fac * rank;
            fac = fac * (A.length - i);
        }
        return result;
    }
}

// 1.对于四位数：4213 = 4*100+2*100+1*10+3

// 2.4个数的排列有4！种。当我们知道第一位数的时候，还有3！种方式，当知道第二位数时候还有2！种方式，当知道第三位数的时候还有1！种方式，前面三位数都确定的时候，最后一位也确定了。<这里是按照高位到地位的顺序>

// 3.对4个数的排列，各位的权值为：3！，2！，1！，0！。第一位之后的数小于第一位的个数是x，第二位之后的数小于第二位的个数是y，第三位之后的数小于第三的个数是z，第四位之后的数小于第四位的个数是w，则abcd排列所在的序列号:index = x*3！+y*2!+z*1!,<0!=0>

// 在数的排列中，小数在前面，大数在后面，所以考虑该位数之后的数小于该为的数的个数，这里我自己理解的也不是很透，就这样。

// 4.例如 4213；x= 3，y = 1，z=0，index = 18+2=20

// 123；x = 0，y=0，index = 0

// 321；x= 2，y=1，index = 2*2！+1*1！ = 5

// 这里的下标是从0开始的。