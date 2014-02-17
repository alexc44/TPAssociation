<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Historique des commandes</h3>
<hr>
<table class="table table-hover table-striped">
	<thead>
		<tr>
		  <th>Code</th>
		  <th>Nom</th>
  		  <th>Quantité</th>		  
		  <th>Prix unitaire</th>
		</tr>
	</thead>
	<tbody>
		<!-- Affichage de chaque article en base -->
		<c:forEach var="article"
		 items="${history}" >
			<tr>
				<td>${article.article.code}</td>
				<td>${article.article.nom}</td>
				<td>${article.quantite}</td>
				<td>${article.article.prix}</td>
			</tr>				
		</c:forEach>
	</tbody>
</table>
<hr>
<a class="btn btn-lg btn-primary" href="<%=request.getContextPath()%>/articles" role="button">Retour à la liste</a>
<script>
 $('#user').addClass('active');
</script>