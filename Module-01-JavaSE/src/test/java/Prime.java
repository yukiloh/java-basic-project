import org.junit.jupiter.api.Test;

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


    //计算手机号的素数
    @Test
    void contextLoads() {
        long num = 17317188346L;
        int count = 0;

        while (true) {
            num++;
            if (isPrime(num)) {
                count++;
                if (count == 117) {
                    System.out.println("target:"+num);
                    break;
                }
            }
            System.out.println(num);
        }
    }

    //通过平方来确定,更高效
    boolean isPrime(long num){
        if(num ==1 || num %2 ==0 && num !=2 ){
            return false;
        }
        else{
            for( int i =3; i< Math.sqrt(num); i+=2){
                if( num % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}