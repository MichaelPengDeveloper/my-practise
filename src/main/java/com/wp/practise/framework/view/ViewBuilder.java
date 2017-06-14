package com.wp.practise.framework.view;

import com.wp.practise.framework.cursor.HasCursor;
import com.wp.practise.framework.model.HasId;
import com.wp.practise.framework.model.JsonResultView;
import com.wp.practise.framework.model.ResultView;
import com.wp.practise.framework.view.builder.ModelBuilder;
import com.wp.practise.framework.view.builder.context.impl.MyBuildContext;
import com.wp.practise.framework.view.builder.impl.SimpleModelBuilder;
import com.wp.practise.framework.view.mapper.ViewMapper;
import com.wp.practise.model.User;
import com.wp.practise.service.UserService;
import com.wp.practise.util.logger.InvestLogger;
import com.wp.practise.util.logger.InvestLoggerFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wang Peng on 2017/6/14.
 */
@Lazy
@Service
public class ViewBuilder {
    private static volatile ViewMapper mapper;
    private InvestLogger logger = InvestLoggerFactory.getLogger(getClass());
    private ModelBuilder<MyBuildContext> modelBuilder;

    @Autowired
    private UserService userService;

    private static ViewMapper mapper() {
        if (mapper == null) {
            synchronized (ViewMapper.class) {
                if (mapper == null) {
                    mapper = ViewerScanner.scan("com.wp.practise.view");
                }
            }
        }
        return mapper;
    }
    @PostConstruct
    private void init(){
        modelBuilder =  new SimpleModelBuilder<MyBuildContext>()
        .valueFromSelf(User.class,User::getId)
        ;
    }

    public <E> JsonResultView buildSingle(E item, String key) {
        return build(Collections.singletonList(item), key);
    }

    public <E> JsonResultView buildSingleWithParam(E item, String key, Map<String, Object> params) {
        return buildWithParam(Collections.singletonList(item), key, params);
    }

    @SuppressWarnings("unchecked")
    private <E, K> Map<String, Object> buildSingleToMap(E item, String key) {
        Map<String, Object> rawListMap = buildToMap(
                new ResultView<E, K>(Collections.singletonList(item), null), key, null);
        Map<String, Object> data = new HashMap<>();
        data.put(key, ((List<?>) ((Map<String, Object>) rawListMap.get(key)).get("list")).get(0));
        return data;
    }

    public <E, K> JsonResultView build(List<E> item, String key) {
        return build(new ResultView<E, K>(item, null), key);
    }

    public <E, K> JsonResultView buildWithParam(List<E> item, String key, Map<String, Object> params) {
        return buildWithParam(new ResultView<E, K>(item, null), key, params);
    }

    public JsonResultView build(Map<?, ?> map) {
        return new JsonResultView(map);
    }


    public <E, K> Map<String, Object> buildToMap(ResultView<E, K> resultView,
                                                 String key) {
        return buildToMap(resultView, key, null, null);
    }

    private <E, K> Map<String, Object> buildToMap(ResultView<E, K> resultView, String key,
                                                  Map<String, Object> params) {
        return this.buildToMap(resultView, key, params, null);
    }

    public <E, V> List<V> mapList(List<E> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }

        MyBuildContext myBuildContext = new MyBuildContext();
        //myBuildContext.setVisitor(RequestContext.getUserId());

        modelBuilder.buildMulti(list, myBuildContext);

        ViewMapper viewMapper = mapper();
        return viewMapper.map(list, myBuildContext);
    }

    @SuppressWarnings("unchecked")
    private <E, K> Map<String, Object> buildToMap(ResultView<E, K> resultView, String key,
                                                  Map<String, Object> params, ViewMapper viewMapper) {
        MyBuildContext myBuildContext = new MyBuildContext();
        //myBuildContext.setVisitor(RequestContext.getUserId());

        List<E> list = resultView.getList();

        modelBuilder.buildMulti(list, myBuildContext);
        if (viewMapper == null) {
            viewMapper = mapper();
        }

        List<Object> views = viewMapper.map(list, myBuildContext);

        Map<String, Object> data = new HashMap<>();//final result
        Map<String, Object> indexes = new HashMap<>();//used for list and cursor

        indexes.put("list", views);
        if (resultView.getNextCursor() != null) {
            K nextCursor = resultView.getNextCursor();
            if (nextCursor instanceof HasCursor) {
                indexes.put("nextCursor", ((HasCursor) nextCursor).getCusor());
            } else if (nextCursor instanceof HasId) {
                indexes.put("nextCursor", ((HasId) nextCursor).getId());
            } else {
                indexes.put("nextCursor", nextCursor);
            }
        }
//        indexes.put("hasNext", resultView.isHasNext());
        data.put(key, indexes);
        if (MapUtils.isNotEmpty(params)) {
            data.putAll(params);
        }
        return data;
    }

    public <E, K> JsonResultView buildWithParam(ResultView<E, K> resultView,
                                                String key, Map<String, Object> params) {
        return new JsonResultView(buildToMap(resultView, key, params, null));
    }

    public <E, K> JsonResultView build(ResultView<E, K> resultView, String key) {
        return new JsonResultView(buildToMap(resultView, key, null, null));
    }

}
