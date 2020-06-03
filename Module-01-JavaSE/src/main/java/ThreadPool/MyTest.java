package ThreadPool;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/6/4 2:31
 * 用于介绍线程池
 */
public class MyTest {
    @Test
    public void testContext01() throws IOException {
        int nThreads = 2;

        //固定大小的线程池.无界阻塞队列,会出现oom
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(nThreads);

        //无限制创建线程池,适合处理大量耗时短的任务
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //不同于Executors.newFixedThreadPool(1)
        //fixed可以强转为ThreadPoolExecutorsingle,而single不可以,这才做到了single
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        System.in.read();   //阻塞线程
    }
}
