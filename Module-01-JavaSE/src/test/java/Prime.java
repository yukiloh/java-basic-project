//prime number in range 1~100
public class Prime{
    public static void main(String[] args){
        int j;
        int count = 0;
        boolean flag;
        for(int i = 2;i <=100000; i++){
            flag = false;
            for( j = 2; j < i;j++){
                if(i % j == 0){
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                count++;
                if (count==9) {
                    System.out.println();
                    count =1;
                }
                System.out.print(i+"  ");
            }
        }
    }
}