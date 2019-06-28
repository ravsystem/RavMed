package br.com.consultemed.connection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.consultemed.model.Operador;

public class Conexao {
	
	public static EntityManagerFactory emf;
	
	public static void iniciarFabrica() {
		emf = Persistence.createEntityManagerFactory("consultemed"); 
	}
	
	public static void guardar(Object o) {
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.persist(o);
		et.commit();
		em.close();
	}
	
	public static void alterar(Object o) {
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.merge(o);
		et.commit();
		em.close();
         
	}
	
	public static List<Operador> listarOperador() {
		
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Operador");
		
		List<Operador> listaAgentes = query.getResultList();
        return listaAgentes;
	}
	
	
}
