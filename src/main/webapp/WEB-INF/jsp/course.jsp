
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="fr">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ include file="styles.jsp"%>

<title>Gestion des formations</title>
</head>
<body>
	<nav
		class="navbar sticky-top navbar-light bg-dark justify-content-center">
		<a class="navbar-brand"> Gestion des formations </a>
	</nav>

	<nav class="navbar navbar-light bg-light">
		<h5 class="my-0 mr-md-auto font-weight-normal">
			<a class="navbar-brand" href="<c:url value="/"/>"> <i
				class="fas fa-home mr-2"></i> <span><strong>Home</strong></span>
			</a>
		</h5>
	</nav>

	<div class="container col-8">
		<div class="card">
			<h4 class="card-header">${course.code}:${course.titre}</h4>
			<div class="card-body">
			
            <c:forEach items="${course.courseSessions}" var="courseSession" varStatus="status">
               
			
                    
                            <h5 class="card-text">Session ${status.index + 1}</h5>
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
                                </p>
                                 <p class="card-text">
                             
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
                       
                
                
            </c:forEach>
     
	
				<p class="card-title"></p>
			
			<div class="card-footer justify-content-center text-muted">
				Nombre de sessions disponibles(${course.courseSessions.size()})
			</div>
			   </div>
    </div>
		</div>
	
	<%@ include file="scripts.jsp"%>