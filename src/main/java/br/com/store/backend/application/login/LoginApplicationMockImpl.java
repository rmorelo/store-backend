package br.com.store.backend.application.login;

import javax.servlet.http.HttpServletRequest;

import org.perf4j.aop.Profiled;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.login.Login;

@Service
@Profile("test")
public class LoginApplicationMockImpl implements LoginApplication {
    
    public static final String MOCK_IDT_PERSON_PARAM = "user.mock.idtperson";

    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Login getLogin(HttpServletRequest request) {
        Login login = new Login();
        login.setLogged(true);
        return login;
    }

}
