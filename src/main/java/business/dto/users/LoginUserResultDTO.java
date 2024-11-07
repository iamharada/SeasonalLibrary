package business.dto.users;

import dataaccess.entity.User;

/**
 * {@link LoginUser#execute(LoginUserForm)}の結果の出力に用いるオブジェクト。
 * ログインに成功したユーザーの情報を表すエンティティオブジェクトとログイン結果のメッセージをまとめる。
 */
public class LoginUserResultDTO {
    // ログインに成功したユーザーの情報を表すエンティティオブジェクト
    public final User user;

    // ログインの結果を表すメッセージ
    public final String message;

    // コンストラクタ
    public LoginUserResultDTO(User user, String message) {
        this.user = user;
        this.message = message;
    }

    // getter
    public User getUser() {
        return user;
    }
}
