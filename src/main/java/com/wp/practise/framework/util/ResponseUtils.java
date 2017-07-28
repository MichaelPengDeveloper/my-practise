package com.wp.practise.framework.util;

import com.wp.practise.framework.model.JsonResultView;
import com.wp.practise.util.logger.InvestLogger;
import com.wp.practise.util.logger.InvestLoggerFactory;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Wangpeng on 2017/7/27.
 */
public class ResponseUtils {

    private static final InvestLogger logger = InvestLoggerFactory.getLogger(ResponseUtils.class);

    public static void output(HttpServletResponse response, JsonResultView jsonResultView) {
        output(response, jsonResultView.toString());
    }

    /**
     * 输出指定字符串
     *
     */
    public static void output(HttpServletResponse response, String text) {
        try {
            if (StringUtils.startsWith(text, "{") && StringUtils.endsWith(text, "}")) {
                logger.trace("set content type to json:" + text);
                response.setContentType("application/json; charset=utf-8");
            } else {
                response.setContentType("text/html;charset=utf-8");
            }
            PrintWriter pw = response.getWriter();
            if (pw == null) {
                return;
            }
            pw.print(text);
            pw.flush();
            pw.close();
        } catch (Exception e) {
            logger.error("output(HttpServletResponse, String)", e); //$NON-NLS-1$
        }
    }

}
