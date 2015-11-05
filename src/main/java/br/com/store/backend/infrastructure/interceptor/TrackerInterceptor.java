package br.com.store.backend.infrastructure.interceptor;

import br.com.store.backend.infrastructure.tracking.Tracker;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TrackerInterceptor extends HandlerInterceptorAdapter {

    protected static final String REQUEST_ID = "X-Request-Id";
    protected static final String SKIN = "X-Skin";
    protected static final String FORWARDED_FOR = "X-Forwarded-For";
    protected static final String FORWARDED_PORT = "X-Forwarded-Port";
    protected static final String VALIDATION_VERSION = "X-Validation-Version";
    protected static final String BROWSER_IP = "Browser-IP";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        handleRequestId(request);

        return super.preHandle(request, response, handler);
    }

    private void handleRequestId(HttpServletRequest request) {

        Tracker.clear();
        Tracker.insert(Tracker.REQUEST, getRequestId(request));        
        Tracker.insert(Tracker.IP, getForwardedFor(request));
        Tracker.insert(Tracker.PORT, getPort(request));
        Tracker.insert(Tracker.URI, getRequestURI(request));
        Tracker.insert(Tracker.VALIDATION_VERSION, getValidationVersion(request));
        Tracker.insert(Tracker.IP, getBrowserIp(request));
    }

    private String getRequestId(HttpServletRequest request) {

        String requestTracker = request.getHeader(REQUEST_ID);
        if (requestTracker == null) {
            requestTracker = Tracker.createTrackerId();
        }

        return requestTracker;
    }

    private String getPort(HttpServletRequest request) {
        return request.getHeader(FORWARDED_PORT);
    }

    private String getForwardedFor(HttpServletRequest request) {
        return request.getHeader(FORWARDED_FOR);
    }
    
    private String getBrowserIp(HttpServletRequest request) {
        return request.getHeader(BROWSER_IP);
    }

    private String getRequestURI(HttpServletRequest request) {

        return request.getRequestURI();
    }

    private String getValidationVersion(HttpServletRequest request) {

        return request.getHeader(VALIDATION_VERSION);
    }

}
