package com.wp.practise.framework.model;

import com.wp.practise.framework.meta.Meta;
import com.wp.practise.framework.util.ObjectMapperUtils;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public class JsonResultView {

    private final Meta meta;

    private final Map<?, ?> data;

    public static final JsonResultView SUCCESS = new JsonResultView();

    public JsonResultView(Meta.MetaCode metaCode, Map<?, ?> data) {
        this.meta = new Meta(metaCode);
        this.data = data;
    }

    public JsonResultView(Meta meta, Map<?, ?> data) {
        this.meta = meta;
        this.data = data;
    }

    private JsonResultView() {
        this(Collections.emptyMap());
    }

    public JsonResultView(Meta.MetaCode metaCode) {
        this(metaCode, Collections.emptyMap());
    }

    public JsonResultView(Map<?, ?> data) {
        this(Meta.MetaCode.Success, data);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public JsonResultView add(String key, Object value) {
        ((Map) data).put(key, value);
        return this;
    }

    public Map<?, ?> getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return ObjectMapperUtils.toJSON(this);
    }

}
