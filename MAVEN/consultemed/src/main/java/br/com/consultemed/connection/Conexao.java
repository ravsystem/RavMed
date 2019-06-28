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
	
	public static void removeOperador(Operador operador) {
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		operador = em.find(Operador.class, operador.getId());
        em.remove(operador);
        em.getTransaction().commit();
		
	}
	
	public static Operador selecionaOperador(Long id) {
		
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Operador p where p.id = :id");
		query.setParameter("id", id);
		
		List<Operador> operadores = query.getResultList();
		Operador operador = new Operador();;
		
		for(int i = 0; i < operadores.size(); i++) {
			
			operador.setId(operadores.get(i).getId());
			operador.setNome(operadores.get(i).getNome());
			operador.setSenha(operadores.get(i).getSenha());
			operador.setTipo(operadores.get(i).getTipo());

		}
		
		return operador;
		
	}
}
