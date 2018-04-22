package org.estafeta.users;

/**
 * Created by Aleksey Smiyan on 22.04.18.
 */
public class UserAdmin {

    private String login;
    private String password;

    public UserAdmin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
