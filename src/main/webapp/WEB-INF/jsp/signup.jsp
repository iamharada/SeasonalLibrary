<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新規登録</title>
</head>
<body>
    <h1>新規登録</h1>
    <p>情報を入力して、確認ボタンを押してください。</p>
    
    <c:if test="${not empty errorMessages}">
        <div style="color: red;">
            <ul>
                <c:forEach var="error" items="${errorMessages}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <form action="<c:url value='/signup'/>" method="post">
        <div>
            <label for="name">名前:</label>
            <input type="text" id="name" name="name" value="${form.name}" required>
        </div>
        <div>
            <label for="email">メールアドレス:</label>
            <input type="email" id="email" name="email" value="${form.email}" required>
        </div>
        <div>
            <label for="password">パスワード:</label>
            <input type="password" id="password" name="password" pattern="[a-zA-Z0-9]{6,20}" 
                   title="パスワードは半角英数6文字以上20文字以下で入力してください" required>
        </div>
        <div>
            <label for="confirmPassword">パスワード（確認用）:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" 
                   pattern="[a-zA-Z0-9]{8,20}" 
                   title="パスワードは半角英数8文字以上20文字以下で入力してください" required>
        </div>        
        <div>
            <input type="submit" value="登録">
        </div>
    </form>
</body>
</html>