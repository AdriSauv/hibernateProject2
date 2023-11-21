<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.eclipse.dao.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.eclipse.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min(2).css"/>
<link rel="stylesheet" href="css/menuAdmin.css"/>
<title>Menu Admin</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#"><%= ((org.eclipse.model.Compte) session.getAttribute("userOK")).getLogin() %></a>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarColor02">
		      <ul class="navbar-nav me-auto">
		        <li class="nav-item">
		          <a class="nav-link active" href="menuAdmin.jsp">Home
		            <span class="visually-hidden">(current)</span>
		          </a>
		        </li>
		        <li class="nav-item">
		        	<a class="nav-link" href="#">Gerer mon compte</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">Gerer les utilisateurs</a>
		        </li>
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" data-toggle="dropdown"  role="button" aria-haspopup="true" aria-expanded="false">Articles</a>
		          <div class="dropdown-menu">
		            <a class="dropdown-item" href="articles.jsp">Voir les articles</a>
		            <a class="dropdown-item" href="#" onclick="showForm('addArticleForm')">Ajouter</a>
		            <a class="dropdown-item" href="#" onclick="showForm('modifyArticleForm')">Modifier</a>
		            <a class="dropdown-item" href="#" onclick="showForm('deleteArticleForm')">Supprimer</a>
		          </div>
		        </li>
		        <script>
                     function showForm(formId) {
                         $('form').hide();
                         $('#' + formId).show();
                     }
                 </script>
		         <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" data-toggle="dropdown"  role="button" aria-haspopup="true" aria-expanded="false">Catégories</a>
		          <div class="dropdown-menu">
		            <a class="dropdown-item" href="#" onclick="showForm('addCatForm')">Ajouter</a>
		            <a class="dropdown-item" href="#" onclick="showForm('modifyCatForm')">Modifier</a>
		            <a class="dropdown-item" href="#" onclick="showForm('deleteCatForm')">Supprimer</a>
		          </div>
		        </li>
		      </ul>
		      <div class="d-flex">
		        <a href="logout.jsp" class="btn btn-secondary my-2 my-sm-0">Deconnexion</a>
		      </div>
		    </div>
		  </div>
		</nav>
	</header>
	<main>
		<form id="addArticleForm" style="display: none;" method="post" action="MyServlet?flag=addArticle" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="designation" class="form-label">Désignation:</label>
                <input type="text" class="form-control" name="designation" id="designation" required>
            </div>
            <div class="mb-3">
                <label for="pu" class="form-label">Prix: </label>
                <input type="text" class="form-control" name="pu" id="pu" required>
            </div>
            <div class="mb-3">
                <label for="qty" class="form-label">Quantité: </label>
                <input type="text" class="form-control" name="qty" id="qty" required>
            </div>
            <div>
	            <label for="categorie" class="form-label">Catégorie: </label>
	            <select class="form-select" id="categorie" name="categorie">
	            	<option value="">Selectionnez une catégorie</option>
	                <%
	                    dao dao = new dao();
	                    List<Categorie> categories = dao.getAllCat();
	
	                    for (Categorie cat : categories) {
	                %>
	                <option value="<%= cat.getIdCat() %>"><%= cat.getDesignation() %></option>
	                <%
	                    }
	                %>
	            </select>
	        </div>
	        <br>
	        <div class="mb-3">
		        <label for="image" class="form-label">Image</label>
		        <input type="file" class="form-control" name="image" id="image">
		    </div>
	        <br>
            <button class="btn btn-outline-success" type="submit">Envoyer</button>
            <button class="btn btn-outline-danger" type="reset">Reset</button>
        </form>
        
        <form id="addCatForm" style="display: none;" method="post" action="MyServlet?flag=addCategorie">
            <div class="mb-3">
                <label for="designation" class="form-label">Désignation:</label>
                <input type="text" class="form-control" name="designation" id="designation" required>
            </div>
            <button class="btn btn-outline-success" type="submit">Envoyer</button>
            <button class="btn btn-outline-danger" type="reset">Reset</button>
        </form>
        
        <form id="deleteCatForm" style="display: none;" method="post" action="MyServlet?flag=deleteCategorie">
           <div>
	            <label for="categorie" class="form-label">Catégorie: </label>
	            <select class="form-select" id="categorie" name="categorie">
	            	<option value="">Selectionnez une catégorie à supprimer</option>
	                <%
	                    for (Categorie cat : categories) {
	                %>
	                <option value="<%= cat.getIdCat() %>"><%= cat.getDesignation() %></option>
	                <%
	                    }
	                %>
	            </select>
	        </div>
	        <br>
            <button class="btn btn-outline-success" type="submit">Envoyer</button>
            <button class="btn btn-outline-danger" type="reset">Reset</button>
        </form>
	</main>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>