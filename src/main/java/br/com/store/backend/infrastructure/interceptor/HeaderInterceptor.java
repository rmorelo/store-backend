package br.com.store.backend.infrastructure.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.store.backend.infrastructure.exception.BadRequestException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HeaderInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        checkMandatoryHeaders(request);
        return super.preHandle(request, response, handler);
    }

    private void checkMandatoryHeaders(HttpServletRequest request) {

        if(StringUtils.isBlank(request.getHeader(TrackerInterceptor.VALIDATION_VERSION))) {
            throw new BadRequestException(BadRequestEnum.HEADERS_VALIDATION_NULL);
        }
        if(StringUtils.isBlank(request.getHeader(TrackerInterceptor.BROWSER_IP))) {
            throw new BadRequestException(BadRequestEnum.HEADERS_BROWSER_IP_NULL);
        }
        if(StringUtils.isBlank(request.getHeader(TrackerInterceptor.REQUEST_ID))) {
            throw new BadRequestException(BadRequestEnum.HEADERS_REQUEST_ID_NULL);
        }
        if(StringUtils.isBlank(request.getHeader("Content-Type"))) {
            throw new BadRequestException(BadRequestEnum.HEADERS_CONTENT_TYPE_NULL);
        }
    }

}
