<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page de cat&eacute;gories</title>
</head>
<body>




	<f:form action="saveCat" modelAttribute="c">
	<f:hidden path="idCat" />
Nom_Categorie: <f:input path="nomCat" />
		<br>

		<input type="submit" value="Envoyer">
	</f:form>






	<table>
		<tr>
			<td>id</td>
			<td>NomCat</td>
			
			<td>Action 1</td>
			<td>Action 2</td>
			<td>Action 3</td>

		</tr>
		<c:forEach items="${categories}" var="c">
			<tr>
				<td>${c.idCat}</td>
				<td>${c.nomCat}</td>
				
				<td><a href ="SupprimerCat?id=${c.idCat}">Supprimer </a></td>
				<td><a href ="ModifierCat?id=${c.idCat}">Modifier </a></td>
				


			</tr>

		</c:forEach>
	</table>








</body>
</html>