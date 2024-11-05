package presentation.form.users;

/**
 * ログインフォームのデータを保持するクラス
 */
public class LoginUserForm {
    public final String email;
    public final String password;

    public LoginUserForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}