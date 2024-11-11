<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header">
    <div class="header-container">
        <!-- ロゴ/アプリ名 -->
        <div class="header-left">
            <a href="${pageContext.request.contextPath}/mypage" class="logo">
                seasonal library
            </a>
        </div>

        <!-- ナビゲーションメニュー -->
        <nav class="header-nav">
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <!-- ログイン済みの場合 -->
                    <ul class="nav-list">
                        <li>
                            <a href="${pageContext.request.contextPath}/mypage" class="nav-link">マイページ</a>
                        </li>
                        <li class="dropdown">
                            <button class="dropdown-toggle">
                                <span class="username">${sessionScope.user.name}</span>
                                <span class="dropdown-arrow">▼</span>
                            </button>
                            <ul class="dropdown-menu">
                                <li>
                                    <form action="${pageContext.request.contextPath}/logout" method="post" class="logout-form">
                                        <button type="submit" class="logout-button">ログアウト</button>
                                    </form>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <!-- 未ログインの場合 -->
                    <ul class="nav-list">
                        <li>
                            <a href="${pageContext.request.contextPath}/users/login" class="nav-link">ログイン</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/users/signup" class="nav-link signup-link">新規登録</a>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </nav>
    </div>
</header>