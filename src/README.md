# アプリケーション名

## システム構成

## アーキテクチャ

## ディレクトリ構造の説明

## シーケンス図
### サインアップ
![](sequence-signUp.png)
## ユースケース
以下の表は、アプリケーションのユースケースを示しています。

| ユースケース名 | ビュー(jsp) | コントロール(Servlet) | サービス | DAO | エンティティ |  
|--------------|------|------|------|------|------|
|サインアップ|signup.jsp|SignUpUserServlet.java|SignUpUser.java|UserDAO.java|User.java|
|ログイン|login.jsp|LogInUserServlet.java|LogInUser.java|UserDAO.java|User.java|