package RegularExpression;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式
class RegularExpression01 {


    //基本用法
    @Test
    void testContext1() {
        /*入门案例*/
//        String regex0 = "[1-9]\\d{4,14}";
//        System.out.println("12345".matches(regex0));



        // [] 代表单个字符, ^ 非
//        String regex1 = "[^abc]";   //代表单个字符不匹配abc
//        System.out.println("d".matches(regex1));


        //[a-zA-z] 代表所有大小写的a到z,包含头和尾
//        String regex = "[a-zA-Z]";
//        System.out.println("d".matches(regex));


        //[a-c[m-p]] 代表a-c和m-p的 并集 , 也可以表示为 [a-cm-p]
//        String regex = "[a-c[m-p]]";
//        System.out.println("m".matches(regex));


        //[a-f&&[b-d]] 代表a-f和b-f的 交集;与非的组合 [[a-z]&&[^b-d]]
//        String regex = "[[a-z]&&[^b-d]]";
//        System.out.println("b".matches(regex));


        // . 匹配任何单个字符,如果要匹配2个则 ..   ; [..]是不可以的! ;如果匹配..,但只有1个字符也会是false
//        String regex = "..";System.out.println("bb".matches(regex));


        // java中需要2个\\
        // \d 匹配单个数字0-9,即[0-9]   ;\D 非数字,[^0-9] ;\s 空格  ;\S 非空格
        // \w 单词,注意,包含了_,即[a-zA-Z_0-9]    ;\W 非单词
//        String regex = "\\w";System.out.println("_".matches(regex));


        /*数量词,出现的次数*/

        // ? 匹配1次或0次     ;* 匹配0或n次       ;+ 匹配1或n次
        // 注意,如下例,如果匹配aabbcc是true,如果是aabbcdc则是false,应该是按照顺序匹配,如果出现不匹配字符则立即返回false
//        String regex = "[abc]*";System.out.println("bbaac".matches(regex));


        // {n} 只匹配n次    {n,m} 至少n次,至多m次     都是左右闭合的(包含)
//        String regex = "..";System.out.println("bb".matches(regex));


    }


    //捕获组,和replace,split的应用
    @Test
    void testContext2() {

        /*分组功能,捕获组 (),以括号()进行分组*/
        //((A)(B(C))):代表存在四个组((A)(B(C))),(A),(B(C)),(C)
//        String regex = "(.)\\1(.)\\2";  // 区分叠词; \\1 表示第一组重复出现单次
//        System.out.println("aabb".matches(regex));  //true


        /*与split和replace的组合应用*/
        //split     以所有叠词进行分割
//        String regex = "(.)\\1+";  // 区分叠词; \\1 表示第一组重复又出现1次
//        System.out.println(Arrays.toString("1aa4bb2ccc5ff66a".split(regex)));  //[1, 4, 2, 5, , a]

        //replace
//        String regex = "(\\.)+"; //匹配. 至少出现1~n次
//        System.out.println("bb...cc..caa.adsf.sdf...we..sdf".replaceAll(regex, ""));    //替换所有.为空字符

        //剩余字符,如果出现重复次数,则替换为第一组的字符; $1表示()内的内容
//        System.out.println(
//                "bb...cc..caa.adsf.sdf...we..sdf".replaceAll(regex, "").
//                replaceAll("(.)\\1+","$1"));

    }


    // Pattern  Matcher 的用法
    @Test
    void testContext3() {

        //通过 Pattern  Matcher 来判断,实际和matches效果一样
//        Pattern pattern = Pattern.compile("ab*");
//        Matcher matcher = pattern.matcher("abbbbbbb");
//        boolean matches = matcher.matches();
//        System.out.println(matches);


        //find和group,查找目标中的结果
        String input = "aaaa110bbbbb120ccccc119";
        Pattern pattern = Pattern.compile("(\\d){3}");
        Matcher matcher = pattern.matcher(input);

//        boolean result = matcher.find();    //查找结果,判断input中是否包含符合正则的结果
//        System.out.println(result);

//        String group = matcher.group();     //获取查找的结果; 注意,如果没有进行find直接group会报错 No match found
//        System.out.println(group);

        //常用的查找方式
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
