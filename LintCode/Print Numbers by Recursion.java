public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        if (n == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        helper(n, result);
        return result;
    }
    private int helper(int n, List<Integer> result) {
      if (n == 0) {
          return 1;
      }
      int temp = helper(n - 1, result);
      int size = result.size();
      for (int i = 1; i <= 9; i++) {
          int tempNum = i * temp;
          result.add(tempNum);
          for (int j = 0; j < size; j++) {
              result.add(tempNum + result.get(j));
           }
        }
        return temp * 10; 
    }
}


//method2

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        List<Integer> rst = new ArrayList<Integer>();
        if (n == 0) return rst;
        helper(rst, n, 0);
        return rst;
    }
    private void helper(List<Integer> rst, int n, int ans) {
        if (n == 0) {
            if (ans > 0) {
                rst.add(ans);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            helper(rst, n - 1, ans * 10 + i);
        }
    }
}