package com.example.javase.LeetCode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class N989addToArrayForm {


    /**
     * Input: A = [1,2,0,0], K = 34
     * Output: [1,2,3,4]
     * Explanation: 1200 + 34 = 1234
     */
    @Test
    public void testContext() {
        int[] A = {1,0,2,4};
        int K = 76;
        System.out.println(addToArrayForm(A,K));



    }

    private List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        /*先判断数组，从最高位（末尾）*/
        for (int i = A.length - 1; i >= 0; i--) {
            /*将数组末尾和K相加，模存入链表*/
            linkedList.push((A[i] + K) % 10);
            /*将进位重新赋给K，进入下次循环*/
            K = (A[i] +K) / 10;
        }
        while (K > 0) {    /*K仍有，则取模加入链表*/
            linkedList.push(K % 10);
            K = K /10;
        }
        return linkedList;
    }
}
