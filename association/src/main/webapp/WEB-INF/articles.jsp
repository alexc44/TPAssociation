<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Liste des articles</h3>
<hr>
<table class="table table-hover table-striped">
	<thead>
		<tr>
		  <th>Code</th>
		  <th>Nom</th>
		  <th>Prix</th>
		  <th>Stock</th>
		  <th>Commander</th>
		</tr>
	</thead>
	<tbody>
		<!-- Affichage de chaque article en base -->
		<c:forEach var="article" items="${requestScope.articles}" >
			<tr>
				<td>${article.code}</td>
				<td>${article.nom}</td>
				<td>${article.prix}</td>
				<td>${article.stock}</td>
				<td><a class="btn btn-success" href="<%=request.getContextPath()%>/order?article=${article.code}">J'en veux</a></td>      
			</tr>				
		</c:forEach>
	</tbody>
</table>
<script>
 $('#article').addClass('active');
</script>