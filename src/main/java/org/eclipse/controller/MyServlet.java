package org.eclipse.controller;

import java.io.*;

import org.eclipse.dao.dao;
import org.eclipse.model.Article;
import org.eclipse.model.Categorie;
import org.eclipse.model.Compte;
import org.eclipse.model.Image;
import org.eclipse.model.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class MyServlet
 */
@MultipartConfig
public class MyServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	dao dao = new dao();

    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		
		if (flag.equalsIgnoreCase("addUserAccount")) {
			this.doAddUserAccount(request, response);
		} else if(flag.equalsIgnoreCase("login")) {
			this.doLogin(request, response);
		} else if(flag.equalsIgnoreCase("addCategorie")) {
			this.doAddCategorie(request, response);
		} else if (flag.equalsIgnoreCase("addArticle")) {
			this.doAddArticle(request, response);
		} else if(flag.equalsIgnoreCase("deleteCategorie")) {
			this.doDeleteCategorie(request, response);
		}
	}
	
	
	public void doAddUserAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String numRue = request.getParameter("numRue");
		String nomRue = request.getParameter("nomRue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String tel = request.getParameter("tel");
		
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		
		User user = new User(prenom, nom, numRue, nomRue, cp, ville, tel);
		
		Compte compte = new Compte();
		compte.setUser(user);
		compte.setLogin(login);
		compte.setPwd(pwd);
		compte.setType("a");
		
		dao.addUserAccount(user, compte);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("connexion.jsp");
	    dispatcher.forward(request, response);
	}
	
	public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		
		Compte compte = dao.checkCredentials(login, pwd);
		
		if(compte != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userOK", compte);
			
			response.sendRedirect("menuAdmin.jsp");
		} else {
			request.setAttribute("errorMessage", "Invalid login");
			RequestDispatcher dispatcher = request.getRequestDispatcher("connexion.jsp");
	        dispatcher.forward(request, response);
		}
	}

	public void doAddCategorie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String designation = request.getParameter("designation");
		
		Categorie cat = new Categorie(designation);
		dao.addCategorie(cat);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("menuAdmin.jsp");
	    dispatcher.forward(request, response);
	}

	public void doAddArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String designation = request.getParameter("designation");
	    int pu = Integer.parseInt(request.getParameter("pu"));
	    int qty = Integer.parseInt(request.getParameter("qty"));
	    String idCatParam = request.getParameter("categorie");

	    Part filePart = request.getPart("image");
	    InputStream inputStream = filePart.getInputStream();
	    byte[] imageData = inputStream.readAllBytes();

	    int idCat = -1;
	    if (idCatParam != null && !idCatParam.isEmpty()) {
	        idCat = Integer.parseInt(idCatParam);
	    }

	    Categorie cat = dao.getCatById(idCat);

	    if (cat != null) {
	        Image image = new Image();
	        image.setImage(imageData);

	        Article article = new Article();
	        article.setCat(cat);
	        article.setDesignation(designation);
	        article.setPu(pu);
	        article.setQty(qty);
	        article.setImage(image);

	        dao.addArticle(article);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("menuAdmin.jsp");
	        dispatcher.forward(request, response);
	    }
	}

	
	public void doDeleteCategorie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCatParam = request.getParameter("categorie");
		
		int idCat= -1;
		if (idCatParam != null && !idCatParam.isEmpty()) {
	        idCat = Integer.parseInt(idCatParam);
	    }
		
		Categorie cat = dao.getCatById(idCat);
		
		if (cat != null) {
			dao.deleteCat(cat);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("menuAdmin.jsp");
		    dispatcher.forward(request, response);
		}
	}
	
	
	
}
