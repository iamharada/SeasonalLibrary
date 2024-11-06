package presentation.form.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SignupUserForm {
    // このクラスから作成されたオブジェクトはコントロールへの入力の際に一度用いられるのみなので、各フィールドが変更可能である必要はない。
    // そこで、`private`修飾子付きのフィールドとゲッターメソッドを定義する代わりに、
    // 各フィールドに`final`修飾子を付けることで、読み取り専用の変更不可能なフィールドを定義している。

    public final String name;
    public final String email;
    public final String password;
    public final String confirmPassword;

    // コンストラクタ
    public SignupUserForm(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
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