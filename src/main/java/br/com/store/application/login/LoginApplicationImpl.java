package br.com.store.application.login;

import javax.servlet.http.HttpServletRequest;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.store.domain.service.login.LoginService;
import br.com.store.infrastructure.profiling.Profiling;
import br.com.store.view.resource.login.Login;


@Service
@Profile("prod")
public class LoginApplicationImpl implements LoginApplication {

    @Autowired
    private LoginService loginService;

    @Override
    @Profiled (level = Profiling.APPLICATION)
    public Login getLogin(HttpServletRequest request) {

        return loginService.getLogin(request);
    }
}
