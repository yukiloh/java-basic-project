package Lambda.Advance;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


//一个进阶lambda表达式的示范
public class LambdaAdvanceMain {

    public static void main(String[] args) {

        //=============================================================================
                        //Supplier，返回一个输入的泛型类型
        System.out.println(getString(()->"String"));    //输入一个String，返回一个string

        //====================================
        //        //求数组的最大数
        int[] intArr = {0,1,2,3};
        System.out.println(getMax(()-> {    //输入一个Integer，返回一个int
            int max = intArr[0];
            for (int a : intArr) if (a > max) max = a;
            return max;
        }));
        //等同于下面的代码
//        int max = intArr[0];
//        for (int a:intArr) {
//            if (a > max){
//                max = a;
//            }
//        }
//        System.out.println(max);

        //=============================================================================
                    //Consumer，根据泛型，消费（使用）一个该类型的数据
        consumeString("ABC",(string)-> System.out.println(new StringBuilder(string).reverse().toString()));
        //调用consumeString，传入String的ABC和consumer，方法里使用consumer；
        //consumer执行：传入string，打印以下：通过StringBuilder下的reverse，并被toString处理后（返回String类型）的string。
        //====================================
        //使用andThen,分别执行2个操作后进行accept
        consumeStringAndThen("aBcDeFg",
                (string)-> System.out.println(string.replace((char)97,(char)99)),       //one
                (string)-> System.out.println(string.toUpperCase())                     //two
        );
        //结果是2次操作并不会相互干涉结果
        //cOne.andThen(cTwo).accept(string) 存在顺序关系,先执行one,再two
        //====================================
        //使用consume格式化打印
        String[] namelist = {"Tom:cat","Jerry:rat","Spike:dog"};
        consumeStringAndThenArr(namelist,
                (info)-> System.out.print("Name: "+info.split(":")[0]),
                (info)-> System.out.println(";  Species: "+info.split(":")[1])
        );
//        for (String info:strings) cOne.andThen(cTwo).accept(info);
//        可以理解为把获取的传送给２个对象供其使用
       /*正常的方法
            for (String a:strings) {
            String name = a.split(":")[0];
            String species = a.split(":")[1];
            sout("name:"+name+"  species:"+species);
        }*/
        //=============================================================================
                        //Predicate(判断)，进行判断，返回布尔值
        //判断2个数据，最后返回布尔值
        predicateMethod("Abcdefg",
                string -> string.length() > 5,      //和前几条不同,返回的是布尔值    判断长度是否大于5
                string -> string.contains("b")      //判断是否包含b
        );
        //=============================================================================
                        //Function,转换类型
        functionMethod("15",
                string -> Integer.parseInt(string),
                integer -> integer*integer);   //传入一个string,输出为一个int,再乘以一个int

//        //这个是常规写法,这样不是更简单?
//        String num = "15";
//        System.out.println(Integer.parseInt(num) * Integer.parseInt(num));
        //=============================================================================
                        //方法引用      ::
        System.out.println(absMethod(-110,Math::abs));
        //返回绝对值 在成员方法absMethod的参数中传入 函数式接口调用abs,然后在abs中利用lambda表达式进行运算,Math是类,调用了静态成员方法abs










    }
    private static int absMethod(int a, Abs abs) {
        return abs.returnAbs(a);
    }

    private static void functionMethod(String string,Function<String,Integer> func1,Function<Integer,Integer> func2) {
//        System.out.println(func.apply(string));       //传入一个string,输出为一个int
        System.out.println(string+" * "+string+" = "+func1.andThen(func2).apply(string));     //andThen的操作,传入一个string,输出为int,再进行int to int的操作
    }

    private static void predicateMethod(String string,Predicate<String> predA,Predicate<String> predB) {
//        predA.test(string);//没有and/or/negate的写法
        System.out.println(string+"-> length > 5 and contains b : "+predA.and(predB).test(string));
//        or和and一样      negate只传入一个pred: pred.negate().test(string);

    }

    private static void consumeStringAndThenArr(String[] strings,Consumer<String> cOne,Consumer<String> cTwo) {
        for (String info:strings) cOne.andThen(cTwo).accept(info);
    }

    private static void consumeStringAndThen(String string,Consumer<String> cOne,Consumer<String> cTwo) {
        cOne.andThen(cTwo).accept(string);
    }


    private static void consumeString(String string, Consumer<String> cons) {
        cons.accept(string);
    }

    private static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    private static String getString(Supplier<String> sup) {
        return sup.get();
    }
}
