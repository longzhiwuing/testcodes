package com.lzwing.demo.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Enumeration;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@Component
@Order(1)
public class LoggingFilter extends OncePerRequestFilter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(httpServletResponse);

        filterChain.doFilter(requestWrapper, responseWrapper);

        String requestUrl = requestWrapper.getRequestURL().toString();
        HttpHeaders requestHeaders = new HttpHeaders();
        Enumeration headerNames = requestWrapper.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            requestHeaders.add(headerName, requestWrapper.getHeader(headerName));
        }
        HttpMethod httpMethod = HttpMethod.valueOf(requestWrapper.getMethod());
        Map<String, String[]> requestParams = requestWrapper.getParameterMap();

        String requestBody = StreamUtils.copyToString(requestWrapper.getInputStream(), UTF_8);
        //JsonNode requestJson = objectMapper.readTree(requestBody);

        RequestEntity<String> requestEntity = new RequestEntity(requestBody, requestHeaders, httpMethod, URI.create(requestUrl));
        log.info("requestParams:{},requestEntity:{}",requestParams,requestEntity);


        HttpStatus responseStatus = HttpStatus.valueOf(responseWrapper.getStatusCode());
        HttpHeaders responseHeaders = new HttpHeaders();
        for (String headerName : responseWrapper.getHeaderNames()) {
            responseHeaders.add(headerName, responseWrapper.getHeader(headerName));
        }
        String responseBody = StreamUtils.copyToString(responseWrapper.getContentInputStream(), UTF_8);
        //JsonNode responseJson = objectMapper.readTree(responseBody);
        ResponseEntity<String> responseEntity = new ResponseEntity(responseBody, responseHeaders, responseStatus);
        log.info("responseEntity:{}",responseEntity);
        responseWrapper.copyBodyToResponse();
    }
}