package com.wp.practise.framework.exception;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public class AesDecodeException extends Exception {

    public AesDecodeException() {
        super();
    }

    public AesDecodeException(String msg) {
        super(msg);
    }

    public AesDecodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
