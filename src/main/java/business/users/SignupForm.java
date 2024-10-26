package business.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SignUpForm {
    // このクラスから作成されたオブジェクトはコントロールへの入力の際に一度用いられるのみなので、各フィールドが変更可能である必要はない。
    // そこで、`private`修飾子付きのフィールドとゲッターメソッドを定義する代わりに、
    // 各フィールドに`final`修飾子を付けることで、読み取り専用の変更不可能なフィールドを定義している。

    public final String name;
    public final String email;
    public final String password;
    public final String confirmPassword;
    private Map<String, String> errors;

    // コンストラクタ
    public SignUpForm(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    // バリデーションを行うメソッド（名前が空でないこと。メースアドレスが有効な形なこと。パスワードが半角英数8-20なこと。確認パスワードが一致すること。）
    public boolean validate() {
        boolean isValid = true;
        Map<String, String> errors = new HashMap<>();

        if (name == null || name.trim().isEmpty()) {
            errors.put("name", "Name is required");
            isValid = false;
        }

        if (email == null || email.trim().isEmpty()) {
            errors.put("email", "Email is required");
            isValid = false;
        } else if (!email.contains("@") || !email.contains(".")) {
            errors.put("email", "Invalid email format");
            isValid = false;
        }

        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "Password is required");
            isValid = false;
        } else if (password.length() < 8 || password.length() > 20) {
            errors.put("password", "Password must be between 8 and 20 characters long");
            isValid = false;
        }

        if (confirmPassword == null || !confirmPassword.equals(password)) {
            errors.put("confirmPassword", "Passwords do not match");
            isValid = false;
        }

        return isValid;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}