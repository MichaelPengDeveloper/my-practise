package com.wp.practise.framework.meta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wp.practise.framework.model.JsonResultView;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public class Meta {

    public enum MetaCode {
        Success(1, "操作成功"),
        Fail(-1, "操作失败"),
        ArgNotMatch(400, "请求参数不正确"),
        Unauthorized(401, "用户未登录"),
        Forbidden(403, "没有权限"),
        UrlNotFound(404, "访问url不存在"),
        RequestMethodNotSupported(405, "请求方式不支持"),
        PartFail(406, "部分数据操作失败"),
        ServerFailed(500, "服务器内部错误"),
        LoginFailed(40000, "登录失败"),
        UnRealName(40001, "未实名认证"),
        UnBindCard(40002, "未绑定银行卡"),
        UnSetPayPassword(40003, "未设置支付密码"),
        UserFrozen(40004, "账户已冻结"),
        StandardNotEnough(50001, "标的剩余可投金额不足"),
        ;

        private final int code;

        private String message;

        MetaCode(int code, String message) {
            this.code = code;
            this.message = message;
        }
        public int getCode() {
            return code;
        }
        public String getMessage() {
            return message;
        }

        public JsonResultView withMessage(String message) {
            Meta meta = new Meta(this, message);
            return new JsonResultView(meta, Collections.emptyMap());
        }

        public JsonResultView withMessageAndData(String message, Map<String, Object> data) {
            Meta meta = new Meta(this, message);
            return new JsonResultView(meta, data);
        }


        public JsonResultView toView() {
            return new JsonResultView(this, Collections.emptyMap());
        }
    }

    private String message;

    public Meta(MetaCode code) {
        this.code = code;
    }

    public Meta(MetaCode code, String message) {
        this.code = code;
        this.message = message;
    }

    private final MetaCode code;

    public int getCode() {
        return code.code;
    }

    public String getMessage() {
        return message == null ? code.message : message;
    }

    public Long getTimeStamp() {
        return System.currentTimeMillis();
    }

   /* @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getCost() {
        Long r = RequestContext.getRequestTimeStamp();
        return System.currentTimeMillis() - r;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getHostName() {
        return HostInfo.HostName;
    }

    @Override
    public String toString() {
        return ObjectMapperUtils.toJSON(this);
    }*/

}
