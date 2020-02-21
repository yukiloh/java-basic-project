package FilterExercise.CheckingWordExercise.ProxyExercise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



/*设计模式——代理模式：动态代理的练习，通过代理真实对象，来达到增强真实对象的一种方法*/      /*原本是作为关键词过滤的一个插播练习*/
/*步骤：*/
/*1.创建真实对象，并实现接口——RealTarget implement TheirInterface*/
public class ProxyTarget{
    public static void main(String[] args) {
        /*2.实例化真实对象*/
        RealTarget realTarget = new RealTarget();

        /*3.创建代理对象proxyRealTarget，并强转为接口型TheirInterface的对象。
            代理对象方法Proxy.newProxyInstance的3个参数：
            1.类加载器classloader
            2.接口数组interfaces
            3.处理器invocationHandler*/
        TheirInterface proxyRealTarget = (TheirInterface)
                Proxy.newProxyInstance(realTarget.getClass().getClassLoader(),
                realTarget.getClass().getInterfaces(),
                new InvocationHandler() {/*处理器通过匿名函数创建，重写override其中invoke方法，其中含有3个参数：
                    3.1代理对象proxy
                    3.2代理对象调用的方法method
                    3.3参数数组agrs[]
                    通过重写此处来进行对象的增强*/
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println(method.getName());     /*可通过method来获取method的名字*/
//                        System.out.println(args[0]);              /*同理还有传入的参数*/



                        /*对获取的method进行判断,是否为需要增强的方法*/
                        if ("showString".equals(method.getName())) {    /*如果是showString,*/
                            String s = args[0].toString().toUpperCase();/*本次示范把传入的str都转为大写!*/

                            Object obj = method.invoke(realTarget,s);        /*通过method调用invoke方法,传入 真实对象 和参数来创建对象obj*/
                                                                             /*※代理对象本身是不具有方法的!*/
                            return obj;     /*最后返回增强的代理对象*/

                        }else { /*如果不是,该咋咋滴*/
                            Object obj = method.invoke(realTarget, args);
                            return obj;
                        }

                    }
                });
//        System.out.println(proxyRealTarget.showString("proxy"));
        proxyRealTarget.showMethod();

    }



}
