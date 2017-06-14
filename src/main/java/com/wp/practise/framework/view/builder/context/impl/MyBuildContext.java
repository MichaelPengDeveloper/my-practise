package com.wp.practise.framework.view.builder.context.impl;

import java.lang.reflect.Constructor;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public class MyBuildContext extends SimpleBuildContext {

    private Integer visitor;

    public Integer getVisitor() {
        return visitor;
    }

    public void setVisitor(Integer visitor) {
        this.visitor = visitor;
    }

    public <K, S> S build(K k, Class<S> sClazz) {
        if (k == null) {
            return null;
        }
        return getData(sClazz).get(k);
    }

    /**
     * 该方法有一定耦合性，需要rClass的构造器是特定类型 参考UserView构造器
     *
     */
    public <K, S, R> R build(K k, Class<S> sClazz, Class<R> rClazz) {
        try {
            S s = build(k, sClazz);

            if (s == null) {
                return null;
            }

            Constructor<?>[] constructors = rClazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 2) {

                    if (parameterTypes[0] == sClazz && parameterTypes[1] == MyBuildContext.class)
                        return (R) constructor.newInstance(s, this);
                    else if (parameterTypes[0] == MyBuildContext.class && parameterTypes[1] == sClazz)
                        return (R) constructor.newInstance(this, s);

                } else if (parameterTypes.length == 1 && parameterTypes[0] == sClazz) {
                    return (R) constructor.newInstance(s);
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <K, R> R build(K k, String mk, Class<R> rClazz) {
        try {
            if (k == null) {
                return null;
            }
            Object s = getData(mk).get(k);

            if (s == null || s.getClass() == rClazz) {
                return s == null ? null : (R) s;
            }

            Constructor<?>[] constructors = rClazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 2) {

                    if (parameterTypes[0] == s.getClass() && parameterTypes[1] == MyBuildContext.class)
                        return (R) constructor.newInstance(s, this);
                    else if (parameterTypes[0] == MyBuildContext.class && parameterTypes[1] == s.getClass())
                        return (R) constructor.newInstance(this, s);

                } else if (parameterTypes.length == 1 && parameterTypes[0] == s.getClass()) {
                    return (R) constructor.newInstance(s);
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

}
