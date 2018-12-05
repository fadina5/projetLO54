<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ include file="styles.jsp" %>

    <title>LO54 - Formation</title>
</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="container-fluid error-page">
    <div class="card text-center">
        <div class="card-header error text-muted">
            Erreur Application URL : ${url}
        </div>
        <div class="card-body">
            <h5 class="card-title"> L'application a rencontré une erreur </h5>
            <p class="card-text"> Exception : ${exception.message} </p>
            <!--
                Failed URL: ${url}
                Exception:  ${exception.message}
                StackTrace:
                <c:forEach items="${exception.stackTrace}" var="ste">
                    ${ste}
                </c:forEach>
            -->
        </div>
    </div>
</div>

<%@ include file="scripts.jsp" %>
</body>
</html>