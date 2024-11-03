<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザー登録</title>
</head>
<body>
    <div class="container">
        <h1>ユーザー登録</h1>
        
        <%-- エラーメッセージの表示 --%>
        <c:if test="${not empty error}">
            <div class="error-message">
                ${error}
                ${form.name}
                ${form.email}
                ${form.password}
                ${form.confirmPassword}
            </div>
        </c:if>

        <form action="signup" method="post">
            <div class="form-group">
                <label for="name">名前</label>
                <input type="text" 
                       id="name" 
                       name="name" 
                       value="${form.name}" 
                       required>
            </div>

            <div class="form-group">
                <label for="email">メールアドレス</label>
                <input type="email" 
                       id="email" 
                       name="email" 
                       value="${form.email}" 
                       required>
            </div>

            <div class="form-group">
                <label for="password">パスワード</label>
                <input type="password" 
                       id="password" 
                       name="password" 
                       required>
                <small>8文字以上の半角英数字を入力してください</small>
            </div>

            <div class="form-group">
                <label for="confirmPassword">パスワード（確認）</label>
                <input type="password" 
                       id="confirmPassword" 
                       name="confirmPassword" 
                       required>
            </div>

            <div class="form-group">
                <button type="submit">登録</button>
            </div>
        </form>
    </div>
</body>
</html>