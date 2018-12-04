
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html lang="fr">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ include file="styles.jsp" %>

    <title>Gestion des formations</title>
</head>
<body>
<nav class="navbar sticky-top navbar-dark bg-dark justify-content-center">
    <a class="navbar-brand" href="<c:url value="/"/>">
        Gestion des formations 
    </a>
</nav>

<div class="container-fluid course">
    <div class="card text-center">
        <div class="card-header">
          <h4>${course.code}</h4>:</h5>${course.titre}</h5>
        </div>
        <div class="card-footer text-muted">
            ${course.courseSessions.size()} session(s)
        </div>
    </div>

    <div class="border rounded sessions-box">
        <div class="row">
            <c:forEach items="${course.courseSessions}" var="courseSession" varStatus="status">
                <div class="col-4 card-session">
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title">Session ${status.index + 1}</h5>
                            <p class="card-text">
                                Début :
                                <span class="highlight">
                                    <fmt:formatDate value="${courseSession.startDate}" pattern="dd/MM/yy"/>
                                </span>
                                &nbsp; - &nbsp;
                                Fin :
                                <span class="highlight">
                                    <fmt:formatDate value="${courseSession.endDate}" pattern="dd/MM/yy"/>
                                </span>
                                <br>
                                Ville :
                                <span class="highlight">
                                        ${courseSession.location.city}
                                </span>
                            </p>

                            <div class="row align-items-center">
                                <div class="col">
                                    <div class="progress session">
                                        <div class="progress-bar progress-bar-striped progress-bar-animated
                                        ${courseSession.clientPercentage == 100 ? "bg-danger" : "bg-success"}"
                                             role="progressbar"
                                             aria-valuenow="${courseSession.clientPercentage}"
                                             aria-valuemin="0" aria-valuemax="100"
                                             style="width: ${courseSession.clientPercentage}%">
                                            <span class="progress-value">${courseSession.clientPercentage}%</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <a href="<c:url value="/course-session/${courseSession.id}"/>"
                                       class="btn btn-primary btn-block">
                                        Pré-inscription
                                        <i class="fas fa-angle-right ml-2"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

</div>

<%@ include file="scripts.jsp" %>