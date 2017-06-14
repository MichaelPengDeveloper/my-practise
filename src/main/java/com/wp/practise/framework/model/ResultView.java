package com.wp.practise.framework.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public class ResultView<E, K> {

    private List<E> list;

    private K nextCursor;

    public ResultView(List<E> list, K nextCursor) {
        this.list = list;
        this.nextCursor = nextCursor;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static final ResultView EMPTY = new ResultView(
            Collections.emptyList(), null);

    @SuppressWarnings("unchecked")
    public static <T1, T2> ResultView<T1, T2> emptyResultView() {
        return ResultView.EMPTY;
    }

    public List<E> getList() {
        return this.list;
    }

    public K getNextCursor() {
        return this.nextCursor;
    }

    public boolean isHasNext() {
        return this.nextCursor != null;
    }

}
