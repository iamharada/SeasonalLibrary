package business.service.users;

import presentation.form.users.SignUpUserForm;
import business.dto.users.SignUpUserResultDTO;
import business.exception.Failure;
import dataaccess.dao.UserDAO;
import dataaccess.exception.DaoException;
import dataaccess.entity.User;

/**
 * ユーザー登録を行うビジネスロジッククラス。
 */
public class SignUpUser {
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

            // 入力の情報を用いて、ユーザー情報のエンティティオブジェクトをインスタンス化する
            User user = new User(form.getName(), form.getEmail(), form.getPassword());

            // DAOをインスタンス化する
            UserDAO userDAO = new UserDAO();

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
     */
    private void validate(SignUpUserForm form) throws Failure, DaoException {
        UserDAO userDAO = new UserDAO();

        // メールアドレスの重複チェック
        if (userDAO.findByEmail(form.getEmail())) {
            throw new Failure("このメールアドレスは既に登録されています");
        }

        // パスワード一致チェック
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            throw new Failure("パスワードと確認用パスワードが一致しません");
        }
    }
}