package business.service.users;

import business.dto.users.LoginUserResultDTO;
import business.exception.Failure;
import dataaccess.dao.UserDAO;
import dataaccess.entity.User;
import dataaccess.exception.DaoException;
import presentation.form.users.LoginUserForm;

public class LoginUser {
    private final UserDAO userDAO;

    public LoginUser() {
        this.userDAO = new UserDAO();
    }

    /**
     * ログイン処理を実行する
     * 
     * @param form ログイン情報を含むフォーム
     * @return ログイン結果DTO
     * @throws Failure ログインに失敗した場合
     */
    public LoginUserResultDTO execute(LoginUserForm form) throws Failure {
        try {
            // メールアドレスでユーザーを検索
            User user = userDAO.getByEmail(form.getEmail());

            // ユーザーが存在しない場合
            if (user == null) {
                throw new Failure("メールアドレスまたはパスワードが間違っています");
            }

            // パスワードの検証
            if (!verifyPassword(form.getPassword(), user.getPasswordHash())) {
                throw new Failure("メールアドレスまたはパスワードが間違っています");
            }

            // ログイン成功
            return new LoginUserResultDTO(user, "ログインに成功しました");

        } catch (DaoException e) {
            throw new Failure("ログイン処理に失敗しました", e);
        }
    }

    /**
     * パスワードの検証を行う
     * 
     * @param password パスワード
     * @param passwordHash パスワードのハッシュ値
     * @return パスワードが一致する場合はtrue、一致しない場合はfalse
     */
}
