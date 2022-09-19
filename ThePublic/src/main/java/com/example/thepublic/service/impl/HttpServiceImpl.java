package com.example.thepublic.service.impl;



import com.example.thepublic.exception.MyHttpException;
import com.example.thepublic.service.HttpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HttpServiceImpl implements HttpService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * get请求
     *
     * @param url
     * @param body 请求参数
     * @return
     */
    @Override
    public ResponseEntity<String> get(String url, Object body) throws MyHttpException {
        return get(url, body, null);
    }

    /**
     * get请求
     *
     * @param url
     * @param body    请求参数
     * @param headers 请求头
     * @return
     */
    @Override
    public ResponseEntity<String> get(String url, Object body, MultiValueMap<String, String> headers) throws MyHttpException {
        return request(url, body, headers, HttpMethod.GET);
    }

    /**
     * post请求
     *
     * @param url
     * @param body 请求参数
     * @return
     */
    @Override
    public ResponseEntity<String> post(String url, Object body) throws MyHttpException {
        return post(url, body, null);
    }

    /**
     * post请求
     *
     * @param url
     * @param body    请求参数
     * @param headers 请求头
     * @return
     */
    @Override
    public ResponseEntity<String> post(String url, Object body, MultiValueMap<String, String> headers) throws MyHttpException {
        return request(url, body, headers, HttpMethod.POST);
    }

    /**
     * put请求
     *
     * @param url
     * @param body 请求参数
     * @return
     */
    @Override
    public ResponseEntity<String> put(String url, Object body) throws MyHttpException {
        return put(url, body, null);
    }

    /**
     * put请求
     *
     * @param url
     * @param body    请求参数
     * @param headers 请求头
     * @return
     */
    @Override
    public ResponseEntity<String> put(String url, Object body, MultiValueMap<String, String> headers) throws MyHttpException {
        return request(url, body, headers, HttpMethod.PUT);
    }


    /**
     * put请求
     *
     * @param url
     * @param body 请求参数
     * @return
     */
    @Override
    public ResponseEntity<String> patch(String url, Object body) throws MyHttpException {
        return patch(url, body, null);
    }

    /**
     * patch
     *
     * @param url
     * @param body    请求参数
     * @param headers 请求头
     * @return
     */
    @Override
    public ResponseEntity<String> patch(String url, Object body, MultiValueMap<String, String> headers) throws MyHttpException {
        return request(url, body, headers, HttpMethod.PATCH);
    }

    /**
     * delete请求
     *
     * @param url
     * @param body 请求参数
     * @return
     */
    @Override
    public ResponseEntity<String> delete(String url, Object body) throws MyHttpException {
        return delete(url, body, null);
    }

    /**
     * delete请求
     *
     * @param url
     * @param body    请求参数
     * @param headers 请求头
     * @return
     */
    @Override
    public ResponseEntity<String> delete(String url, Object body, MultiValueMap<String, String> headers) throws MyHttpException {
        return request(url, body, headers, HttpMethod.DELETE);
    }

    /**
     * 表单请求
     *
     * @param url
     * @param body    请求主体
     * @param headers 请求头
     * @param method  请求方式
     * @return
     */
    @Override
    public ResponseEntity<String> request(String url, Object body, MultiValueMap<String, String> headers, HttpMethod method) throws MyHttpException {
        if (body == null) {
            body = new LinkedMultiValueMap<>();
        }
        return request(url, body, headers, method, MediaType.APPLICATION_JSON_UTF8, "S", "S");
    }

    /**
     * http请求
     *
     * @param url
     * @param body      请求参数
     * @param headers   请求头
     * @param method    请求方式
     * @param mediaType 参数类型
     * @return
     */
    public ResponseEntity<String> request(String url, Object body, MultiValueMap<String, String> headers, HttpMethod method, MediaType mediaType, String form, String to) throws MyHttpException {
        if (url == null || url.trim().isEmpty()) {
            return null;
        }
        String message = null;
        Integer statusCode = null;
        try {
            RestTemplate client = restTemplate;
            HttpHeaders httpHeaders = new HttpHeaders();
            if (headers != null) {
                httpHeaders.addAll(headers);
            }
            if (StringUtils.isEmpty(httpHeaders.getFirst(HttpHeaders.CONTENT_TYPE))) {
                httpHeaders.setContentType(mediaType);
            }
            log.info("S->API {} {} {}", method.name(), url, body);
            log.info("requestBody:{}", body);
            HttpEntity httpEntity = new HttpEntity<>(body, httpHeaders);
            ResponseEntity<String> response = client.exchange(url, method, httpEntity, String.class);
            String responseBody = response.getBody();
            message = responseBody;
            statusCode = response.getStatusCode().value();
            return response;
        } catch (HttpClientErrorException e) {
            String preface = e.getStatusCode().value() + " " + e.getStatusText() + ": [";
            message = StringUtils.removeStart(message, preface);
            message = StringUtils.removeEnd(message, "]");
            statusCode = e.getStatusCode().value();
            throw new MyHttpException(e.getStatusCode().value(), message);
        } catch (Exception e) {
            message = e.getMessage();
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
            throw new MyHttpException(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        } finally {
            log.info("response:{} {}", statusCode, message);
        }
    }
}