
<div align="center"><img src="/img/logo.png" width="400"/></div>

# Seasonal Library: your personal library organized by seasons and months

## 1. システム概要
### 1-1. プロジェクト概要
Seasonal Libraryは, 四季や月ごとに本を整理し、読書習慣の形成をサポートするウェブアプリケーションです。

### 1-2. 開発環境 
|開発言語|フレームワーク|データベース|開発環境（docker-composeでまとめて管理）|
|---|---|---|---|
|![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)|![Servlet/JSP](https://img.shields.io/badge/-Servlet/JSP-007396.svg?logo=Servlet/JSP&style=for-the-badge)|![Mysql](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)|![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white)  ![ApacheTomcat](https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)  ![Mysql](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)|

## 2. 機能要件
### 2-1. 認証・アカウント管理機能
| 機能 | 説明 | 実装状況 |
| --- | --- | --- |
| サインアップ | 新規ユーザ登録機能 | ◎ |
| ログイン | 登録した情報を用いて本人確認をする機能 | ◎ |
| ログアウト | ログイン状態を解除する機能 | × |
| パスワード変更 | 登録したパスワード情報を変更する機能 | × |

### 2-2. 本の管理機能
| 機能 | 説明 | 実装状況 |
| --- | --- | --- |
| 本の登録 | 以下の情報を登録<br>- タイトル<br>- 著者<br>- 画像<br>- メモ<br>- 読み返したい月 | × |
| 本の編集 | 登録済み本の情報更新 | × |
| 本の削除 | 登録済み本の削除 | × |
| いいね機能 | 他ユーザーの本へのいいね登録/解除 | × |

### 2-3. 本の表示・検索機能
| 機能 | 説明 | 実装状況 |
| --- | --- | --- |
| 月別表示 | 選択した月に関連付けられた本の一覧表示 | × |
| 季節別表示 | 春夏秋冬ごとの本の一覧表示 | × |
| 検索機能 | 以下の条件での検索<br>- タイトル<br>- 著者名<br>- 月 | × |
| 並べ替え機能 | 以下の条件での並べ替え<br>- 追加順<br>- タイトルの五十音順<br>- いいね数順 | × |

## 3. 非機能要件
### 3-1. セキュリティ
- パスワードのハッシュ化保存
- セッション管理によるアクセス制御

## 4. DB設計
後に記述

## 5. 開発環境セットアップ
### 5-1. 必要なソフトウェア
- Docker

### 5-2. 環境構築手順
#### 1. リポジトリのクローン
```bash
git clone https://github.com/iamharada/seasonal-library.git
``` 

#### 2. dockerコンテナを起動
```bash
docker-compose build
docker-compose up -d
```

#### 3. DBの初期化
```bash
docker-compose exec -it < DBのコンテナ名 > bash
mysql -u root -p < init.sql >
```
