package br.com.store.domain.repository.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginRepository {

    /**
     * Executa o serviço do Xangai e verifica se o usuario esta logado na
     * requisição
     *
     * @param request
     * @return {@link UserAuthorization } preenchido com os valores do Cookie da
     *         requisicao. <br />
     *         null caso o cookie esteja invalido ou o usuario nao esteja
     *         logado.
     */
    void getLogin(HttpServletRequest request);

    boolean isLoggedUser(HttpServletRequest request);

}
