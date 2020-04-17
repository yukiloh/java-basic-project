package guava01utilities;


import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

//StopWatch,码表,可以用于打印时间
public class Exercise006StopWatch {

    //StopWatch的演示
    @Test
    void test01(){
        //开始计时
        Stopwatch stopwatch = Stopwatch.createStarted();

        System.out.println("processing...");
        //模拟运行1秒
        try {
            TimeUnit.NANOSECONDS.sleep(1000);  //底层依然调用Thread.sleep
//            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("process finished.");
        //计时结束,打印时间;    会根据时间长度自动转换单位
        System.out.println("cost: "+stopwatch.stop().toString());
        //也可以通过elapsed来指定时间单位           elapsed:流逝时间
        System.out.println("cost(nano): "+stopwatch.elapsed(TimeUnit.NANOSECONDS));

        //清零,可以重复使用
        stopwatch.reset();


        //内部通过Ticker来实现计时?
        //Ticker中有用到 ServiceLoad,可以通过特定的方式(定义包名,文件名)来加载清单文件中的具体实现,ServiceLoader.load(xxx.class);
        //1.9以后实施模块化编程,让一个模块加载另一个模块,因此ServiceLoad 被赋予了更多的使命
    }




}
