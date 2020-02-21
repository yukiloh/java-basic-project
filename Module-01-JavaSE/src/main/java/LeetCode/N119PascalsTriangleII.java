package LeetCode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class N119PascalsTriangleII {
    /*杨辉三角,帕斯卡三角
    * 输入： 3
      输出： [1,3,3,1] */

    @Test
    public void testContext() {
        System.out.println(getRow(29));

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {            //rowIndex = 2,3...
            res.add(1);
            for(int j = i-1; j > 0; j--) {              //j = 1,2...
                /*插入第i-1位的元素,赋值i-2 + i-1*/  /*等同于对上一列进行相加计算*/
                res.set(j, res.get(j-1) + res.get(j));  //设置第1位,为第0位+第1位;设置第2位,为第1位+第2位...
            }
        }
        return res;
    }
}
