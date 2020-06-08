package com.example.javase.LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class N020isValid {

    /*判断括号,使用栈思想*/
    /*  "()[]{}"  */    /*  "{[]}"    */

    @Test
    public void testContext() {
        System.out.println(isValid(""));
    }


    private boolean isValid(String s) {
        /*储存对应键值对*/
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();    //原版用了linkedList
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char p = s.charAt(i);
            Character C = map.get(p);
            if (C != null ){    /*如果是左括号*/
                stack.add(p);
            }else {             /*如果是右括号*/
                if (stack.size() != 0 && map.get(stack.peek()).equals(p)) {   /*如果左右括号匹配*/
                    stack.pop();
                }else return false;
            }
        }
        return stack.size() == 0;
    }

//参考答案:
//    Stack<Character> stack = new Stack<Character>();
//	for (char c : s.toCharArray()) {
//        if (c == '(')
//            stack.push(')');
//        else if (c == '{')
//            stack.push('}');
//        else if (c == '[')
//            stack.push(']');
//        else if (stack.isEmpty() || stack.pop() != c)
//            return false;
//    }
//	return stack.isEmpty();
}
