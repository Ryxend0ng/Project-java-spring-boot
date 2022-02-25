package com.ryxen.repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

//import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.github.slugify.Slugify;
import com.mysql.cj.util.StringUtils;
import com.ryxen.dto.Search;
import com.ryxen.entity.ComicEntity;

@Repository
public class ComicRepository extends BaseRepository<ComicEntity>{
//	@Autowired
//	private Cloudinary cloud;
	@Override
	protected Class<ComicEntity> clazz() {
		// TODO Auto-generated method stub
		return ComicEntity.class;
	}
	public Page<ComicEntity> findAllWithPage(Pageable page){
		
		return executeNativeSqlWithPage(page);
		
	}
	// tất cả các services cần thêm hàm search.
			@SuppressWarnings("unchecked")
			public  Page<ComicEntity> searchAndListPage(Search searchModel,Pageable page) {
				
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
					" or p.author like  :keyword  " +
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
							System.out.println("sql:"+sql);
					return new PageImpl<ComicEntity>( query.getResultList());
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
				// chi lay san pham chua xoa
//				sql += " and p.status=1 ";

				
			}
//			@Transactional
//			public   void convert(){
//				List<ComicEntity> comics=findAll();
//				for(int i=0;i<comics.size();i++) {
//					comics.get(i).setSeo(new Slugify().slugify(comics.get(i).getTitle()));
//					saveOrUpdate(comics.get(i));
//				}
//				
//			
//				
//			}
//			public static void main(String[] args) {
//			
//				System.out.println(new Slugify().slugify("khoa hoc java"));
//			}
			@Transactional
			public ComicEntity edit(final HttpServletRequest request,MultipartFile comicstAvatar,ComicEntity comicsEntity)throws IllegalStateException, IOException {
				System.out.println("idcc"+comicsEntity.getId());
				ComicEntity comicEntity=findById(comicsEntity.getId());
//				String uploadDir =  "/uploads/image";
//		         String realPath = request.getServletContext().getRealPath(uploadDir);
//		      
//		         File uploadedFile = convertMultiPartToFile(comicstAvatar);
//		         if(!isEmptyUploadFile(comicstAvatar)) {
//		        	//them vao cloudinary
//		        	 Map uploadResult =cloud.uploader().upload(uploadedFile, ObjectUtils.asMap("resource_type","auto"));
//		 			//xoa avatar cu
//		        	 new File("C:\\Users\\0961011310\\eclipse-workspace\\project-Devpro-springboot\\src\\main\\resources"+ comicEntity.getImage()).delete();
//		        	 
//		 			//them avatar moi
//		        	 comicstAvatar.transferTo(new File("C:\\Users\\0961011310\\eclipse-workspace\\project-Devpro-springboot\\src\\main\\resources\\template\\web\\image\\"
//		        			+ comicstAvatar.getOriginalFilename()));
//		        	 comicsEntity.setImage(uploadResult.get("url").toString());
//		        	
//		 		}
				
				return super.saveOrUpdate(comicsEntity);
			}
			@SuppressWarnings("unused")
			private boolean isEmptyUploadFile(MultipartFile image) {
				return image == null || image.getOriginalFilename().isEmpty();
			}
			@Transactional
			public ComicEntity add(final HttpServletRequest request,MultipartFile comicstAvatar,ComicEntity comicsEntity)throws IllegalStateException, IOException {
//				
//				String uploadDir =  "/uploads/image";
//		         String realPath = request.getServletContext().getRealPath(uploadDir);
//		      
//		         File uploadedFile = convertMultiPartToFile(comicstAvatar);
//		         if(!isEmptyUploadFile(comicstAvatar)) {
//		        	//them vao cloudinary
//		        	 Map uploadResult = cloud.uploader().upload(uploadedFile, ObjectUtils.asMap("resource_type","auto"));
//		        	System.out.println(uploadResult.get("url").toString());
//		 			//them avatar moi
//		        	 comicstAvatar.transferTo(new File("C:\\Users\\0961011310\\eclipse-workspace\\project-Devpro-springboot\\src\\main\\resources\\template\\web\\image\\"
//		        			+ comicstAvatar.getOriginalFilename()));
//		        	 comicsEntity.setImage(uploadResult.get("url").toString());
//		        	
//		        	
//		 		}
				
				return super.saveOrUpdate(comicsEntity);
			}
			@SuppressWarnings("unused")
			private File convertMultiPartToFile(MultipartFile file) throws IOException {
		        File convFile = new File(file.getOriginalFilename());
		        FileOutputStream fos = new FileOutputStream(convFile);
		        fos.write(file.getBytes());
		        fos.close();
		        return convFile;
		    }

}
