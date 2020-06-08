package com.example.javase.Stream;

import java.util.ArrayList;
import java.util.stream.Stream;


//stream流的使用示范      stream只可使用一次!
public class StreamMain {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();
        Stream<Integer> stream = arrayList.stream();        //通过collections.stream来获取stream


        Stream<Integer> stream1 = Stream.of(1,2,3);         //通过Stream.of来获取stream


        stream1.forEach(str-> System.out.print(str+"  "));      //forEach循环的用法  终结方法
        System.out.println();


        Stream.of("1一二三","2一二三","3一二三","4二二三").filter(name->name.contains("一")).forEach(name-> System.out.println(name));   //filter的写法


        Stream.of("1","2","3","4").map((String num)-> Integer.parseInt(num)).forEach((num)-> num++);    //map映射的用法,可惜结果不可以只打印一个数字
        System.out.println();


        System.out.println(Stream.of("11","21","31","4").filter(name->name.contains("1")).count());     //count的用法,返回一个long类型    终结方法


        Stream.of("1","2","3","4").limit(3).skip(1).forEach((a)-> System.out.print(a + " "));   //limit 截取前(long)个元素    skip 跳过()个元素
        System.out.println();


        Stream streamA = Stream.of("1一二三","2一二三","3一二三","4二二三");
        Stream streamB = Stream.of("1","2","3","4");
        Stream.concat(streamA,streamB).forEach(a-> System.out.print(a+"  "));   //concat的用法,组合2个stream
    }
}
