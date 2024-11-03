package dataaccess.entity;

import java.time.LocalDateTime;

/**
 * usersテーブルのエンティティクラス
 */
public class User {
    private final int id;
    private final String name;
    private final String email;
    private final String passwordHash;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    /**
     * 新規ユーザー作成用のコンストラクタ
     */
    public User(String name, String email, String passwordHash) {
        this(0, name, email, passwordHash, null, null);
    }

    /**
     * データベースから取得したユーザー情報を格納するコンストラクタ
     */
    public User(int id, String name, String email, String passwordHash, 
                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}