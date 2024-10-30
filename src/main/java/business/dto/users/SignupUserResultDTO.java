package business.service.users;

import entity.User;

/**
 * {@link SignupUser#execute(SignUpForm)}の結果の出力に用いるオブジェクト。
 * 登録されたユーザーの情報を表すエンティティオブジェクトと登録結果のメッセージをまとめる。
 */
public class SignupUserResultDTO {
    /**
     * 登録されたユーザーの情報を表すエンティティオブジェクト。
     * 処理結果の出力にのみ使用され、変更の必要がないためfinal修飾子を付与している。
     */
    public final User user;

    /**
     * ユーザー登録の結果を表すメッセージ。
     * 処理結果の出力にのみ使用され、変更の必要がないためfinal修飾子を付与している。
     */
    public final String message;

    /**
     * コンストラクタ。
     * 
     * @param user 登録されたユーザーの情報
     * @param message 登録結果のメッセージ
     */
    public SignupUserResultDTO(User user, String message) {
        this.user = user;
        this.message = message;
    }
}