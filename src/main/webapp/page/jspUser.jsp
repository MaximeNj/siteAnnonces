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




	<f:form action="SaveAnnonce" modelAttribute="a" enctype="multipart/form-data" method="POST">
	<f:hidden path="idAnnonce" />

Titre_Annonce: <f:input path = "titreAnnonce"/>
<br>
Description_Annonce: <f:textarea path = "descriAnnonce" rows = "3" cols = "15"/>
<br>


<br>
Categorie :  <f:select  path="catAnnonce.idCat">
	<f:options items="${categories}" itemValue="idCat" itemLabel="nomCat" />
	
</f:select>

	
	Choisir image: <input type="file"  name="fichier" />


		<input type="submit" value="Envoyer">
	</f:form>






	<table>
		<tr>
			<td>id annonce</td>
			<td>Titre annonce</td>
			<td>Description annonce</td>
			<td>Date expiration Annonce</td>
			<td>Statut annonce</td>
			<td>Categorie annonce</td>
			

			<td>Action 1</td>
			<td>Action 2</td>
			<td>Action 3</td>
			

		</tr>
		<c:forEach items="${listeAnnonces}" var="a">
			<tr>
				<td>${a.idAnnonce}</td>
				<td><img src="http://localhost:8015/dossierimage/${a.photoAnnonce}" width="100px" height="100px"> </td>
				<td>${a.titreAnnonce}</td>
				<td>${a.descriAnnonce}</td>
				<td>${a.dateExp}</td>
				<td>${a.statut}</td>
				<td>${a.catAnnonce.nomCat}</td>
				<td><a href ="SupprAnnonce?id=${a.idAnnonce}">Supprimer </a></td>
				<td><a href ="ModifAnnonce?id=${a.idAnnonce}">Modifier </a></td>
				<td><a href ="afficherComs?id=${a.idAnnonce}">AfficherCommentaires </a></td>


			</tr>

		</c:forEach>
	</table>








</body>
</html>