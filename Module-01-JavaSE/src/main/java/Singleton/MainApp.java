package Singleton;

import org.junit.Test;

public class MainApp {

    @Test
    public void mainTest() {
        /*实际调用单例的方式*/
        SingletonEager.getInstance();
        SingletonLazy.getInstance();
        SingletonInner.getInstance();
        SingletonEnum.instance.method();


    }
}
