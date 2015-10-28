package br.com.store.application.login;

import javax.servlet.http.HttpServletRequest;

import br.com.store.view.resource.login.Login;

public interface LoginApplication {


    /**
     * Analisa o cookie da requisição e retorna se o usuario esta logado ou não.
     *
     * @param request Objeto de requisição
     * @return o objeto Login
     */
    Login getLogin(HttpServletRequest request);

}
