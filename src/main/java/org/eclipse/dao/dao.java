package org.eclipse.dao;
import java.util.Collections;
import java.util.List;

import org.eclipse.model.Article;
import org.eclipse.model.Categorie;
import org.eclipse.model.Compte;
import org.eclipse.model.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class dao {
	
	private static SessionFactory sf;
	
	static {
        try {
            Configuration configuration = new Configuration().configure();
            sf = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }
	
	public void addUserAccount(User user, Compte compte) {
        try (Session session = sf.openSession()) {
            Transaction tr = session.beginTransaction();
            
            session.persist(user);
            session.persist(compte);
            tr.commit();
        } catch  (Exception e) {
        	e.printStackTrace();
        }
    }
	
	public Compte checkCredentials(String login, String pwd) {
		try (Session session = sf.openSession()) {
	        Criteria criteria = session.createCriteria(Compte.class);
	        criteria.add(Restrictions.eq("login", login));
	        criteria.add(Restrictions.eq("pwd", pwd));

	        return (Compte) criteria.uniqueResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public void addCategorie(Categorie cat) {
		try (Session session = sf.openSession()) {
			Transaction tr = session.beginTransaction();
			
			session.persist(cat);
			
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addArticle(Article article) {
		try (Session session = sf.openSession()) {
			Transaction tr = session.beginTransaction();
			
			session.persist(article);
			
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
        try (Session session = sf.openSession()) {
            
            List<User> userList = session.createQuery("FROM user").list();
            
            return userList;
        }
    }
	
	public List<Categorie> getAllCat() {
        try (Session session = sf.openSession()) {
            
            List<Categorie> catList = session.createQuery("FROM Categorie").list();

            return catList;
            
        } catch (Exception e) {
        	e.printStackTrace();
        	return Collections.emptyList();
        }
    }

	public Categorie getCatById(int idCat) {
        try (Session session = sf.openSession()) {
            Transaction tr = session.beginTransaction();
            
            Categorie cat = session.get(Categorie.class, idCat);
            
            tr.commit();
            return cat;
        }
    }

}