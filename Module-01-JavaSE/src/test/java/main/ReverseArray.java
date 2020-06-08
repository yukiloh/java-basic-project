package main;

import java.util.Arrays;

public class ReverseArray{
    //倒置一个数组
    
    public void main(String[] args){
        
        int [] arrayA = {1,2,3,4,5} ;   //创建一个数组
        int temp1 = 0;                  //定义一个零时接受变量
        int lenArray = arrayA.length;   //测量数组长度length
        print("length="+lenArray);      //调用下面的打印机

        for(int frist = 0,last = arrayA.length -1;frist < last;frist ++,last --){
            //for循环内，参数（初始数值、更新步骤）可以为多个，用逗号,隔开，）
            //第一数 初始为0，最后一个为长度-1，第一个每次++，末尾每次--，当前面的数大于后面的停止
            temp1 = arrayA[frist];
            arrayA[frist] = arrayA[last];
            arrayA[last] = temp1;
        }
        System.out.println(Arrays.toString(arrayA));
    }





    //打印机
    public void print(int inputVar) {
        System.out.println(inputVar);
    }
    public void print(byte inputVar) {
        System.out.println(inputVar);
    }
    public void print(double inputVar) {
        System.out.println(inputVar);
    }
    public void print(Short inputVar) {
        System.out.println(inputVar);
    }
    public void print(long inputVar) {
        System.out.println(inputVar);
    }
    public void print(float inputVar) {
        System.out.println(inputVar);
    }
    public void print(Boolean inputVar) {
        System.out.println(inputVar);
    }
    public void print(char inputVar) {
        System.out.println(inputVar);
    }
    public void print(String inputVar) {
        System.out.println(inputVar);
    }


}
