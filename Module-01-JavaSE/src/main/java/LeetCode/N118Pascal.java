package LeetCode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class N118Pascal {


    //生成杨辉三角(每一行)

    @Test
    public void testContext() {
        System.out.println(generate(4));

    }

    public List<List<Integer>> generate(int numRows) {
        int[][] arry = new int[numRows][numRows];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> row = null;
        for (int i = 0; i < numRows; i++) {
            arry[i][0] = 1;
            row = new ArrayList<>();
            row.add(arry[i][0]);
            for (int j = 1; j <= i; j++) {
                arry[i][j] = arry[i-1][j-1] +arry[i-1][j];
                row.add(arry[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}
