<%@ taglib prefix="set" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <title>Start Page (index)</title>--%>

    <%-- Elementy dotyczące treści strony --%>
    <%--    <meta name="description"--%>
    <%--          content="Projekt Spring Transitions zawierający zbiór przekształceń projektów opartych na Spring Boot 2 do nowych wersji"/>--%>
    <%--    <meta name="keywords" content="Spring,boot,java,jsp,project,code"/>--%>
    <meta name="author" content="Michał Kupisiński, https://github.com/honestit"/>
    ​
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    ​
    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>

</head>

<body class="has-navbar-fixed-top">
<header>
    <nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation">
        <div class="container">
            <div class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item" href="/">
                        Strona główna
                    </a>
                    <%-- Tutaj pozostałe linki, które chcemy mieć widoczne --%>
                    ​
                    <div class="navbar-item has-dropdown is-hoverable">
                        <a class="navbar-link">
                            Więcej
                        </a>
                        ​
                        <div class="navbar-dropdown">
                            <a class="navbar-item">
                                Link do niczego
                            </a>
                            <%-- Tutaj kolejne linki w menu dodatkowym --%>
                        </div>
                    </div>
                </div>
                ​
                <div class="navbar=end">
                    <div class="navbar-item">
                        <div class="buttons">
                            <a class="button is-primary" href="/registration">
                                <strong>Zarejestruj</strong>
                            </a>
                            <a class="button is-success" href="/login">
                                <strong>Zaloguj</strong>
                            </a>
                            <%--  Wyświetla przyciski jeżeli zweryfikowany (zalogowany) jest użytkownik
                                  Jest to weryfikacja ścieżki --%>
                            <sec:authorize access="isAuthenticated()">
                                <a class="button is-primary" href="/user">
                                    <strong>Twoje konto</strong>
                                </a>
                                <form method="post" action="/logout">
                                    <button class="button is-link" type="submit">Wyloguj</button>
                                    <set:csrfInput/>
                                </form>
                            </sec:authorize>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
