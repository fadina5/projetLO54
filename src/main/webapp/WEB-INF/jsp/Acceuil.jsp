<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="fr">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ include file="styles.jsp"%>

<title>Gestion des formations</title>
</head>
<body>

	<div class="jumbotron">
		<div class="container">
			<h3 class="display-4">Gestion des formations</h3>
		</div>
	</div>
	<div class="container">
		<div class="recherche py-1">
			<!-- Recherche par titre -->

			<form id="form-search" class="search-form" method="post"
				action="<c:url value="/search"/>">
				<div class="form-group row justify-content-center">

					<div class="input-group col-6">
						<div class="input-group-prepend">
							<div class="input-group-text">Recherche</div>
						</div>
						<input autocomplete="off" type="text" class="form-control"
							name="titre" placeholder="Entrez le titre de votre cours"
							value="${titre}">

					</div>
					<input name="page-number" id="page-number-advanced" type="number"
						hidden>
					<div class="col-2">
						<button type="submit" class="btn btn-secondary btn-block">
							<i class="fas fa-search mr-2"></i>

						</button>
					</div>
					<div class="col-3">
						<button type="button" class="btn btn-secondary btn-block"
							id="btn-advanced-search">Avancé...</button>
					</div>
				</div>
			</form>
			<!-- Avancé -->
			<form id="form-advanced-search" class="search-form" method="post"
				action="<c:url value="/advanced-search"/>">
				<div class="form-group row justify-content-center">
					<div class="input-group col-8">
						<div class="input-group-prepend">
							<div class="input-group-text">Recherche</div>
						</div>
						<input autocomplete="off" name="titre" type="text"
							class="form-control" placeholder="Entrez le titre de votre cours"
							value="${titre}">
					</div>
					<input name="page-number" id="page-number-advanced" type="number"
						hidden>
				</div>

				<div class="form-group row justify-content-center">
					<div class="input-group date col-4">
						<div class="input-group-prepend">
							<div class="input-group-text">Début de la session</div>
						</div>
						<input type="text" name="date" class="form-control"
							placeholder="Entrez une date" autocomplete="on" value="${date}">
						<div class="input-group-append input-group-addon">
							<div class="input-group-text">
								<i class="far fa-calendar-alt"></i>
							</div>
						</div>
					</div>
					<div class="input-group col-4">
						<div class="input-group-prepend">
							<div class="input-group-text">Lieu de la session</div>
						</div>
						<select name="location" class="client-select" title="lieu">
							<option value="" selected>Choisir un lieu</option>
							<c:forEach items="${locations}" var="location">
								<option value="${location.id}">${location.city}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group row justify-content-center">
					<div class="col-2">
						<button type="submit" class="btn btn-secondary btn-block">
							<i class="fas fa-search mr-2"></i>
						</button>
					</div>
					<div class="col-3">
						<button type="button" class="btn btn-secondary btn-block"
							id="btn-search">Recherche par titre</button>
					</div>
				</div>
			</form>
			

			<div class="page-body rounded py-2 mt-2">
			
				<c:if test="${advanced != true }">
				
					<div class="container">
						<nav class="navbar navbar-light justify-content-center mb-2">
							<span class="navbar-brand mb-0"><h4>Nombre de
									formations disponibles: ${courses.size()}</h4></span>
						</nav>
					</div>


					<div class="list-group px-5">
						<table class="table table-bordered table-striped ">
							<thead>
								<tr>
									<th>Code</th>
									<th>Intitulé</th>
									<th>Description</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="course" items="${courses}" varStatus="boucle">

									<tr>
										<td><c:out value="${course.code}" /></td>

										<td><a href="<c:url value="/course/${course.code}"/>"><c:out
													value="${course.titre}" /></a></td>
										<td><c:out value="${course.description}" /></td>


									</tr>

								</c:forEach>
							</tbody>
						</table>



					</div>
				</c:if>
			</div>
			<c:if test="${advanced == true}">
				<div class="row justify-content-center mb-2">
					<span class="search-result px-4 py-2 rounded">Nombre de
						sessions disponibles:${courseSession.size()}</span>
				</div>

				<div class="sessions-box">
					<div class="row">
						<c:forEach items="${courseSession}" var="courseSession">
							<div class="col-6 card-session">
								<div class="card">
									<h4 class="card-header">
										<strong>${courseSession.course.code}:${courseSession.course.titre}</strong>
									</h4>
									<div class="card-body">

										<h4 class="justify-center">Objectif:
											${courseSession.course.description}</h4>

										<h5 class="card-text">Session ${status.index +1}</h5>
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
											<div class="col">
												<a
													href="<c:url value="/course-session/${courseSession.id}"/>"
													class="btn btn-primary btn-block"> Préinscription <i
													class="fas fa-angle-right ml-2"></i>
												</a>
											</div>
										</div>
									</div>
								</div>

							</div>
						</c:forEach>
					</div>

				</div>
			</c:if>

		</div>
	</div>

	<%@ include file="scripts.jsp"%>
</body>
</html>
