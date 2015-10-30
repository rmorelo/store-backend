package br.com.store.backend.infrastructure.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation para habilitar/desabilitar a checagem de autencitação ({@link br.com.store.backend.infrastructure.interceptor.WebAuthInterceptor}). <br/>
 * Caso o método no Controller esteja anotado a verificação será efetuada.
 * 
 * @see br.com.store.frontend.infrastructure.interceptor.sac.infrastructure.interceptor.WebAuthInterceptor
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Authentication {

    /**
     * Habilita/desabilita checagem de autenticação.
     */
    boolean required() default true;

}
