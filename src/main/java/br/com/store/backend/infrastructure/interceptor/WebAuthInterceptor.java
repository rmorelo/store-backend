package br.com.store.backend.infrastructure.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.store.backend.application.login.LoginApplication;
import br.com.store.backend.infrastructure.annotation.Authentication;
import br.com.store.backend.infrastructure.exception.UnauthorizedException;
import br.com.store.backend.view.resource.login.Login;


/**
 * <p>
 * Interceptor para validação da autenticação do usuário.<br />
 * Ele valida os Cookies da loja.<br />
 * <br />
 * Considera classes ou métodos não anotados como obrigatórios de autenticação.
 * <p/>
 * Caso o usuário <b>não</b> esteja autenticado, lança excessão
 * {@link br.com.store.infrastructure.exception.UnauthorizedException}
 */
@Component
public class WebAuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private LoginApplication loginApplication;

    public WebAuthInterceptor() {}

    public WebAuthInterceptor(LoginApplication service) {
        this.loginApplication = service;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        boolean enabled = isRequired(handlerMethod);

        if (enabled) {
            Login login = loginApplication.getLogin(request);

            if (!login.isLogged()) {
                throw new UnauthorizedException(); 
            }
            /*
            if(login.getIdtPerson() != null){
                Tracker.insert(Tracker.IDT_PERSON, login.getIdtPerson().toString());
                Tracker.insert(Tracker.LOGIN, login.getNamLogin());
                User user = userService.getUser(login.getIdtPerson());
                Tracker.insert(Tracker.USER, user);
            }
            */

        }

        return super.preHandle(request, response, handler);
    }

    private boolean isRequired(HandlerMethod handlerMethod) {

        Method method = handlerMethod.getMethod();
        Class<?> clazz = handlerMethod.getBeanType();
        Class<Authentication> annotation = Authentication.class;

        boolean methodPresent = method.isAnnotationPresent(annotation);
        boolean clazzPresent = clazz.isAnnotationPresent(annotation);
        boolean required;

        if (methodPresent) {
            required = method.getAnnotation(annotation).required();
        } else if (clazzPresent) {
            required = clazz.getAnnotation(annotation).required();
        } else {
            // Se não foi informado na classe ou método o padrão é autenticacao ligada.
            required = true;
        }

        return required;
    }
}
