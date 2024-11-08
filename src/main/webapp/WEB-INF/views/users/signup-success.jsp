<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up Success</title>
</head>
<body>
    <h1>Sign Up Successful!</h1>
    <p>Congratulations! Your sign up was successful.</p>
    <p>Thank you for joining our community, <%= request.getAttribute("username") %>!</p>
    
    <a href="/home">Go back to the initial page</a>
</body>
</html>