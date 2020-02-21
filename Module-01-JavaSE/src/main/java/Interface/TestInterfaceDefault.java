package Interface;

public interface TestInterfaceDefault{
    public abstract void absMethod();   //抽象方法

    public default void interfaceDefault(){     //默认方法
        System.out.println("默认方法");
    }
}




