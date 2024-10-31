package dataaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataaccess.entity.User;
import dataaccess.exception.DaoException;

/**
 * ユーザー情報のデータベースアクセスを行うDAO。
 */
public class UserDAO {
    /**
     * ユーザー情報を新規登録する。
     *
     * @param user 登録するユーザー情報
     * @throws DaoException データベースアクセスに失敗した場合
     */
    public void create(User user) throws DaoException {
        try (Connection con = DBManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO users (name, email, password) VALUES (?, ?, ?)")) {
            
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("ユーザーの登録に失敗しました", e);
        }
    }

    /**
     * 指定されたメールアドレスのユーザーが存在するかチェックする。
     *
     * @param email チェックするメールアドレス
     * @return ユーザーが存在する場合はtrue、存在しない場合はfalse
     * @throws DaoException データベースアクセスに失敗した場合
     */
    public boolean findByEmail(String email) throws DaoException {
        try (Connection con = DBManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                "SELECT COUNT(*) FROM users WHERE email = ?")) {
            
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            throw new DaoException("メールアドレスの重複チェックに失敗しました", e);
        }
    }
}