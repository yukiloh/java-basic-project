package com.example.guava.guava01utilities;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//joiner 拼接集合中的元素
class Exercise001Joiner {

    //补充：asList只能塞入包装类型;    返回的是视图类型,无法再进行修改(remove,add等) java.lang.UnsupportedOperationException
    private final List<String> stringList = Arrays.asList("google","guava","java","scala","kafka");
    private final List<String> stringListHasNull = Arrays.asList("google","guava","java","scala",null);


    //Array类
    @Test
    void test01(){
        //通过on方法,使用分隔符来连接list中的元素; join中可以塞入多个对象/数组对象/迭代
        String result = Joiner.on("!").join(stringList);
        System.out.println(result);
        //注意,list中不可包含 null 对象!

        //如果希望跳过null
        System.out.println(Joiner.on("!").skipNulls().join(stringListHasNull));

        //如果希望替换null
        System.out.println(Joiner.on("!").useForNull("null").join(stringListHasNull));


        //也可以加入至一个appendable
        final StringBuilder stringBuilder = new StringBuilder();    //补充:final后的基本类型不可改变值,引用类型只保证引用的地址不发生改变,值依然可变的
        StringBuilder builder = Joiner.on("!").useForNull("null").appendTo(stringBuilder, stringListHasNull);
        //这里虽然重新定义了一个builder,但实际还是原来那个
        System.out.println(stringBuilder.hashCode()==builder.hashCode());
        System.out.println(builder.toString());

        //使用原生的java语句(stream和lambda)也是可以做到这种处理的
        System.out.println(stringListHasNull.stream().filter(item -> item != null && !item.isEmpty()).collect(Collectors.joining("?")));
    }



    //map类
    @Test
    void test03(){
        // guava自带的map Immutable: 不可变的
        ImmutableMap<String, String> stringMap = ImmutableMap.of("hello","world","sun","java");
        System.out.println(stringMap);

        //on:每个kv的分隔符;  withKeyValueSeparator:kv之间的分隔符;
        System.out.println(Joiner.on(", ").withKeyValueSeparator(':').join(stringMap));
    }




    //其他补充,guava也可以通过自己的方法来生成toString(),MoreObjects.toStringHelper(this)
    //或者hashCode(),Objects.hashCode
    //但idea有快捷键了
}
