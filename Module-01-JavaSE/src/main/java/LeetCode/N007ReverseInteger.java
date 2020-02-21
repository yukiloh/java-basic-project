package LeetCode;

import org.junit.Test;

public class N007ReverseInteger {


    /*
    Input: 123
    Output: 321

    Input: -123
    Output: -321

    Input: 120
    Output: 21
    */  /*需要考虑int的取值范围*/
    @Test
    public void testContext() {
        System.out.println(reverse(-120));

    }
    private int reverse(int x) {
        long result = 0;
        while (x != 0){
            /*取原数字的末尾,再加上原来的结果*10*/
            result = result * 10 +  (x % 10);
            x = x / 10;
        }
        /*判断是否超过int取值范围*/
        return (int)result == result ? (int) result : 0;
    }

}
