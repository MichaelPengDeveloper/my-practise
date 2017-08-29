package com.test.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 *  事件消费者
 *
 * Created by Wangpeng on 2017/8/29.
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}
