//BEST WRITING

public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        //dp[i][j]代表s的0-i可否与p的0-j匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != '*') {
                    if (i > 0 && s.charAt(i - 1) == p.charAt(j - 1) && dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                
                else if (p.charAt(j - 1) == '.') {
                    if (i > 0 && dp[i - 1][j - 1]) dp[i][j] = true;
                }
                
                else if (j > 1) {
                    if (dp[i][j - 1] || dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (i > 0 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') && dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m][n];
    }
}

//method1 DP

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
       // int i = 0, j = 0;
        
        if (s.length() == 0) {
            return checkEmpty(p);
        }
        
        if (p.length() == 0) {
            return false;
        }
        
        char c1 = s.charAt(0);
        char d1 = p.charAt(0);
        char d2 = '0';
        
        if (p.length() > 1) {
            d2 = p.charAt(1);
        }
        //如果Pattern第二位是‘*’
        if (d2 == '*') {
            //s与p的第一位都相等或者p第一位为‘.’
            //fork here: 1. consume the character, and use the same pattern again.
            //2. keep the character, and skip 'd1*' pattern
            //Here is also an opportunity to use DP, but the idea is the same
            if (compare(c1, d1)) {
               return isMatch(s.substring(1), p) || isMatch(s, p.substring(2)); 
            } else {
            //s与p不相等，p跳到第2位继续比较
                return isMatch(s, p.substring(2));
            }
        } else {
        //没有’*‘则单独依次匹配每一个
            if (compare(c1, d1)) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }
    
    private boolean compare(char c1, char d1) {
        return d1 == '.' || c1 == d1;
    }
    private boolean checkEmpty(String s) {
        //如果pattern 的长度为奇数，则为false
        if (s.length() % 2 != 0) {
            return false;
        }
        //c*a*b*c每跳两部，判断是否为‘*’
        for (int i = 1; i < s.length(); i+=2) {
            if (s.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}

//Method2



public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        //Pattern的1号位不为‘*’
        if (p.length() == 1 || p.charAt(1) !=  '*') {
            //如果依次判断每个不相等
            if (s.length() < 1 || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
                return false;
            }
            //依次判断下一段
            return isMatch(s.substring(1), p.substring(1));
        } else {
            int i = -1;
            while (i < s.length() && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}