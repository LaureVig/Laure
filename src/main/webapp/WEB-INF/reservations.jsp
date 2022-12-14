<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8" />
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>Réservations</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<h1>Création d'une réservation</h1>
		<form method="post" action="composants">
			<p>
				<label for="id_user" class="form-label">Utilisateur </label> <input type="text"
					name="id_user" id="id_user" class="form-control" />
			</p>
			<p>
				<label for="nom" class="form-label">Nom </label> <input type="text"
					name="nom" id="nom" class="form-control" />
			</p>
			<p>
				<label for="libelle" class="form-label">Libellé </label> <input
					type="text" name="libelle" id="libelle" class="form-control" />
			</p>
			<p>
				<label for="indice" class="form-label">Indice </label> <input
					type="number" name="indice" id="indice" class="form-control" />
			</p>
			<p>
				<label for="date_creation" class="form-label">Date de création </label> <input
					type="datetime-local" name="date_creation" id="date_creation" class="form-control" />
			</p>
			<p>
				<label for="date_liberation" class="form-label">Date de libération </label> <input
					type="datetime-local" name="date_liberation" id="date_liberation" class="form-control" />
			</p>
			<p>
				<label for="actif" class="form-label">Actif </label> <input
					type="radio" name="actif" id="actif" class="form-control" />
			</p>
			<p>
				<label for="commentaire" class="form-label">Commentaire </label> <input
					type="text" name="commentaire" id="commentaire" class="form-control" />
			</p>

			<p>
				<label for="id_env" class="form-label">Environnement </label> 
				<select name="id_env" class="form-control">
					<c:forEach var="env" items="${ envs }">
						<option value="${env.id_env}">${ env.nom }</option>
					</c:forEach>
				</select>
			</p>
			<input class="btn btn-primary g-col-4" type="submit"
				value="Créer le composant" />
		</form>

		<h1>Liste des réservations</h1>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>id_reserv </th>
					<th>identifiant user</th>
					<th>Nom</th>
					<th>Libellé</th>
            		<th>indice </th>
            		<th>date_creation </th>
            		<th>date_libération </th>
            		<th>actif</th>
            		<th>commentaire</th>
            		<th>id_env</th>
			</thead>
			<tbody>
				<c:forEach var="resa" items="${ reservations }">
					<tr>
						<td><c:out value="${resa.id_reserv }" /></td>
						<td><c:out value="${resa.id_user }" /></td>
						<td><c:out value="${resa.nom }" /></td>
						<td><c:out value="${resa.libelle }" /></td>
						<td><c:out value="${resa.indice }" /></td>
						<td><c:out value="${resa.date_creation }" /></td>
						<td><c:out value="${resa.date_liberation }" /></td>
						<td><c:out value="${resa.actif }" /></td>
						<td><c:out value="${resa.commentaire }" /></td>
						<td><c:out value="${resa.id_env }" /></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>