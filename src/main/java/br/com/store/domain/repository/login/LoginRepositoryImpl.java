package br.com.store.domain.repository.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.perf4j.aop.Profiled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.store.infrastructure.profiling.Profiling;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    private static Logger LOG = LoggerFactory.getLogger(LoginRepositoryImpl.class);


    @Profiled(level = Profiling.REPOSITORY)
    public void getLogin(HttpServletRequest request) {

    }

    @Profiled(level = Profiling.REPOSITORY)
    public boolean isLoggedUser(HttpServletRequest request) {
        this.getLogin(request);
        return true;
    }


}
