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
import com.ryxen.entity.ComicEntity;

@Repository
public class CategoryRepository extends BaseRepository<CategoryEntity>{

	@Override
	protected Class<CategoryEntity> clazz() {
		// TODO Auto-generated method stub
		return CategoryEntity.class;
	}
	public Page<CategoryEntity> findAllWithPage(Pageable page){
		
		return executeNativeSqlWithPage(page);
		
	}
	// tất cả các services cần thêm hàm search.
			@SuppressWarnings("unchecked")
			public  Page<CategoryEntity> searchAndListPage(Search searchModel,Pageable page) {
				
				// khởi tạo câu lệnh
				
				try {
					Table tbl = clazz().getAnnotation(Table.class);
					String sql = "SELECT * FROM "+tbl.name()+" p WHERE 1=1";
					
					if(!StringUtils.isNullOrEmpty(searchModel.getSeo())) {
						sql=sql+" p.seo = :seo";
						
					}
					// tim kiem san pham theo seachText
					if (!StringUtils.isNullOrEmpty(searchModel.getKeyWord())) {
						sql += " and (p.name like  :keyword " + 
								"or p.id like  :keyword " + 
					
								" or p.code like  :keyword )";
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
							System.out.println("sql:"+sql);
					return new PageImpl<CategoryEntity>( query.getResultList());
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
				// chi lay san pham chua xoa
//				sql += " and p.status=1 ";

				
			}
			@SuppressWarnings("unchecked")
			public Boolean checckExistsCategoryById(Integer id) {
				try {
					
				
						Table tbl = clazz().getAnnotation(Table.class);
						String sql=""
								+             "SELECT CASE WHEN COUNT(*) > 0 THEN "
								+             "TRUE ELSE FALSE END "
								+            "FROM "+tbl.name()+" s "
								+            "WHERE s.id = :id";
						Query query =entityManager.createNativeQuery(sql,clazz());
						query.setParameter("id", id);		
						return (Boolean) query.getSingleResult();
					
					
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("id null");
				}
				return null;
			}
}
