package br.com.store.backend.application.login;

import javax.servlet.http.HttpServletRequest;

import br.com.store.backend.view.resource.login.Login;

public interface LoginApplication {


    /**
     * Analisa o cookie da requisição e retorna se o usuario esta logado ou não.
     *
     * @param request Objeto de requisição
     * @return o objeto Login
     */
    Login getLogin(HttpServletRequest request);

}
