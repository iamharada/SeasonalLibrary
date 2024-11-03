package business.service.users;

import presentation.form.users.SignUpUserForm;
import business.dto.users.SignUpUserResultDTO;
import business.exception.Failure;
import dataaccess.dao.UserDAO;
import dataaccess.exception.DaoException;
import dataaccess.entity.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

/**
 * ユーザー登録を行うビジネスロジッククラス。
 */
public class SignUpUser {
    private final UserDAO userDAO;

    public SignUpUser() {
        this.userDAO = new UserDAO();
    }

    /**
     * ユーザー登録を実行する。
     * 
     * @param form 登録するユーザーの情報を{@link SignUpForm}型のオブジェクトにまとめたものを入力とする。
     * @return 登録に成功した場合は、{@link SignupUserResultDTO}型のオブジェクトを返す。
     * @throws Failure 登録に失敗した場合は、{@link Failure}型の例外を投げる。
     */
    public SignUpUserResultDTO execute(SignUpUserForm form) throws Failure {
        try {
            // 入力値の検証
            validate(form);

            // パスワードをハッシュ化
            String hashedPassword = hashPassword(form.getPassword());

            // 入力の情報を用いて、ユーザー情報のエンティティオブジェクトをインスタンス化する
            User user = new User(form.getName(), form.getEmail(), hashedPassword);

            // ユーザー情報のエンティティオブジェクトをDAOに渡して登録する
            userDAO.create(user);

            // 登録に成功したことを意味する情報を返す
            SignUpUserResultDTO result = new SignUpUserResultDTO(user, "ユーザー登録に成功しました");
            return result;

        } catch (Failure failure) {
            // バリデーションエラーやユーザー作成時の例外を処理
            throw new Failure("ユーザー登録に失敗しました：" + failure.getMessage(), failure);

        } catch (DaoException daoException) {
            // DAOでの例外を処理
            throw new Failure("ユーザー登録に失敗しました：" + daoException.getMessage(), daoException);
        }
    }

    /**
     * 入力値の検証を行う。
     * 
     * @param form 検証する入力フォーム
     * @throws Failure 検証に失敗した場合
     * @throws DaoException データベースアクセスに失敗した場合
     */
    private void validate(SignUpUserForm form) throws Failure, DaoException {
        // メールアドレスの重複チェック
        if (userDAO.findByEmail(form.getEmail())) {
            throw new Failure("このメールアドレスは既に登録されています");
        }

        // パスワード一致チェック
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            throw new Failure("パスワードと確認用パスワードが一致しません");
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