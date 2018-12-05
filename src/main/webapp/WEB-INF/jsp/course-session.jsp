<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="fr">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ include file="styles.jsp" %>

    <title>LO54 - Pré-inscription Session</title>
</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="container-fluid register-page">
    <div class="row justify-content-center">
        <span class="search-result px-4 py-2 mb-2 rounded">Formulaire Pré-inscription</span>
    </div>

    <div class="row session justify-content-center">
        <div class="col-8">
            <div class="card text-center">
                <div class="card-body">
                    <h5 class="card-title home">${courseSession.course.title}</h5>
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
                </div>
                <div class="card-footer">
                    Nombre de pré-inscrits : ${courseSession.clients.size()} / ${courseSession.max}
                </div>
            </div>
        </div>
    </div>

    <!-- Status -->
    <div class="row justify-content-center">
        <c:if test="${success == true}">
            <div class="col-6 alert alert-success alert-dismissible fade show" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <i aria-hidden="true" class="fas fa-times"></i>
                </button>
                <span>
                    <i class="far fa-smile mr-2"></i>
                    Votre pré-inscription a bien été prise en compte.
                </span>
            </div>
        </c:if>
        <c:if test="${success == false}">
            <div class="col-6 alert alert-danger alert-dismissible fade show" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <i aria-hidden="true" class="fas fa-times"></i>
                </button>
                <span>
                    <i class="far fa-frown mr-2"></i>
                    <c:if test="${full == true}">
                        La session est remplie.
                    </c:if>
                    <c:if test="${full != true}">
                        Un erreur s'est produite lors de votre pré-inscription.
                    </c:if>
                </span>
            </div>
        </c:if>
    </div>

    <!-- Register Form -->
    <div class="row justify-content-center">
        <div class="col-6 register-form card">
            <div class="card-body">
                <form:form class="needs-validation" novalidate="novalidate" modelAttribute="client" method="post"
                           action="/course-session/${courseSession.id}/register">
                    <form:hidden path="id"/>
                    <div class="form-row">
                        <div class="form-group col-6">
                            <form:label path="lastname">Nom</form:label>
                            <form:input path="lastname" placeholder="DOE" required="required"
                                        cssClass="form-control"/>
                            <form:errors path="lastname" element="small" cssClass="form-error"/>
                            <div class="invalid-feedback">
                                Champ obligatoire !
                            </div>
                        </div>
                        <div class="form-group col-6">
                            <form:label path="firstname">Prénom</form:label>
                            <form:input path="firstname" placeholder="John" required="required"
                                        cssClass="form-control"/>
                            <form:errors path="firstname" element="small" cssClass="form-error"/>
                            <div class="invalid-feedback">
                                Champ obligatoire !
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="address">Adresse</form:label>
                        <form:input path="address" placeholder="6 Boulevard Anatole France"
                                    required="required" cssClass="form-control"/>
                        <form:errors path="address" element="small" cssClass="form-error"/>
                        <div class="invalid-feedback">
                            Champ obligatoire !
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-6">
                            <form:label path="phone">Téléphone</form:label>
                            <form:input path="phone" placeholder="06.XX.XX.XX.XX" required="required"
                                        cssClass="form-control"/>
                            <form:errors path="phone" element="small" cssClass="form-error"/>
                            <div class="invalid-feedback">
                                Champ obligatoire !
                            </div>
                        </div>
                        <div class="form-group col-6">
                            <form:label path="email">Email</form:label>
                            <form:input path="email" type="email" placeholder="john.doe@example.com"
                                        cssClass="form-control"/>
                            <form:errors path="email" element="small" cssClass="form-error"/>
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

<%@ include file="scripts.jsp" %>
</body>
</html>