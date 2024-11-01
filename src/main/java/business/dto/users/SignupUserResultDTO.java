package business.dto.users;

import dataaccess.entity.User;

/**
 * {@link SignupUser#execute(SignUpForm)}の結果の出力に用いるオブジェクト。
 * 登録されたユーザーの情報を表すエンティティオブジェクトと登録結果のメッセージをまとめる。
 */
public class SignUpUserResultDTO {
    // 登録されたユーザーの情報を表すエンティティオブジェクト
    public final User user;

    // ユーザー登録の結果を表すメッセージ。
    public final String message;

    // コンストラクタ
    public SignUpUserResultDTO(User user, String message) {
        this.user = user;
        this.message = message;
    }

    // getter
    public User getUser() {
        return user;
    }
}