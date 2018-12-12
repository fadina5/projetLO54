
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
		class="navbar sticky-top navbar-light bg-light justify-content-center">
		<h3 class="navbar-brand"> Gestion des formations </h3>
	</nav>

	<nav class="navbar">
		<h5 class="my-0 mr-md-auto font-weight-normal">
			<a class="navbar-brand" href="<c:url value="/"/>">
			<button type="button" class="btn btn-outline-primary btn-lg">
			 <i class="fas fa-caret-left mr-2"></i> <span><strong>Retour</strong></span>
			</button>
			</a>
		</h5>
	</nav>
	
<div class="jumbotron">
<div class="container"><h4 class="display-4">${course.code}: ${course.titre}</h4>
 <h3 class="lead justify-content-center mb-2"><strong>Objectif</strong>: ${course.description}</h3>
 <hr class="my-4">
 <nav class="navbar navbar-light justify-content-center mb-0">
 <span class="navbar-brand mb-0"><h4>
Nombre de sessions disponibles: ${course.courseSessions.size()}</h4></span>
</nav>
</div>
 
</div>
 <div class="container col-6">
  <div class="row">
		
				<c:forEach items="${course.courseSessions}" var="courseSession"
					varStatus="status">
					 <div class="col-6">
				<div class="card">
				
			<h4 class="card-header">
				<strong>Session ${status.index + 1}</strong>
			</h4>
			<div class="card-body">
			
					<p class="card-text">
						Début : <span class="highlight"> <fmt:formatDate
								value="${courseSession.startDate}" pattern="dd/MM/yy" />
						</span> &nbsp; - &nbsp; Fin : <span class="highlight"> <fmt:formatDate
								value="${courseSession.endDate}" pattern="dd/MM/yy" />
						</span>
					</p>
					<p class="card-text">

						Ville : <span class="highlight">
							${courseSession.location.city} </span>
					</p>

					<div class="row align-items-center">
						<div class="col">
							<div class="progress session">
								<div
									class="progress-bar progress-bar-striped progress-bar-animated
                                        ${courseSession.clientPercentage == 100 ? "
									bg-danger" : "bg-success"}"
                                             role="progressbar"
									aria-valuenow="${courseSession.clientPercentage}"
									aria-valuemin="0" aria-valuemax="100"
									style="width: ${courseSession.clientPercentage}%">
									<span class="progress-value">${courseSession.clientPercentage}%</span>
								</div>
							</div>
						</div>
				
						<a href="<c:url value="/course-session/${courseSession.id}"/>"> 
						<button type="button" class="btn btn-success btn-block">
						Préinscription 
						<i class="fas fa-angle-right ml-2"></i>
						</button>
						</a>

					</div>
					</div>
					</div>
	
	</div>
					
				</c:forEach>

			</div>
		
	</div>
	
	

	<%@ include file="scripts.jsp"%>
</body>
</html>