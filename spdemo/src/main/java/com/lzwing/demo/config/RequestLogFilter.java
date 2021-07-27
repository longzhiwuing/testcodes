package com.lzwing.demo.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;

/**
 * 打印请求日志，默认打印get放，只打印POST、PUT、DELETE方法的请求日志哦~
 * 会计算出请求耗时、client请求的ip地址等等  contentType也会记录打印出来 信息比较全 方便查找问题~
 *
 * @author chenzhongyong
 * @description
 * @date 2019-02-16 22:04
 */
@Slf4j
@Order(2)
public class RequestLogFilter extends AbstractRequestLoggingFilter {

    //这些配置都可以在init-param中进行设置,但是基于注解的，这里就不要这么麻烦了，统一在初始化的时候设置值吧
    //private boolean includeQueryString = false;
    //private boolean includeClientInfo = false;
    //private boolean includeHeaders = false;
    //private boolean includePayload = false;
    private static final String PROCESS_START_TIME_SUFFIX = ".PROCESS_START_TIME";

    private ContentCachingResponseWrapper responseWrapper;

    /**
     * 最大支持到1000个字符
     */
    private static final int MAX_SHOW_LENGH = 1000;

    @Override
    protected void initFilterBean() throws ServletException {
        super.setIncludeQueryString(true);
        super.setIncludeClientInfo(true);
        //因为headers里面的信息太多了 所以这里不输出了，否则过于干扰，只手动把content-type等关键信息输出即可
        super.setIncludeHeaders(false);
        super.setIncludePayload(true);
        super.setMaxPayloadLength(MAX_SHOW_LENGH);

        //头信息
        super.setBeforeMessagePrefix("请求开始 [");
        super.setBeforeMessageSuffix("]");
        super.setAfterMessagePrefix("请求结束 [");
        super.setAfterMessageSuffix("]");

    }

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return true;
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        log.info(calcRequestTime(request)
                .concat(getConfigTypeLog(request))
                .concat(getThreadId())
                .concat(message));
    }

    @SneakyThrows
    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        log.info(calcRequestTime(request)
                .concat(getConfigTypeLog(request))
                .concat(getThreadId())
                .concat(getRespContent())
                .concat(message));
        responseWrapper.copyBodyToResponse();
    }

    @SneakyThrows
    private String getRespContent() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletResponse response = ((ServletRequestAttributes)requestAttributes).getResponse();
        responseWrapper = new ContentCachingResponseWrapper(response);
        byte[] responseArray = responseWrapper.getContentAsByteArray();
        String content = new String(responseArray, responseWrapper.getCharacterEncoding());
        return String.format("response code:【%s】,content:【%s】", response.getStatus(), content);
    }

    //拼装contentType
    private String getConfigTypeLog(HttpServletRequest request) {
        String contentType = request.getContentType();
        String method = request.getMethod();
        return "[contentType=" + contentType + "] " + method.toUpperCase() + " ";
    }

    //计算请求耗时
    private String calcRequestTime(HttpServletRequest request) {
        long mills = 0;
        String requestTimeUniqueName = getRequestTimeUniqueName();

        Object processStartTime = request.getAttribute(requestTimeUniqueName);
        if (processStartTime == null) {
            //首次 放置值
            request.setAttribute(requestTimeUniqueName, Instant.now());
        } else { //请求结束的处理  开始计算吧
            Instant start = (Instant) processStartTime;
            Instant now = Instant.now();
            mills = Duration.between(start, now).toMillis();
			
            request.removeAttribute(requestTimeUniqueName);
        }
        return mills == 0 ? "" : ("[耗时:" + mills + "ms] ");

    }

    private String getRequestTimeUniqueName() {
        return this.getClass().getName().concat(PROCESS_START_TIME_SUFFIX);
    }

    private String getThreadId() {
        return "[ThreadId:" + Thread.currentThread().getId() + "] ";
    }

}