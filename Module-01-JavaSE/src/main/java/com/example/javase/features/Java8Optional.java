package com.example.javase.features;

import com.example.javase.features.entity.User;
import org.junit.Test;

import java.util.Optional;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/7/6 9:54
 * 演示java8中 Optional 的用法
 * 主要为了避免空指针异常,以及美化代码
 * 1.演示如何创建Optional(get)
 * 2.演示主要的api(map,orElse)
 * 3.过滤器filter的用法
 */
public class Java8Optional {

    /**
     * 创建optional的3种方法
     */
    @Test
    public void createUser01() {
        //1.创建空对象
        //通过empty方法,创建一个null的user
        Optional<User> empty = Optional.empty();

        //通过get调用user(一般调用get前需要isPresent来判空)
        User user = empty.get();
        //此时会抛出异常 NoSuchElementException
    }

    @Test
    public void createUser02() {
        //2.创建非空对象
        //通过Optional.of()方法,传入user生成optional
        //如果此时传入的是null会抛出异常
        Optional<User> optional = Optional.of(null);
        //抛出异常 NullPointerException
    }

    @Test
    public void createUser03() {
        //3.允许创建空对象
        //因此,如果出现可能为null的情况,则应该使用ofNullable方法来创建optional
        Optional<Object> optional = Optional.ofNullable(null);
        //使用ofNullable方法,允许传入null,不会抛出异常
    }

    /**
     * 获取optional中的object的方法
     */
    @Test
    public void getUser01() {
        //可以通过isPresent来检查是否是null
        Optional<Object> optional = Optional.ofNullable(null);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }else {
            System.out.println("user is null");
        }
    }

    @Test
    public void getUser02() {
        //通过orElse提供备选对象
        //如果传入Optional中的值是空,那么会直接返回orElse中的对象
        Object o = Optional.ofNullable(null).orElse(new User());

        //或者使用orElseGet,与↑的区别是,orElseGet在Optional获取到notNull对象时不会再创建对象,而orElse会
        Object o1 = Optional.ofNullable(null).orElseGet(()->new User());

        //或者通过orElseThrow来返回异常(当optional传入null时)
        Object o2 = Optional.ofNullable(null).orElseThrow(()->new IllegalArgumentException());
    }

    /**
     * optional的基础用法
     */
    @Test
    public void testContext1() {
        //判断对象中的属性是否为null,如果为null则可以替换为希望的值

        //todo 模拟从数据库或其他地方获取user信息
        User user = new User(1, "狗蛋");

        //将获取到的user传入optional中处理.这里对username进行判断,如果是null则返回"null"
        //map: 将map方法的参数,所返回的结果作为Optional的泛型(即,原来的泛型是User,现在转为String)
        //如果需要改变返回的结果类型,可以使用map
        String username = Optional.of(user).map(u -> u.getUsername()).orElse("null");
        System.out.println(username);

        //flatMap: 直接隐射目标获取Optional<T>,并返回Optional<T>
        //需要在对象属性中提供相应方法(getOptionalUsername)
        Optional<String> s = Optional.of(user).flatMap(u -> u.getOptionalUsername());
        System.out.println(s.orElse("null"));
    }

    //过滤器filter的用法
    @Test
    public void testContext2() {
        //todo 模拟一个数据
        User user = new User(1, "狗蛋");
        Optional<User> optional = Optional.of(user);

        //进行过滤,如果满足不满足条件则丢弃对象(返回null)
        optional = optional.filter(u -> u.getId() != 1 && u.getId() != null);

        //因为id==1,因此user被丢弃,最终打印结果:user is null
        System.out.println(optional.isPresent()?optional.get():"user is null");
    }


    //java9另外添加了or(),ifPresentOrElse(),stream(),略
}
