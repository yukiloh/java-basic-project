import java.util.HashMap;
import java.util.Scanner;

public class HowManyAlphabets {

    //通过Map接口来统计，输入的字母出现的次数   字母：出现次数
    public static void main(String[] args) {
        //Scanner输入部分
        System.out.println("Input the alphabets: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();


        char charArray[] = input.toCharArray();     //把输入的字符串input转换为字符集合charArray
        HashMap<Character,Integer> mapCounter = new HashMap<>();    //实例化HashMap
        for (char c:charArray) {        //增强for循环：把char类型的c，历遍字符集合charArray
//       有点像python的for c in charArray:
//        for (int i = 0; i < charArray.length; i++) {      //或者用普通for循环
//            char c = charArray[i];                        //方便不用修改后面的c
            if (mapCounter.containsKey(c)) {    //当key存在时，
                Integer value = mapCounter.get(c);//先获得key位置的值value
                value++;                        //值递加
                mapCounter.put(c,value);        //put修改kye，value
            }else {                             //如果无
                mapCounter.put(c,1);            //重新设定key，value为1
            }
        }
        System.out.println(mapCounter);


    }
}