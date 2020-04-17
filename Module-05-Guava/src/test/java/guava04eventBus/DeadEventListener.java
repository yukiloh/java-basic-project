package guava04eventBus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;


public class DeadEventListener {

    @Subscribe
    public void getDeadEvent(DeadEvent deadEvent) {
        //返回的是obj类型,需要toString转换
        System.out.println(deadEvent.toString());
    }

    @Subscribe
    public void doActioin(String event) {
        //返回的是obj类型,需要toString转换
        System.out.println(event);
    }
}
