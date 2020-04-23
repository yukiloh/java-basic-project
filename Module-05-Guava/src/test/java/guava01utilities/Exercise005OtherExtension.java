package guava01utilities;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;

import java.util.*;

//其他的补充
class Exercise005OtherExtension {

    @Test
    void test01(){

        // 以下基本类型所通用的方法
        // Bytes/Shorts/Ints/Longs/Floats/Doubles/Chars/Booleans

        // asList(转为list)
        List<Integer> list = Ints.asList(1, 2, 3, 4, 5);
        System.out.println(list);   //  [1, 2, 3, 4, 5]

        // join(将元素通过分隔符合并)
        String join = Ints.join("", 1, 2, 3, 4, 5);
        System.out.println(join);   //  12345

        // concat(合并2个数组)
        int[] concat = Ints.concat(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        System.out.println(Arrays.toString(concat));    // [1, 2, 3, 4, 5, 6]

        // max/min(求最大/最小值)
        System.out.println(Ints.max(concat) +"  "+ Ints.min(concat));   //6  1

        // contains(是否包含)
        System.out.println(Ints.contains(concat, 5));   //true

        //转换为数组
        int[] ints = Ints.toArray(list);
        System.out.println(Arrays.toString(ints));

    }



    //multiSet multiMap     可重复key的集合
    //guava所有的集合都是通过 .create 来创建
    @Test
    void test02(){
        //multiSet
        HashMultiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("a");
        multiset.add("a");
        multiset.add("b");
        multiset.add("b");
        multiset.add("b");
        int aCount = multiset.count("a");   //统计元素的数量
        System.out.println(Arrays.toString(multiset.toArray()));
        //[a, a, a, b, b, b]


        //multiMap
        HashMultimap<String, String> multimap = HashMultimap.create();
        multimap.put("a","a");
        multimap.put("a","aa");
        multimap.put("a","aaa");
        multimap.put("b","bb");
        //通过k获取的返回值类型为set
        Set<String> aSet = multimap.get("a");
        System.out.println(multimap.toString());
        //{a=[aa, aaa, a], b=[bb]}


        ArrayListMultimap<String, String> arrayListMultimap = ArrayListMultimap.create();
        arrayListMultimap.put("name","狗蛋");
        arrayListMultimap.put("name","大柱");
        //与↑例子中的map不同,返回的是list
        List<String> name = arrayListMultimap.get("name");
        System.out.println(Arrays.toString(name.toArray()));

    }



    //不可变集合 ImmutableList/ImmutableSet/ImmutableSortedSet/ImmutableMap/......
    // 针对unmodifiableList的弊端
    @Test
    void test03(){
        //针对unmodifiableList的弊端
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");

        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);    //拷贝进不可变列表
        //unmodifiableList.add("d");  //方法被override重写,尝试改变列表会抛出UnsupportedOperationException

        //此时如果对原有list进行元素添加,不可变数组的元素也会发生变化!
        arrayList.add("c");
        System.out.println(unmodifiableList.size());    //变为3
        //源生jdk的解决办法↓ 创建一个临时性的数组进行保护性拷贝
        //Collections.unmodifiableList(new ArrayList<>(arrayList));


        //通过guava创建不可变集合
        //复制原来list(据说复制时考虑线程安全)
        ImmutableList<String> immutableList = ImmutableList.copyOf(arrayList);
        //创建一个不可变map集合
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("a", "aa", "b", "bb");

        //不可变集合也可以用于线程安全问题
    }


    //双向关联队列BiMap,既可以通过k找到v,可以通过v找到k
    //实际时在创建BiMap时又创建了forward map和backward map,并维护二者的关系
    @Test
    void test04(){
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("a","a@gmail.com");
        biMap.put("b","b@gmail.com");
        //k和v都必须是唯一,如果不唯一则需要forcePut
        biMap.forcePut("bb","b@gmail.com");
        System.out.println(biMap.toString());   //{a=a@gmail.com, bb=b@gmail.com}

        //如果希望通过v查找k,需要inverse()
        System.out.println(biMap.inverse().get("b@gmail.com"));
        //因此biMap.inverse().inverse() == biMap
    }


    //复合索引 hashBasedTable
    @Test
    void test05(){
        //<row,column,value>
        HashBasedTable<String, String , Integer> table = HashBasedTable.create();
        table.put("狗蛋","语文",60);
        table.put("狗蛋","数学",61);
        table.put("大柱","语文",61);
        table.put("大柱","数学",60);

        //table中,单条记录的最小单位cell
        Set<Table.Cell<String, String, Integer>> cells = table.cellSet();
        for (Table.Cell<String, String, Integer> cell : cells) {    //此处泛型也可不指定
            System.out.println(cell.getRowKey() + "," +cell.getColumnKey() +"," + cell.getValue());
        }

        //获取row/column字段的元素
        System.out.println("row: "+table.rowKeySet());
        System.out.println("column: "+table.columnKeySet());

        //通过row和column来获取value
        System.out.println("狗蛋"+" 的 "+"语文: "+table.get("狗蛋", "语文"));

        //也可以通过row/column来获取包含其他2个值的map集合
        System.out.println("语文成绩: "+table.column("语文").toString());
        System.out.println("狗蛋成绩: "+table.row("狗蛋").toString());
    }
}
