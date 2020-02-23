package demo01;


import com.google.common.base.*;
import entity.Student;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

//functional programming 函数式编程的一些接口,和接口对应工具类的用法
//函数式编程的好处:在遍历过程中可以自定义function,而不用重复的去遍历集合
public class Exercise005FunctionalProgramming {


    //Function接口的演示,接口下只有2个方法
    @Test
    void test01(){

        //要求:希望传入string,返回integer
        //guava的function接口实际也继承了java8的function
        Function<String, Integer> countChar = new Function<String, Integer>() {
            @Nullable
            @Override
            public Integer apply(@Nullable String input) {
                Preconditions.checkNotNull(input, "not null");
                return input.length();
            }

            //另有一个equals,不演示
        };

        System.out.println(countChar.apply("hello world"));
    }



    //Functions,将目标类型转换为Function类型,然后可以执行Function下的方法
    @Test
    void test02(){
        Student student = new Student(1, "狗蛋");
        //相当于调用了对象的toString方法;  内部通过枚举来获取单例
        System.out.println(Functions.toStringFunction().apply(student));

        //identity,给什么传出什么
        Object apply = Functions.identity().apply(student);

        //传入map,依据key获取value
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"hello");
        System.out.println(Functions.forMap(map).apply(1));


        //将function类型的对象,从A转为B,B再转为C并输出
        //Function<A, C> compose(Function<B, C> g, Function<A, ? extends B> f)
        Long result = Functions.compose(
                new Function<Integer, Long>() {
                    @Nullable
                    @Override
                    public Long apply(@Nullable Integer integer) {
                        return integer.longValue();
                    }
                },
                new Function<String, Integer>() {

                    @Nullable
                    @Override
                    public Integer apply(@Nullable String s) {
                        return s.length();
                    }
                }).apply("hello world");
        //输入String,最后输出Long
        System.out.println(result+",class: "+result.getClass().toString());

        //forPredicate(断言),传入一个predicate,返回bool,演示略

        //constant(常量),无论传入什么,都会返回所定义的类型(↓定义Student,因此也只会返回Student)
        Student apply1 = Functions.constant(student).apply("");
    }


    //Supplier类型,只有一个get方法
    @Test
    void test03(){
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "hello world";
            }
        };
        String s = supplier.get();
        System.out.println(s);
    }


    //Suppliers的一些用法
    @Test
    void test04(){
        //compose 给与supplier<A>,返回supplier<B>
        //如↓,传入Integer,返回Long
        Long aLong = Suppliers.compose(new Function<Integer, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable Integer integer) {
                return null;
            }
        }, new Supplier<Integer>() {
            @Override
            public Integer get() {
                return null;
            }
        }).get();


        //其他略; suppliers中多数存在双锁单例
    }



    //Predicate类型,断言,返回bool;        存在apply,test方法
    @Test
    void test05(){
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean apply(@Nullable String s) {
                return false;
            }
        };
        boolean hello = predicate.apply("hello");
        System.out.println(hello);

        //Predicates的方法
        //not 如果predicate返回false,则返回true
        System.out.println(Predicates.not(predicate).apply("hell"));

        //and 都是真则真,演示略
    }
}
