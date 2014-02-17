<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
 <div class="masthead">
	<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<h3 class="text-muted brand">ASSOCIATION 2LABALLE</h3>
			</div>
			<div class="col-sm3">
				<p><span class="glyphicon glyphicon-user"> | </span><a href="<%=request.getContextPath()%>/logout">   ${adherent.getId()}</a></p>
			</div>
		</div>
    </div>
	<ul class="nav nav-justified">
       <li id="home"><a href="<%=request.getContextPath()%>/">Home</a></li>
       <li id="article" ><a href="<%=request.getContextPath()%>/article">Articles</a></li>
       <li id="order" ><a href="<%=request.getContextPath()%>/order">Commande</a></li>
       <li id="user" ><a href="<%=request.getContextPath()%>/account">Mon compte</a></li>
     </ul>
</div>
