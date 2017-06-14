package com.wp.practise.framework.cursor;

import com.wp.practise.framework.model.HasId;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public interface HasCursor<N extends Number> extends HasId<N> {
    default String getCusor(){
     return CursorUtils.getCursor(getClass(),getId());
    }
}
