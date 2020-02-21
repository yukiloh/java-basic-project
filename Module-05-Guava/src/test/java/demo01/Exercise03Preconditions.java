package demo01;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

//preconditions 预判结果
class Exercise03Preconditions {

    @Test
    void test01(){
        myCheckNotNull(null);
    }

    private void myCheckNotNull(final List<String> list) {    //补充:final关键词修饰的参数,如果是基本类型则不可改变,如果是引用类型则不可再赋值(其中的属性依然可以改)
        //获取到list后进行预先判断,如果是null直接报错,并输出message:null;   也可以添加参数
        Preconditions.checkNotNull(list,"null! at least need %s params",2);
    }


    @Test
    void test02(){
        //快捷键 C+A+t
        try {
            //判断状态，如果为false则抛出异常
            String state = "a";
            Preconditions.checkState(state.equals("b"),"illegal state!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    void test03(){
        //判断数组元素数必须小于设定值(不包含)
        List<String> list = ImmutableList.of("a","b","c");
        Preconditions.checkElementIndex(list.size(),3);
    }

    @Test
    void test04(){
        Preconditions.checkNotNull(null,"should not be null");
    }
}
