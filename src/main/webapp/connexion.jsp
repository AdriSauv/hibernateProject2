<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/bootstrap.min(2).css"/>
	<style>
		main {padding: 2rem;}
	</style>
</head>
<body class="container mt-5">

    <div class="card col-md-6 mx-auto">
        <div class="card-body">

            <h2 class="card-title">Connexion</h2>

            <form action="MyServlet?flag=login" method="post">
                <div class="mb-3">
                    <label for="login" class="form-label">Login:</label>
                    <input type="text" class="form-control" name="login" id="login" required>
                </div>
                <div class="mb-3">
                    <label for="pwd" class="form-label">Mot de passe:</label>
                    <input type="password" class="form-control" name="pwd" id="pwd" required>
                </div>
                <div class="mb-3">
                    <button type="submit" class="btn btn-outline-success">Valider</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>