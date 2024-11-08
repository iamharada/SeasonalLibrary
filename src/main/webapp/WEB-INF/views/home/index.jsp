<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Top Page</title>
    </head>
    <body>
        <h1>Welcome</h1>
        <p>ようこそ、Seasonal Libraryへ</p>
    
        <!-- ログイン画面に遷移するボタン -->
        <form action="<c:url value='/login'/>" method="get">
            <input type="submit" value="ログイン">
        </form>
    
        <!-- 新規登録画面に遷移するボタン -->
        <form action="<c:url value='/signup'/>" method="get">
            <input type="submit" value="新規登録">
        </form>
    </body>
</html>