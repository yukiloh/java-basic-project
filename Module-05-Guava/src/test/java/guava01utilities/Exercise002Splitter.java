package guava01utilities;

import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//splitter 切割字符串为集合
class Exercise002Splitter {

    @Test
    void test01(){
        //切分后添加为list
        List<String> list = Splitter.on('?').splitToList("hello?world?sun?java");
        System.out.println(Arrays.toString(list.toArray()));
        //list.add("good");   //返回的依然是试图类型,不可修改;   java.lang.UnsupportedOperationException


        //如果不想要空值   omitEmptyStrings()
        List<String> list2 = Splitter.on('?').omitEmptyStrings().splitToList("hello?world?sun?java?????");
        System.out.println(list2);


        //如果还不需要空格 trimResults
        List<String> list3 = Splitter.on('?').omitEmptyStrings().trimResults().splitToList(" hello ? world? sun?java? ? ? ??");
        System.out.println(list3);


        //按照字符串长度来分割 fixedLength
        List<String> list4 = Splitter.fixedLength(4).splitToList("aaaabbbbccccdddd");
        System.out.println(list4);


        //切分后数组数量的上限 limit
        List<String> list5 = Splitter.on('?').limit(3).splitToList("hello?world?sun?java");
        System.out.println(list5);  //第三组内会添加剩余的结果


        //按照正则来分组 onPattern
        String pattern = "\\d";
        List<String> list6 = Splitter.onPattern(pattern).splitToList("hello1world2sun3java4google");
        System.out.println(list6);


        //分割为map类型
        Map<String, String> stringMap = Splitter.on('?').withKeyValueSeparator('=').split("hello=world?sun=java");
        System.out.println(stringMap);
    }
}
