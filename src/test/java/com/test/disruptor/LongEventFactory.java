package com.test.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Wangpeng on 2017/8/29.
 */
public class LongEventFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}
