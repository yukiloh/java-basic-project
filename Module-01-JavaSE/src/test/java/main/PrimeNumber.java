package main;

//判断1~100内的质数

public class PrimeNumber {
    public static void main(String[] args){
        int j;
        int count = 0;
        boolean flag;
        for(int i = 2;i <=100; i++){
            flag = false;
            for( j = 2; j < i/2;j++){
                if(i % j == 0){
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                count++;
                if (count==9) {
                    System.out.println("");
                    count =1;
                } 
                System.out.print(i+"  ");    
            }
        }
    }
}