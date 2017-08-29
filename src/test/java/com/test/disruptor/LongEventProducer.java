package com.test.disruptor;


import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by Wangpeng on 2017/8/29.
 */
public class LongEventProducer {

    private final RingBuffer<LongEvent> longEventRingBuffer;

    public LongEventProducer(RingBuffer<LongEvent> longEventRingBuffer){
        this.longEventRingBuffer = longEventRingBuffer;
    }

    /**
     * onData用来发布事件，每调用一次就发布一次事件事件
     * 它的参数会通过事件传递给消费者
     *
     * @param byteBuffer
     */
    public void onData(ByteBuffer byteBuffer){

        //可以把ringBuffer看做一个事件队列，那么next就是得到下面一个事件槽
        long next = longEventRingBuffer.next();

        try {
            LongEvent longEvent = longEventRingBuffer.claimAndGetPreallocated(next);
            longEvent.setValue(byteBuffer.getLong(0));
        }finally {
            longEventRingBuffer.publish(next);
        }

    }

}
