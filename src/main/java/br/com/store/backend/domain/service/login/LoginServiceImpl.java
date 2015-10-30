package br.com.store.backend.domain.service.login;

import javax.servlet.http.HttpServletRequest;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.repository.login.LoginRepository;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.login.Login;


@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepository repository;
    
    @Profiled (level = Profiling.SERVICE)
    public Login getLogin(HttpServletRequest request) {
        repository.getLogin(request);
        return null;
        
    }

    @Override
    public boolean isLoggedUser(HttpServletRequest request) {
        return repository.isLoggedUser(request);
    }

}
