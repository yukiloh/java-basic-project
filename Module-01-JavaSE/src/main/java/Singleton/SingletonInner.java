package Singleton;

public class SingletonInner {

    /*内部类延迟单例*/
    private SingletonInner() {};

    private static class SingletonHolder{
        private static SingletonInner instance=new SingletonInner();
    }

    public static SingletonInner getInstance(){
        return SingletonHolder.instance;
    }

    /*通过jvm的机制造成延迟加载，安全高性能*/
}
