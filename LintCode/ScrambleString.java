/*method1
*/
public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        if (s1.length() == 0 || s1.equals(s2)) {
            return true;
        }
        
        if (!isValid(s1, s2)) {
            return false;
        }
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s2.length());
            String s23 = s2.substring(0, s2.length() - i);
            String s24 = s2.substring(s2.length() - i, s2.length());
            
            if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
            if (isScramble(s11, s24) && isScramble(s12, s23)) return true;
        }
        return false;
    }
    
    public boolean isValid(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        String s11 = new String(char1);
        String s21 = new String(char2);
        if (!s11.equals(s21)) {
            return false;
        }
        return true;
    }
}

http://blog.unieagle.net/2012/10/23/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Ascramble-string%EF%BC%8C%E4%B8%89%E7%BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/


//method2 memoization


 (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());
            
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s2.length());
            
            String s23 = s2.substring(0, s2.length() - i);
            String s24 = s2.substring(s2.length() - i, s2.length());
            