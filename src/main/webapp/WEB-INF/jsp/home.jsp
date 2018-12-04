<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="fr">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ include file="styles.jsp" %>

    <title>Gestion des cours</title>
</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="container-fluid home-page">
    <div class="page-search py-1">
        <!-- Recherche par titre -->
        <form id="form-search" class="search-form" method="post" action="<c:url value="/search"/>">
            <div class="form-group row justify-content-center">
             
                <div class="input-group col-6">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Recherche</div>
                    </div>
                    <input autocomplete="off" type="text" class="form-control" name="titre"
                           placeholder="Entrez le titre de votre cours"
                           value="${titre}">
                           
                </div>
                  <input name="page-number" id="page-number-advanced" type="number" hidden>
                <div class="col-2">
                    <button type="submit" class="btn btn-primary btn-block">
                        <i class="fas fa-search mr-2"></i>
                  
                    </button>
                </div>
                
            </div>
            

            <div class="form-group row justify-content-center">
      			<div class="col-3">
                    <button type="button" class="btn btn-secondary btn-block" id="btn-advanced-search">
                      
                        Avancé...
                       
                    </button>
                </div>
            </div>
        </form>
 <!-- Avancé -->
        <form id="form-advanced-search" class="search-form" method="post" action="<c:url value="/advanced-search"/>">
            <div class="form-group row justify-content-center">
                <div class="input-group col-6">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Recherche</div>
                    </div>
                    <input autocomplete="off" name="titre" type="text" class="form-control"
                           placeholder="Entrez le titre de votre cours"
                           value="${titre}">
                </div>
                <input name="page-number" id="page-number-advanced" type="number" hidden>
            </div>

            <div class="form-group row justify-content-center">
                <div class="input-group date col-6">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Début de la session</div>
                    </div>
                    <input type="text" name="date" class="form-control" placeholder="jj/mm/aaaa" autocomplete="off"
                           value="${date}">
                    <div class="input-group-append input-group-addon">
                        <div class="input-group-text"><i class="far fa-calendar-alt"></i></div>
                    </div>
                </div>
                <div class="input-group col-6">
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
                    <button type="button" class="btn btn-secondary btn-block" id="btn-search">
                        Recherche par titre   
                    </button>
                </div>
            </div>
        </form>
        
       </div>
        <div class="page-body rounded py-2 mt-2">
        <c:if test="${advanced != true }">
            <div class="row justify-content-center mb-2">
                <span class="search-result px-4 py-2 rounded">Il y'a ${coursePagedListHolder.nrOfElements} formation(s)</span>
            </div>
            <div class="list-group px-5">
             <table class="table table-bordered table-striped ">
			<thead>
				<tr>
					<th>Code </th>
					<th>Intitulé</th>
				</tr>
			</thead>
			<tbody>
                <c:forEach var="course" items="${coursePagedListHolder.pageList}" varStatus="boucle">
                  
                         <tr>
 <td><a href="<c:url value="/course/${course.code}"/>"><c:out value="${course.code}" /></a></td>
 
 <td><a href="<c:url value="/course/${course.code}"/>"><c:out value="${course.titre}"/></a></td>
 
 
</tr>

</c:forEach>
			</tbody>
</table>
                   
                  
             
            </div>
            <nav class="py-2">
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                        <span class="page-link">Page</span>
                    </li>
                    <c:forEach begin="1" end="${coursePagedListHolder.pageCount}" step="1" varStatus="i">
                        <li class="page-item${page == i.index ? ' active':''}">
                            <c:if test="${advanced == false }">
                                <a class="page-link" href="#" onclick="submitForm(${i.index})">${i.index}</a>
                            </c:if>
                            <c:if test="${advanced != false }">
                                <a class="page-link" href="<c:url value="/?p=${i.index}"/>">${i.index}</a>
                            </c:if>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </c:if>
       </div>
       
      
<%@ include file="scripts.jsp" %>
</body>
</html>
