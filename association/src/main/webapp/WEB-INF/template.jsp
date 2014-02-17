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
    

    <title>Association</title>

   <!-- Bootstrap core CSS --> 
    <link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.servletContext.contextPath}/css/justified-nav.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

     <!-- Header -->
		<jsp:include page='/WEB-INF/header.jsp' />
      <!-- content -->
      
      <jsp:include page='/WEB-INF/${requestScope.page}.jsp' />
      


      <!-- Site footer -->
      <div class="footer">
        <p>TP Association 2014 - Programmation 3 & Techweb 2- J2EE/JPA ...</p>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
    
  </body>
</html>
