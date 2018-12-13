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

	<nav
		class="navbar sticky-top navbar-dark bg-light justify-content-center">
		<a class="navbar-brand"> Gestion des formations </a>
	</nav>

	<nav class="navbar">
		<h5 class="my-0 mr-md-auto font-weight-normal">
			<a class="navbar-brand"
				href="<c:url value="/course/${courseSession.course.code}"/>">
				<button type="button" class="btn btn-outline-primary btn-lg">
					<i class="fas fa-caret-left mr-2"></i> <span><strong>Retour</strong></span>
				</button>
			</a>

		</h5>
		<h5 class="my-0 mr-md-auto font-weight-normal pull-right">
			<a class="navbar-brand"> </a>
		</h5>
		<h5 class="my-0 mr-md-auto font-weight-normal pull-right">
			<a class="navbar-brand"> </a>
		</h5>
		<h5 class="my-0 mr-md-auto font-weight-normal pull-right">
			<a class="navbar-brand"> </a>
		</h5>
		<h5 class="my-0 mr-md-auto font-weight-normal pull-right">
			<a class="navbar-brand"> </a>
		</h5>
		<h5 class="my-0 mr-md-auto font-weight-normal pull-right">
			<a class="navbar-brand"> </a>
		</h5>
		<h5 class="my-0 mr-md-auto font-weight-normal pull-right">
			<a class="navbar-brand"> </a>
		</h5>
		<h5 class="my-0 mr-md-auto font-weight-normal pull-right">
			<a class="navbar-brand"> </a>
		</h5>
		<h5 class="my-0 mr-md-auto font-weight-normal pull-right">
			<a class="navbar-brand"> </a>
		</h5>
		<h5 class="my-0 mr-md-auto font-weight-normal pull-right">
			<a class="navbar-brand"> </a>
		</h5>

		<h5 class="my-0 mr-md-auto font-weight-normal pull-right">
			<a class="navbar-brand" href="<c:url value="/"/>">
				<button type="button" class="btn btn-outline-primary btn-lg">
					<i class="fas fa-home mr-2"></i> <span><strong>Home</strong></span>
				</button>
			</a>
		</h5>
	</nav>
	<nav class="navbar navbar-light justify-content-center mb-0">
		<span class="navbar-brand mb-0">
			<h3>Formulaire de préinscription de
				: ${courseSession.course.code}</h3>
		</span>
	</nav>
	<div class="container justify-content-center mb-2">
		Début : <span class="highlight"> <fmt:formatDate
				value="${courseSession.startDate}" pattern="dd/MM/yy" />
		</span> &nbsp; - &nbsp; Fin : <span class="highlight"> <fmt:formatDate
				value="${courseSession.endDate}" pattern="dd/MM/yy" />
		</span> <br> 
		<br>
		Ville : <span class="highlight">
			${courseSession.location.city} </span>
	<br>
	<br>
	<nav class="navbar navbar-light justify-content-center mb-0">
		<span class="navbar-brand mb-0">
		<h5>
			Nombre de personnes inscrites:
			${courseSession.clients.size()} / ${courseSession.max}
		</h5></span>
	</nav>
		
		<br>
		<br>	
	<table class="table table-bordered table-striped ">
						<thead>
							<tr>
								
								<th>Noms</th>
								<th>Prénoms</th>
								<th>Adresse</th>
								<th>Téléphone</th>
								<th>Email</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="client" items="${courseSession.clients}"
								varStatus="boucle">

								<tr>
									
									<td><c:out value="${client.lastname}" /></td>
									<td><c:out value="${client.firstname}" /></td>
									<td><c:out value="${client.address}" /></td>
									<td><c:out value="${client.phone}" /></td>
									<td><c:out value="${client.email}" /></td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
	
	<div class="progress session">
	
		<div
			class="progress-bar progress-bar-striped progress-bar-animated
            ${courseSession.clientPercentage == 100 ? "
			bg-danger" : "bg-success"}" role="progressbar"
			aria-valuenow="${courseSession.clientPercentage}" aria-valuemin="0"
			aria-valuemax="100" style="width: ${courseSession.clientPercentage}%">
			<span class="progress-value">${courseSession.clientPercentage}%</span>
		</div>
	</div>

</div>


	<br>
	<br>
	<div class="row session justify-content-center">
	
		<div class="col-8">
	<!-- Register Form -->
			<div class="row justify-content-center">
				<div class="col-8 register-form card">

					<!-- Status -->
					<div class="row justify-content-center">
						<c:if test="${success == true}">
							<div
								class="col-6 alert alert-success alert-dismissible fade show"
								role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<i aria-hidden="true" class="fas fa-times"></i>
								</button>
								<span> <i class="far fa-smile mr-2"></i> Votre
									pré-inscription a bien été prise en compte.
								</span>
							</div>
						</c:if>
						<c:if test="${success == false}">
							<div class="col-6 alert alert-danger alert-dismissible fade show"
								role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<i aria-hidden="true" class="fas fa-times"></i>
								</button>
								<span> <i class="far fa-frown mr-2"></i> 
					<c:if test="${full == true}">
                        La session est pleine.
                    </c:if> 
                    <c:if test="${full != true}">
                        Un erreur s'est produite lors de votre pré-inscription.
                    </c:if>
								</span>
							</div>
						</c:if>
					</div>
					<div class="container">
					
					<h3><strong>Inscription</strong></h3>
					 <hr class="my-4">
					 <br>
					
					<form:form class="needs-validation" novalidate="novalidate"
						modelAttribute="client" method="post"
						action="/course-session/${courseSession.id}/register">
						<form:hidden path="id" />
						<div class="form-row">
							<div class="form-group col-6">
								<form:label path="lastname">Nom</form:label>
								<form:input path="lastname" placeholder="NOM"
									required="required" cssClass="form-control" />
								<form:errors path="lastname" element="small"
									cssClass="form-error" />
								<div class="invalid-feedback">Champ obligatoire !</div>
							</div>
							<div class="form-group col-6">
								<form:label path="firstname">Prénom</form:label>
								<form:input path="firstname" placeholder="PRENOM"
									required="required" cssClass="form-control" />
								<form:errors path="firstname" element="small"
									cssClass="form-error" />
								<div class="invalid-feedback">Champ obligatoire !</div>
							</div>
						</div>
						<div class="form-group">
							<form:label path="address">Adresse</form:label>
							<form:input path="address"
								placeholder="28 RUE ADOLPE THIERS" required="required"
								cssClass="form-control" />
							<form:errors path="address" element="small" cssClass="form-error" />
							<div class="invalid-feedback">Champ obligatoire !</div>
						</div>
						<div class="form-row">
							<div class="form-group col-6">
								<form:label path="phone">Téléphone</form:label>
								<form:input path="phone" placeholder="06.XX.XX.XX.XX"
									required="required" cssClass="form-control" />
								<form:errors path="phone" element="small" cssClass="form-error" />
								<div class="invalid-feedback">Champ obligatoire !</div>
							</div>
							<div class="form-group col-6">
								<form:label path="email">Email</form:label>
								<form:input path="email" type="email"
									placeholder="nom.prenom@example.com" cssClass="form-control" />
								<form:errors path="email" element="small" cssClass="form-error" />
							</div>
						</div>

						<div class="form-group row justify-content-center">
							<div class="col-4">
								<form:button type="submit" class="btn btn-success btn-block">
									<i class="fas fa-check mr-2"></i>
                                Valider
                            </form:button>
							</div>
						</div>
					</form:form>
					</div>
</div>
				</div>
			</div>
		</div>
		<%@ include file="scripts.jsp"%>
</body>
</html>
