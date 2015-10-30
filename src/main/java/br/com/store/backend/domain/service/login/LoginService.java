package br.com.store.backend.domain.service.login;

import javax.servlet.http.HttpServletRequest;

import br.com.store.backend.view.resource.login.Login;

public interface LoginService {

    Login getLogin(HttpServletRequest request);
    
    boolean isLoggedUser(HttpServletRequest request);
}
