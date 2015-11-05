package br.com.store.backend.infrastructure.rest.selector;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.store.backend.infrastructure.exception.BadRequestException;
import br.com.store.backend.infrastructure.rest.errors.BadRequestEnum;

@Component
public class SelectorValidatorInterceptor extends HandlerInterceptorAdapter {

    public static final String SELECTOR = "selector";
    public static final String METHOD_NAME = "getSelectableResources";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        if (handler instanceof HandlerMethod) {
            Selector annotation = ((HandlerMethod) handler).getMethod().getAnnotation(Selector.class);
            if(annotation!=null) {
                Class<?> resource = annotation.resource();
                Method method = resource.getMethod(METHOD_NAME);

                if (hasInvalidSelectors(request, method)) {
                    throw new BadRequestException(BadRequestEnum.INVALID_SELECTOR);
                }
            }
        }

        return super.preHandle(request, response, handler);
    }

    @SuppressWarnings("unchecked")
    private boolean hasInvalidSelectors(HttpServletRequest request, Method method) throws IllegalAccessException, InvocationTargetException {
        String param = request.getParameter(SELECTOR);
        if (param == null) {
            return false;
        }
        List<String> permittedSelectors = (List<String>) method.invoke(null);
        List<String> paramSelectors = Arrays.asList(param.split("\\s*,\\s*"));
        for (String selector : paramSelectors) {
            if (!permittedSelectors.contains(selector)) {
                return true;
            }
        }
        return false;
    }
    
}

