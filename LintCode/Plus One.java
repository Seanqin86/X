public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        
        int carries = 1;
        for (int i = digits.length - 1; i >= 0 && carries > 0; i--) {
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;
        }
        if (carries == 0) {
            return digits;
        }
        //若上部没有进位的话这步就表示第一位总是进了位,长度就加了1
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 0; i < result.length - 1; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
}

//写法2

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        
        int carry = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            int digit = temp % 10;
            carry = temp / 10;
            digits[i] = digit;
        }
        
        System.out.println(carry);
        
        if (carry != 0) {
            //System.out.println("haha");
            int[] rst = new int[digits.length + 1];
            System.arraycopy(rst, 1, digits, 0, digits.length);
            rst[0] = 1;
            return rst;
        } else {
            return digits;
        }
    }
}