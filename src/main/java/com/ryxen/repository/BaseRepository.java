package com.ryxen.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.ryxen.dto.Search;
import com.ryxen.entity.BaseEntity;



@Repository
public abstract class BaseRepository <E extends BaseEntity> {
	
		@PersistenceContext
		EntityManager entityManager;

		protected abstract Class<E> clazz();

		public E getById(int id) {
			return entityManager.find(clazz(), id);
		}
		
		@SuppressWarnings("unchecked")
		public List<E> findAll() {
			Table tbl = clazz().getAnnotation(Table.class);
			return (List<E>) entityManager.createNativeQuery("SELECT * FROM " + tbl.name(), clazz()).getResultList();
		}
		@SuppressWarnings("unchecked")
		public Page<E> findAllByTypePage() {
			try {
				Table tbl = clazz().getAnnotation(Table.class);
				String sql="select *  from "+ tbl.name() +" e";
				Query query = entityManager.createNativeQuery(sql, clazz());					
				return new PageImpl<E>( query.getResultList());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		@SuppressWarnings("unchecked")
		public E findById(Integer id) {
			try {
				E foundEntity = null;
				if(id != 0) {
					Table tbl = clazz().getAnnotation(Table.class);
					String sql="select * from "+ tbl.name() +" e"+" where  e.id = :id";
					Query query =entityManager.createNativeQuery(sql,clazz());
					query.setParameter("id", id);		
					List<E> results = query.getResultList();	
					if(!results.isEmpty()){
					    // ignores multiple results
					    foundEntity = (E) results.get(0);
					}	
				}else {
					return null;
				}
				return (E) foundEntity;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("id null");
			}
			return null;
		}
		@SuppressWarnings("unchecked")
		public List<E> findByIdTypeOfList(Integer id) {
			try {
			
				
					Table tbl = clazz().getAnnotation(Table.class);
					String sql="select * from "+ tbl.name() +" e"+" where  e.id = :id";
					Query query =entityManager.createNativeQuery(sql,clazz());
					query.setParameter("id", id);		
					List<E> results = query.getResultList();	
				
				return  results;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("id null");
			}
			return null;
		}
		@SuppressWarnings("unchecked")
		public E loadByUserName(String username) {
			try {
				E foundEntity = null;
				if(username != null) {
					Table tbl = clazz().getAnnotation(Table.class);
					String sql="select * from "+ tbl.name() +" e"+" where  e.username = :username";
					Query query =entityManager.createNativeQuery(sql,clazz());
					query.setParameter("username", username);		
					List<E> results = query.getResultList();	
					if(!results.isEmpty()){
					    // ignores multiple results
					    foundEntity = (E) results.get(0);
					}else {	
						return null;
					}
				}else {
					return null;
				}
				return (E) foundEntity;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("username null");
			}
			return null;
		}
		@Transactional
		public E saveOrUpdate(E entity) {
			if (entity.getId() == null || entity.getId() <= 0) {
				entityManager.persist(entity);
				return entity;
			} else {
				return entityManager.merge(entity);
			}
		}
		@Transactional
		public void delete(E entity) {
			entityManager.remove(entity);
		}

		public void deleteById(int id) {
			try {
				Table tbl = clazz().getAnnotation(Table.class);
				String sql="delete  from "+ tbl.name() +" e"+" where  e.id = :id";
				Query query =entityManager.createNativeQuery(sql,clazz());
				query.setParameter("id", id);
				query.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		
		@SuppressWarnings("unchecked")
		public List<E> executeNativeSql(String sql) {
			try {
				Query query = entityManager.createNativeQuery(sql, clazz());
				return query.getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<E>();
			}
		}
		@SuppressWarnings("unchecked")
		public List<E> findByCategoryId(Integer categoryId) {
			try {
				Table tbl = clazz().getAnnotation(Table.class);
				String sql="select * from "+ tbl.name() +" e"+" where  e.category_id = :category_id";
				Query query =entityManager.createNativeQuery(sql,clazz());
				query.setParameter("category_id", categoryId);
				return (List<E>)query.getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<E>();
			}
		}
		@SuppressWarnings("unchecked")
		public List<E> findByTopByCategoryId(Integer count,Integer categoryId) {
			try {
				Table tbl = clazz().getAnnotation(Table.class);
				String sql="select *  from "+ tbl.name() +" e";
				Query query=null;
				if(categoryId == 0) {
					sql=sql+ " limit "+count;
					
					query=entityManager.createNativeQuery(sql,clazz());
				}else {
					sql=sql+ " where e.category_id = :category_id limit "+count;
					query =entityManager.createNativeQuery(sql,clazz());
					query.setParameter("category_id", categoryId);
				}		
				
				return (List<E>)query.getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<E>();
			}
		}
		@SuppressWarnings("unchecked")
		public List<E> findByCreatedDate(String createdDate ) {
			try {
				Table tbl = clazz().getAnnotation(Table.class);
				String sql="select *  from "+ tbl.name() +" e"+" where  e.created_date = :createdDate";
	
				Query query =entityManager.createNativeQuery(sql,clazz());
				query.setParameter("createdDate", createdDate);
				return (List<E>)query.getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<E>();
			}
		}
		@SuppressWarnings({ "unchecked" })
		public E findByCode(String codeD) {
			try {
				Table tbl = clazz().getAnnotation(Table.class);
				String sql="select * from "+ tbl.name() +" e"+" where  e.code = :codeD";
				System.out.println("sql:"+sql);
				Query query =entityManager.createNativeQuery(sql,clazz());
				query.setParameter("codeD", codeD);
				
				List<E> results = query.getResultList();
				E foundEntity = null;
				if(!results.isEmpty()){
				    // ignores multiple results
				    foundEntity = (E) results.get(0);
				}
				return foundEntity;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		@SuppressWarnings("unchecked")
		public Page<E> executeNativeSqlWithPage (Pageable page ) {
			try {
				Table tbl = clazz().getAnnotation(Table.class);
				
				String sql = "SELECT * FROM "+tbl.name()+" p WHERE 1=1";
				Query query = entityManager.createNativeQuery(sql, clazz());					
						if(page != null ) {
							query.setFirstResult((int) (page.getPageNumber()*page.getPageSize()));
							query.setMaxResults(page.getPageSize());	
							
						}				
				return new PageImpl<E>( query.getResultList());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		@SuppressWarnings({ "unchecked" })
		public E findBySeo(String seo) {
			try {
				Table tbl = clazz().getAnnotation(Table.class);
				String sql="select * from "+ tbl.name() +" e"+" where  e.seo = :seo";
				System.out.println("sql:"+sql);
				Query query =entityManager.createNativeQuery(sql,clazz());
				query.setParameter("seo", seo);
				
				List<E> results = query.getResultList();
				E foundEntity = null;
				if(!results.isEmpty()){
				    // ignores multiple results
				    foundEntity = (E) results.get(0);
				}
				return foundEntity;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
