package com.ryxen.repository;

import javax.persistence.Query;
import javax.persistence.Table;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mysql.cj.util.StringUtils;
import com.ryxen.dto.Search;
import com.ryxen.entity.RoleEntity;
import com.ryxen.entity.UserEntity;

@Repository
public class RoleRepository extends BaseRepository<RoleEntity>{

	@Override
	protected Class<RoleEntity> clazz() {
		// TODO Auto-generated method stub
		return RoleEntity.class;
	}
	public Page<RoleEntity> findAllWithPage(Pageable page){
		
		return executeNativeSqlWithPage(page);
		
	}
	// tất cả các services cần thêm hàm search.
			@SuppressWarnings("unchecked")
			public  Page<RoleEntity> searchAndListPage(Search searchModel,Pageable page) {
				
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
					return new PageImpl<RoleEntity>( query.getResultList());
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
				// chi lay san pham chua xoa
//				sql += " and p.status=1 ";

				
			}
}
