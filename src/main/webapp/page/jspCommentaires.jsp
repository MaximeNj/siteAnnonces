<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head >
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Page de commentaires</title>
</head>
<body>


	<h1> ${a.titreAnnonce}</h1>
<h4>Description annonce:

</h4>
<p>${a.descriAnnonce}</p>

	<f:form action="SaveComm" modelAttribute="c">
	<input type="hidden" name="idAnnonce" value="${a.idAnnonce}">
	<f:hidden path="idCommentaire" />
<!--
Utilisateur: <f:input path = "commUser"/>
<br>-->
Commentaire: <f:textarea path = "contenuCommentaire" rows = "3" cols = "15"/>
<br>


		<input type="submit" value="Envoyer">
	</f:form>

	<table class="table">
		<thead class="thead-dark">
		  <tr>
			<th scope="col">#</th>
			<th scope="col">First</th>
			
			
		  </tr>
		</thead>
		<tbody>
		  <tr>
			<th scope="row">1</th>
			<td>Mark</td>
			
		  </tr>
		  <tr>
			<th scope="row">2</th>
			<td>Jacob</td>
			
		  </tr>
		  <tr>
			<th scope="row">3</th>
			<td>Larry</td>
			
		  </tr>
		</tbody>
	  </table>
	  
	  <table class="table">
		<thead class="thead-dark">
		  <tr>
			<th scope="col">id Commentaire</th>
			<th scope="col">Commentaire</th>
			
		  </tr>
		</thead>
		<tbody>
			<c:forEach items="${listeComm}" var="c">
		  <tr>
			<th scope="row">${c.idCommentaire}</th>
			<td>${c.contenuCommentaire}</td>
			<td></td>
			
		  </tr>
		</c:forEach>
		
		</tbody>
	  </table>




	<table>
		<tr>
			<td>id annonce</td>
			<td>Titre annonce</td>
			<td>Description annonce</td>
			
			

			<td>Action 1</td>
			<td>Action 2</td>
			

		</tr>
		<c:forEach items="${listeComm}" var="c">
			<tr>
				<td>${c.idCommentaire}</td>
				<td>${c.contenuCommentaire}</td>
				<td>${c.commAnnonce}</td>
				
				<td><a href ="SupprComm?id=${c.idCommentaire}">Supprimer </a></td>
				<td><a href ="ModifComm?id=${c.idCommentaire}">Modifier </a></td>
				


			</tr>

		</c:forEach>
	</table>








</body>
</html>