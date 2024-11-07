<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン - Seasonal Library</title>
</head>
<body>
    <div class="container">
        <h1>ログイン</h1>
        
        <%-- エラーメッセージの表示 --%>
        <c:if test="${not empty error}">
            <div class="error-message">
                <c:out value="${error}" />
            </div>
        </c:if>
        
        <form action="/login" method="post">
            <div class="form-group">
                <label for="email">メールアドレス:</label>
                <input type="email" id="email" name="email" value="${param.email}" required>
            </div>
            
            <div class="form-group">
                <label for="password">パスワード:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <div class="form-actions">
                <button type="submit">ログイン</button>
            </div>
        </form>
        
        <div class="links">
            <p>アカウントをお持ちでない方は<a href="/signup">新規登録</a>してください。</p>
        </div>
    </div>
</body>
</html>