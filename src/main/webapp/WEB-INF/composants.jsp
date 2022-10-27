
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8" />
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>Composants</title>
</head>
<body>
<%@ include file="menu.jsp"  %>
<div class="container">

	<h1> Création d'un composant </h1>
    <form method="post" action="bonjour">
        <p>
            <label for="nom">Nom : </label>
            <input type="text" name="nom" id="nom" />
        </p>
        <p>
            <label for="libelle">Libellé : </label>
            <input type="text" name="libelle" id="libelle" />
        </p>
        <p>
            <label for="attribut_1">Attribut 1 : </label>
            <input type="text" name="attribut_1" id="attribut_1" />
        </p>
        <p>
            <label for="attribut_2">Attribut 2 : </label>
            <input type="text" name="attribut_2" id="attribut_2" />
        </p>
       <p>
            <label for="attribut_3">Attribut 3 : </label>
            <input type="text" name="attribut_3" id="attribut_3" />
        </p>
        <p>
            <label for="attribut_4">Attribut 4 : </label>
            <input type="text" name="attribut_4" id="attribut_4" />
        </p>
        <p>
            <label for="attribut_5">Attribut 5 : </label>
            <input type="text" name="attribut_5" id="attribut_5" />
        </p>
 
		<p>
		<label for=id_type_composant">Type composant : </label>
    	<select name="itemSelected">
			  <c:forEach var="composant" items="${ types }">

			   <option value="${composant.id_type_composant}">${ composant.nom }</option>
			   </c:forEach>
				</select>
 		</p>
         <input class="btn btn-primary" type="submit" value="Submit"/>
    </form>
    
    <h1>Liste des composants actifs</h1>
    <table class="table table-striped table-bordered">
    <tbody> 
    <tr>
    <td>Nom</td>
    <td>Libellé</td>
    <td>Attribut 1</td>
    <td>Attribut 2</td>
    <td>Attribut 3</td>
    <td>Attribut 4</td>
    <td>Attribut 5</td>
    <td>Type de composant</td>
    </tr>  
    <c:forEach var="composant" items="${ composants }">
    <tr>
    <td><c:out value="${composant.nom }" /></td>
    <td><c:out value="${ composant.libelle }" /></td>
    <td><c:out value="${composant.attribut_1 }" /></td>  
    <td><c:out value="${composant.attribut_2 }" /></td>  
    <td><c:out value="${composant.attribut_3 }" /></td>  
    <td><c:out value="${composant.attribut_4 }" /></td>  
    <td><c:out value="${composant.attribut_5 }" /></td>  
    <td><c:out value="${composant.id_type_composant }" /></td>       
        </tr>  
        </c:forEach>
        
    </tbody>
</table> 
</div>   
</body>
</html>