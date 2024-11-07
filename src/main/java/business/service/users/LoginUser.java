package business.service.users;

import business.dto.users.LoginUserResultDTO;
import business.exception.Failure;
import dataaccess.dao.UserDAO;
import dataaccess.entity.User;
import dataaccess.exception.DaoException;
import presentation.form.users.LoginUserForm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

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

            // 入力されたパスワードをハッシュ化
            String hashedPassword = hashPassword(form.getPassword());

            // パスワードの検証
            if (!hashedPassword.equals(user.getPasswordHash())) {
                throw new Failure("メールアドレスまたはパスワードが間違っています");
            }

            // ログイン成功
            return new LoginUserResultDTO(user, "ログインに成功しました");

        } catch (DaoException e) {
            throw new Failure("ログイン処理に失敗しました", e);
        }
    }

    /**
     * パスワードをハッシュ化する
     * 
     * @param password ハッシュ化する平文パスワード
     * @return ハッシュ化されたパスワード
     * @throws Failure ハッシュ化に失敗した場合
     */
    private String hashPassword(String password) throws Failure {
        try {
            // SHA-256アルゴリズムを使用
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // パスワードをバイト配列に変換してハッシュ化
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            
            // バイト配列を16進数の文字列に変換
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
            
        } catch (NoSuchAlgorithmException e) {
            throw new Failure("パスワードのハッシュ化に失敗しました", e);
        }
    }
}
