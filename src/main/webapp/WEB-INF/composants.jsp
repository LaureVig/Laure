
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
<title>Composants</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">

		<h1>Création d'un composant</h1>
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

		<h1>Liste des composants actifs</h1>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Libellé</th>
					<th>Attribut 1</th>
					<th>Attribut 2</th>
					<th>Attribut 3</th>
					<th>Attribut 4</th>
					<th>Attribut 5</th>
					<th>Type de composant</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="composant" items="${ composants }">
					<tr>
						<td><c:out value="${composant.nom }" /></td>
						<td><c:out value="${ composant.libelle }" /></td>
						<td><c:out value="${composant.attribut_1 }" /></td>
						<td><c:out value="${composant.attribut_2 }" /></td>
						<td><c:out value="${composant.attribut_3 }" /></td>
						<td><c:out value="${composant.attribut_4 }" /></td>
						<td><c:out value="${composant.attribut_5 }" /></td>
						<td><c:out value="${composant.nom_type_composant }" /></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>