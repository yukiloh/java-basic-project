package demo01;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import org.junit.jupiter.api.Test;

//Strings and char
class Exercise004Strings {

    @Test
    void test01(){
        //将null转为空字符串
        System.out.println("output: "+Strings.nullToEmpty(null));

        //将空字符串转为null
        System.out.println("output: "+Strings.emptyToNull(""));
        System.out.println("output: "+Strings.emptyToNull("not null")); //如果字符串不是空不会进行转换

        //判断是否为空或者null,返回bool
        System.out.println("output: "+Strings.isNullOrEmpty("")+" "+Strings.isNullOrEmpty(null));

        //打印共同的前缀(单个字符)
        System.out.println("output: "+Strings.commonPrefix("adc","adc"));
        //共同的后缀
        System.out.println("output: "+Strings.commonSuffix("abc","adc"));
        //如果不相同则输出空字符串
        System.out.println("output: "+Strings.commonPrefix("abd","bdc"));

        //重复repeat; 源码写的很细致
        System.out.println("output: "+Strings.repeat("aa",3));

        //垫字母
        System.out.println("output: "+Strings.padStart("abc",5,'?'));   //??abc
        System.out.println("output: "+Strings.padEnd("abc",5,'?'));     //abc??

    }


    //char相关
    @Test
    void test02(){
        //快速返回一个指定的charset类型
        System.out.println(Charsets.UTF_8);
        System.out.println(Charsets.UTF_8.getClass());  //class sun.nio.cs.UTF_8

        //匹配char中的0~9,是否包含1
        System.out.println(CharMatcher.inRange('0', '9').matches('1'));
        //也可以用于保留1234
        System.out.println(CharMatcher.inRange('0', '9').retainFrom("abcd1234"));
        //匹配 0~9 或 空格,将他们从"..."中去除  (or和and可以有多个)
        System.out.println(CharMatcher.inRange('0', '9').or(CharMatcher.whitespace()).removeFrom("h32e1l32lo  1 234 w- o rld"));

        //替换所有空格,将(1~n个的)空格替换为单个的-
        System.out.println(CharMatcher.breakingWhitespace().collapseFrom("x    x  x   xx xxx x x x x x xx x x x",'-'));

        //计数char出现几次
        System.out.println(CharMatcher.is('a').countIn("aaccadafsfsfasdfasfasfasfasdfs"));

    }
}
