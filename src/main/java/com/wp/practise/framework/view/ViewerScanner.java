package com.wp.practise.framework.view;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.wp.practise.framework.view.builder.context.impl.MyBuildContext;
import com.wp.practise.framework.view.mapper.ViewMapper;
import com.wp.practise.framework.view.mapper.impl.DefaultViewMapperImpl;
import com.wp.practise.util.logger.InvestLogger;
import com.wp.practise.util.logger.InvestLoggerFactory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public final class ViewerScanner {

    private static final InvestLogger logger = InvestLoggerFactory.getLogger(ViewerScanner.class);

    public static final ViewMapper scan(String pkg) {
        return sacn(pkg, Collections.emptySet());
    }

    public static final ViewMapper sacn(String pkg, Set<Class<?>> ignoreViews) {
        DefaultViewMapperImpl viewMapper = new DefaultViewMapperImpl();
        try {
            ImmutableSet<ClassPath.ClassInfo> topLevelClasses = ClassPath.from(
                    ViewerScanner.class.getClassLoader()).getTopLevelClassesRecursive(pkg);
            for (ClassPath.ClassInfo classInfo : topLevelClasses) {
                Class<?> type = classInfo.load();
                if (ignoreViews.contains(type)) {
                    continue;
                }
                Constructor<?>[] constructors = type.getConstructors();
                for (Constructor<?> constructor : constructors) {
                    Class<?>[] parameterTypes = constructor.getParameterTypes();
                    if (parameterTypes.length == 2 && parameterTypes[1] == MyBuildContext.class) {
                        logger.info("register view [{}] for model [{}], with buildContext.",
                                type.getSimpleName(), parameterTypes[0].getSimpleName());
                        viewMapper.addMapper(parameterTypes[0], (buildContext, i) -> {
                            try {
                                return constructor.newInstance(i, buildContext);
                            } catch (Exception e) {
                                logger.error("fail to construct model:{}", i, e);
                                return null;
                            }
                        });
                    }
                    if (parameterTypes.length == 1) {
                        logger.info("register view [{}] for model [{}]", type.getSimpleName(),
                                parameterTypes[0].getSimpleName());
                        viewMapper.addMapper(parameterTypes[0], (buildContext, i) -> {
                            try {
                                return constructor.newInstance(i);
                            } catch (Exception e) {
                                logger.error("fail to construct model:{}", i, e);
                                return null;
                            }
                        });
                    }
                }
            }
        } catch (IOException e) {
            logger.error("Ops.", e);
        }
        return viewMapper;
    }

}
