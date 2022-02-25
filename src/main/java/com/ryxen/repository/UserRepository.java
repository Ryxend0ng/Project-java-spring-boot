package com.ryxen.repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.Table;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mysql.cj.util.StringUtils;
import com.ryxen.dto.Search;
import com.ryxen.entity.CategoryEntity;
import com.ryxen.entity.UserEntity;

@Repository
public class UserRepository extends BaseRepository<UserEntity> {

	@Override
	protected Class<UserEntity> clazz() {
		// TODO Auto-generated method stub
		return UserEntity.class;
	}
	
public Page<UserEntity> findAllWithPage(Pageable page){
		
		return executeNativeSqlWithPage(page);
		
	}
	// tất cả các services cần thêm hàm search.
			@SuppressWarnings("unchecked")
			public  Page<UserEntity> searchAndListPage(Search searchModel,Pageable page) {
				
				// khởi tạo câu lệnh
				
				try {
					Table tbl = clazz().getAnnotation(Table.class);
					String sql = "SELECT * FROM "+tbl.name()+" p WHERE 1=1";
					if(!StringUtils.isNullOrEmpty(searchModel.getSeo())) {
						sql=sql+" p.seo = :seo";
						
					}
					// tim kiem san pham theo seachText
					if (!StringUtils.isNullOrEmpty(searchModel.getKeyWord())) {
						sql += " and (p.username like  :keyword " + 
					" or p.id like  :keyword  " +
								" or p.status like  :keyword )";
					}
					Query query = entityManager.createNativeQuery(sql, clazz());					
							if(page != null ) {
								query.setFirstResult((int) (page.getPageNumber()*page.getPageSize()));
								query.setMaxResults(page.getPageSize());	
								
							}
							if(!StringUtils.isNullOrEmpty(searchModel.getSeo())) {
								query.setParameter("seo", searchModel.getSeo());
								
							}
							// tim kiem san pham theo seachText
							if (!StringUtils.isNullOrEmpty(searchModel.getKeyWord())) {
								query.setParameter("keyword","%"+searchModel.getKeyWord()+"%");
							}
					return new PageImpl<UserEntity>( query.getResultList());
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
				// chi lay san pham chua xoa
//				sql += " and p.status=1 ";

				
			}
			
			@SuppressWarnings("unchecked")
			public UserEntity findByEmail(String email) {
				try {
					UserEntity foundEntity = null;
					if(!StringUtils.isNullOrEmpty(email)) {
						Table tbl = clazz().getAnnotation(Table.class);
						String sql="select * from "+ tbl.name() +" e"+" where  e.email = :email";
						Query query =entityManager.createNativeQuery(sql,clazz());
						query.setParameter("email", email);		
						List<UserEntity> results = query.getResultList();	
						if(!results.isEmpty()){
						    // ignores multiple results
						    foundEntity = (UserEntity) results.get(0);
						}	
					}else {
						return null;
					}
					return (UserEntity) foundEntity;
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("email null");
				}
				return null;
			}
			@SuppressWarnings("unchecked")
			public UserEntity findByUserName(String name) {
				try {
					UserEntity foundEntity = null;
					if(!StringUtils.isNullOrEmpty(name)) {
						Table tbl = clazz().getAnnotation(Table.class);
						String sql="select * from "+ tbl.name() +" e"+" where  e.username = :name";
						Query query =entityManager.createNativeQuery(sql,clazz());
						query.setParameter("name", name);		
						List<UserEntity> results = query.getResultList();	
						if(!results.isEmpty()){
						    // ignores multiple results
						    foundEntity = (UserEntity) results.get(0);
						}	
					}else {
						return null;
					}
					return (UserEntity) foundEntity;
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("email null");
				}
				return null;
			}
			@SuppressWarnings({ "unchecked", "unused" })
			Boolean existsByEmail(String email) {
				try {
					UserEntity foundEntity = null;
					if(!StringUtils.isNullOrEmpty(email)) {
						Table tbl = clazz().getAnnotation(Table.class);
						String sql="select * from "+ tbl.name() +" e"+" where  e.email = :email";
						Query query =entityManager.createNativeQuery(sql,clazz());
						query.setParameter("email", email);		
						List<UserEntity> results = query.getResultList();	
						if(!results.isEmpty()){
						    // ignores multiple results
						    foundEntity = (UserEntity) results.get(0);
						    return true;
						}	
					}else {
						return false;
					}
					
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("email null");
					return false;
				}
				return false;
			}
			
}
