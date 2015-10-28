package br.com.store.domain.service.login;

import javax.servlet.http.HttpServletRequest;

import br.com.store.view.resource.login.Login;

public interface LoginService {

    Login getLogin(HttpServletRequest request);
    
    boolean isLoggedUser(HttpServletRequest request);
}
