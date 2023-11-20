<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min(2).css"/>
	<style>
		body {padding: 2rem;}
	</style>
	<title>Formulaire d'inscription</title>
	
</head>
<body>
	<form action="MyServlet?flag=addUserAccount" method="post">
		    <fieldset>
		        <legend>Inscription</legend>
		        <br>
		        <div class="mb-3">
		            <label for="prenom" class="form-label">Prénom :</label>
		            <input type="text" class="form-control" name="prenom" id="prenom">
		        </div>
		        <div class="mb-3">
		            <label for="nom" class="form-label">Nom :</label>
		            <input type="text" class="form-control" name="nom" id="nom">
		        </div>
		        <div class="mb-3">
		            <label for="numRue" class="form-label">Numéro de rue :</label>
		            <input type="text" class="form-control" name="numRue" id="numRue">
		        </div>
		        <div class="mb-3">
		            <label for="nomRue" class="form-label">Nom de rue :</label>
		            <input type="text" class="form-control" name="nomRue" id="nomRue">
		        </div>
		        <div class="mb-3">
		            <label for="cp" class="form-label">Code postal :</label>
		            <input type="text" class="form-control" name="cp" id="cp">
		        </div>
		        <div class="mb-3">
		            <label for="ville" class="form-label">Ville :</label>
		            <input type="text" class="form-control" name="ville" id="ville">
		        </div>
		        <div class="mb-3">
		            <label for="tel" class="form-label">Téléphone :</label>
		            <input type="text" class="form-control" name="tel" id="tel">
		        </div>
		        <div class="mb-3">
		            <label for="login" class="form-label">Login :</label>
		            <input type="text" class="form-control" name="login" id="login">
		        </div>
		        <div class="mb-3">
		            <label for="pwd" class="form-label">Mot de passe</label>
		            <input type="password" class="form-control" name="pwd" id="pwd">
		        </div>
		        <button type="submit" class="btn btn-outline-success">Envoyer</button>
		        <button type="reset" class="btn btn-outline-warning">Reset</button>
		    </fieldset>
		</form>
	</body>
</html>