//阶乘，利用递归
public class Factorial {
    public static void main(String[] args) {

        long value = 5;

        long result = methodRecursion(value);
        System.out.println(result);


    }

    private static long methodRecursion(long value) {
        if (value == 1) {
            return 1;
        }
        return value * methodRecursion(value - 1);
    }
}
