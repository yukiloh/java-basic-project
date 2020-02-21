package LeetCode;

import org.junit.Test;

public class N009isPalindrome {
    /*判断回文*/
    @Test
    public void testContext() {
        System.out.println(isPalindrome(1001001));
    }


    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        /*转为字符串*/
        String s = String.valueOf(x);
        int i = 0;

        /*取头和尾进行equals判断*/
        while (i < s.length()/2){
            String top = s.substring(i,i+1);
            String bot = s.substring(s.length()-1-i,s.length()-i);
            if (!top.equals(bot)) return false;
            i ++;
        }
        return true;
    }


}
