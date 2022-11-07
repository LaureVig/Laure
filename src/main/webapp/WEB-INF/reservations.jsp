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
				<label for="nom" class="form-label">Nom </label> <input type="text"
					name="nom" id="nom" class="form-control" />
			</p>
			<p>
				<label for="libelle" class="form-label">Libellé </label> <input
					type="text" name="libelle" id="libelle" class="form-control" />
			</p>
			<p>
				<label for="attribut_1" class="form-label">Attribut 1 </label> <input
					type="text" name="attribut_1" id="attribut_1" class="form-control" />
			</p>
			<p>
				<label for="attribut_2" class="form-label">Attribut 2 </label> <input
					type="text" name="attribut_2" id="attribut_2" class="form-control" />
			</p>
			<p>
				<label for="attribut_3" class="form-label">Attribut 3 </label> <input
					type="text" name="attribut_3" id="attribut_3" class="form-control" />
			</p>
			<p>
				<label for="attribut_4" class="form-label">Attribut 4 </label> <input
					type="text" name="attribut_4" id="attribut_4" class="form-control" />
			</p>
			<p>
				<label for="attribut_5" class="form-label">Attribut 5 </label> <input
					type="text" name="attribut_5" id="attribut_5" class="form-control" />
			</p>

			<p>
				<label for="id_type_composant" class="form-label">Type de
					composant </label> <select name="id_type_composant" class="form-control">
					<c:forEach var="composant" items="${ types }">
						<option value="${composant.id_type_composant}">${ composant.nom }</option>
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
					<th>Nom</th>
					<th>Libellé</th>
                	<th>identifiant user</th>
                 	<th>id_reserv </th>
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
						<td><c:out value="${resa.nom }" /></td>
						<td><c:out value="${resa.libelle }" /></td>
						<td><c:out value="${resa.id_user }" /></td>
						<td><c:out value="${resa.id_reserv }" /></td>
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