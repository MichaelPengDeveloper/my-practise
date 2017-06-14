package com.wp.practise.framework.cursor;

import com.google.common.collect.ImmutableMap;
import com.wp.practise.framework.encrypt.AES;
import com.wp.practise.framework.encrypt.AesConstants;
import com.wp.practise.framework.exception.AesDecodeException;
import com.wp.practise.framework.model.HasId;
import com.wp.practise.model.User;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public class CursorUtils {

    private static ImmutableMap<Class<?>,AES> aesImmutableMap;

    static {
        aesImmutableMap = ImmutableMap.<Class<?>, AES>builder()
                .put(User.class,new AES(AesConstants.USER_KEY))
                .build();
    }

    public static <N extends Number, T extends HasId<N>> String getCursor(Class<T> clazz, N id) {
        AES aes = aesImmutableMap.get(clazz);
        if (aes == null) {
            throw new RuntimeException("no aes key for:" + clazz);
        }
        return aes.encodeBase64URLSafeStringLong(id.longValue());
    }

    public static <N extends Number, T extends HasId<N>> Number getId(Class<T> clazz, String cursor) throws AesDecodeException {
        return aesImmutableMap.get(clazz).decodeBase64Long(StringUtils.trim(cursor));
    }

}
