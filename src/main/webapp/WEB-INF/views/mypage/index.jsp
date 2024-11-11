<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>マイページ</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <h1>マイページ</h1>
    
    <div>
        <!-- デバッグ情報の表示 -->
        <p>User情報: ${user}</p>
        
        <!-- 基本的なユーザー情報の表示 -->
        <p>名前: ${user.name}</p>
        <p>ID: ${user.id}</p>
        <p>Email: ${user.email}</p>
    </div>
</body>
</html>