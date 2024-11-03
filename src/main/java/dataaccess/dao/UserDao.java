package dataaccess.dao;

import dataaccess.entity.User;
import dataaccess.exception.DaoException;
import dataaccess.dbUtil.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * usersテーブルへのデータアクセスを行うクラス
 */
public class UserDAO {
    private final DBManager dbManager;

    public UserDAO() {
        this.dbManager = new DBManager();
    }

    /**
     * ユーザーを新規登録する
     * 
     * @param user 登録するユーザー情報
     * @throws DaoException データベースアクセスに失敗した場合
     */
    public void create(User user) throws DaoException {
        String sql = "INSERT INTO users (name, email, password_hash) VALUES (?, ?, ?)";

        try (Connection con = dbManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPasswordHash());
            
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("ユーザーの登録に失敗しました", e);
        }
    }

    /**
     * メールアドレスからユーザーを検索する
     * 
     * @param email 検索するメールアドレス
     * @return ユーザーが存在する場合はtrue、存在しない場合はfalse
     * @throws DaoException データベースアクセスに失敗した場合
     */
    public boolean findByEmail(String email) throws DaoException {
        String sql = "SELECT COUNT(*) as count FROM users WHERE email = ?";

        try (Connection con = dbManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, email);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("count") > 0;
                }
                return false;
            }

        } catch (SQLException e) {
            throw new DaoException("メールアドレスの検索に失敗しました", e);
        }
    }

    /**
     * メールアドレスからユーザー情報を取得する
     * 
     * @param email 検索するメールアドレス
     * @return ユーザー情報。見つからない場合はnull
     * @throws DaoException データベースアクセスに失敗した場合
     */
    public User getByEmail(String email) throws DaoException {
        String sql = "SELECT id, name, email, password_hash, created_at, updated_at FROM users WHERE email = ?";

        try (Connection con = dbManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, email);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                    );
                }
                return null;
            }

        } catch (SQLException e) {
            throw new DaoException("ユーザー情報の取得に失敗しました", e);
        }
    }
}