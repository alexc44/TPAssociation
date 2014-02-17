<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="message" items="${message}">
	<div class="alert alert-info alert-dismissable" style="margin-top: 45px;">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		<strong>Info :</strong> ${message} .
	</div>
</c:forEach>

<h3>Aucun articles</h3>
<hr>
<a class="btn btn-lg btn-success" href="<%=request.getContextPath()%>/articles" role="button">Retour à la liste</a>

<script>
 $('#order').addClass('active');
</script>
