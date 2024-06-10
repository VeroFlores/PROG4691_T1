package dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CommonDAOImpl<E> {
	
	protected static EntityManagerFactory EMF= 
			Persistence.createEntityManagerFactory("PROG4691_T1_Flores_Calla_Veronica");
	
	EntityManager em;
	
	private Class<E> type;
	
	public CommonDAOImpl() {
		this.em = EMF.createEntityManager();
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}
	
	public void guardar (E entity) {
		EntityTransaction et = this.em.getTransaction();
		try {
			et.begin();
			this.em.persist(entity);
			et.commit();
		} catch (Exception e ) {
			if(et != null) {
				et.rollback();
			}
		}
	}
	
	public List<E> consultar() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<E> criteriaQuery = cb.createQuery(this.type);
		Root<E> root = criteriaQuery.from(this.type);
		criteriaQuery.select(root);
		TypedQuery<E> query = em.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public E consultarPorId(int id) {
		return this.em.find(type, id);
	}
	
	
}
