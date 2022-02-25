package com.ryxen.repository;

import java.io.File;
import java.io.IOException;

import javax.persistence.Query;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.util.StringUtils;
import com.ryxen.dto.Search;
import com.ryxen.entity.ComicEntity;
import com.ryxen.entity.NewsEntity;
import com.ryxen.entity.RoleEntity;

@Repository
public class NewRepository extends BaseRepository<NewsEntity>{

	@Override
	protected Class<NewsEntity> clazz() {
		// TODO Auto-generated method stub
		return NewsEntity.class;
	}
public Page<NewsEntity> findAllWithPage(Pageable page){
		
		return executeNativeSqlWithPage(page);
		
	}
	// tất cả các services cần thêm hàm search.
			@SuppressWarnings("unchecked")
			public  Page<NewsEntity> searchAndListPage(Search searchModel,Pageable page) {
				
				// khởi tạo câu lệnh
				
				try {
					Table tbl = clazz().getAnnotation(Table.class);
					String sql = "SELECT * FROM "+tbl.name()+" p WHERE 1=1";
					if(!StringUtils.isNullOrEmpty(searchModel.getSeo())) {
						sql=sql+" p.seo = :seo";
						
					}
					// tim kiem san pham theo seachText
					if (!StringUtils.isNullOrEmpty(searchModel.getKeyWord())) {
						sql += " and (p.title like  :keyword " + 
					
								" or p.short_description like  :keyword )";
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
					return new PageImpl<NewsEntity>( query.getResultList());
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
				// chi lay san pham chua xoa
//				sql += " and p.status=1 ";

				
			}
			@Transactional
			public NewsEntity edit(HttpServletRequest request, MultipartFile newstAvatar, NewsEntity entity)throws IllegalStateException, IOException {
				System.out.println("idcc"+entity.getId());
				NewsEntity newEntity=findById(entity.getId());
				String uploadDir =  "/uploads/image";
		         String realPath = request.getServletContext().getRealPath(uploadDir);
		      
		       
		         if(!isEmptyUploadFile(newstAvatar)) {
		 			//xoa avatar cu
		        	 new File("C:\\Users\\0961011310\\eclipse-workspace\\project-Devpro-springboot\\src\\main\\resources"+ newEntity.getImage()).delete();
		        	 
		 			//them avatar moi
		        	 newstAvatar.transferTo(new File("C:\\Users\\0961011310\\eclipse-workspace\\project-Devpro-springboot\\src\\main\\resources\\template\\web\\image\\"
		        			+ newstAvatar.getOriginalFilename()));
		        	 entity.setImage("/template/web/image/" 
		 					+ newstAvatar.getOriginalFilename());
		        	
		 		}
				
				return super.saveOrUpdate(entity);
			}
			@SuppressWarnings("unused")
			private boolean isEmptyUploadFile(MultipartFile image) {
				return image == null || image.getOriginalFilename().isEmpty();
			}
			@Transactional
			public NewsEntity add(HttpServletRequest request, MultipartFile newstAvatar, NewsEntity entity)throws IllegalStateException, IOException {
//				
//				String uploadDir =  "/uploads/image";
//		         String realPath = request.getServletContext().getRealPath(uploadDir);
//		      
//		       
		         if(!isEmptyUploadFile(newstAvatar)) {
		 		
		        	 
		 			//them avatar moi
		        	 newstAvatar.transferTo(new File("C:\\Users\\0961011310\\eclipse-workspace\\project-Devpro-springboot\\src\\main\\resources\\template\\web\\image\\"
		        			+ newstAvatar.getOriginalFilename()));
		        	 entity.setImage("/template/web/image/" 
		 					+ newstAvatar.getOriginalFilename());
		        	
		 		}
				
				return super.saveOrUpdate(entity);
			}

}
