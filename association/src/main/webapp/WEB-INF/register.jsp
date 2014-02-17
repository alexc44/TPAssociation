<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
 

    <title>Register | association</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <div class="container">
		        <h2 class="form-signout-heading">Please register to access our website.</h2>
		
      <form class="form-signout" role="form" action="<%=request.getContextPath()%>/register" method="post">
      	<c:forEach var="error" items="${signin_error}">
			<div class="alert alert-danger alert-dismissable">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				<strong>Erreur :</strong> ${error} .
			</div>
		</c:forEach>
      
        <input type="text" name="id" class="form-control" placeholder="User id" required autofocus>
        <input type="password" name="mdp" class="form-control" placeholder="Password" required>
        <input type="password" name="mdp2" class="form-control" placeholder="Confirm password" required>
        <input type="text" name="name" class="form-control" placeholder="Name" required>
        <input type="text" name="fname" class="form-control" placeholder="Firstname" required>
        <input type="text" name="adresse" class="form-control" class="adresse" placeholder="Adresse" required>
        <input type="text" name="ville" class="form-control" placeholder="Ville" required>
        <input type="number" name="cp" class="form-control" class="cp" placeholder="CP" required>
        <select name="pays" class="form-control">
        	<option value="France">France</option>
        	<option value="UK">Angleterre</option>
        </select>
        <hr>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>