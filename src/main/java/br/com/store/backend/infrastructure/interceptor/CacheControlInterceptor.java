package br.com.store.backend.infrastructure.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * <p>
 * Interceptor utilizado para atribuir o controle de cache as chamadas de serviços da aplicação.<br />
 * Nenhum cache deve ser permitido.
 * <p/>
 */
@Component
public class CacheControlInterceptor extends HandlerInterceptorAdapter {

    private static final String CACHE_CONTROL = "private, max-age=0, no-cache, must-revalidate";
    private static final String NO_CACHE = "no-cache";
    private static final String SOMEWHERE_IN_THE_PAST = "Wed, 31 Dec 1969 21:00:00 GMT";

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        response.addHeader("Cache-Control", CACHE_CONTROL); // HTTP 1.1
        response.addHeader("Pragma", NO_CACHE); // HTTP 1.0
        response.addHeader("Expires", SOMEWHERE_IN_THE_PAST);

        super.postHandle(request, response, handler, modelAndView);
    }

}
