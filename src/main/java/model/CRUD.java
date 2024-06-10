package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CRUD {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROG4691_T1_Flores_Calla_Veronica");
	private EntityManager em = emf.createEntityManager();
	

	public List<Clube> seleccionarTodo() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Clube> cq = cb.createQuery(Clube.class);
		Root<Clube> registro = cq.from(Clube.class);
		CriteriaQuery<Clube> todos = cq.select(registro);
		TypedQuery<Clube> lista = em.createQuery(todos);
		
		return lista.getResultList();
	}
	
	
	public void insertar(Clube club) {
		em.getTransaction().begin();
		em.persist(club);
		em.getTransaction().commit();
		System.out.println("Registro de producto satisfactorio...");
		em.close();
	}
	
	public  void guardar (Clube club) {
		EntityTransaction et = this.em.getTransaction();
		try {
			et.begin();
			this.em.persist(club);
			et.commit();
		}
		catch (Exception e ) {
			if(et !=null) {
				et.rollback();
			}
		} finally {
			this.em.close();
		}
	}
	
	
	public void actualizar(Clube club) {
		em.getTransaction().begin();
		Clube pnew = em.find(Clube.class, club.getId());
		pnew.setId(club.getId());
		pnew.setNombre(club.getNombre());
		
		em.getTransaction().commit();
		System.out.println("La actualizacion fue correcta...");
		em.close();
	}

}
