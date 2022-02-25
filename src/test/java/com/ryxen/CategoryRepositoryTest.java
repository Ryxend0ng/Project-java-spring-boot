package com.ryxen;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import com.ryxen.entity.CategoryEntity;
import com.ryxen.repository.CategoryRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//@ContextConfiguration(classes=StartServer.class)
@ComponentScan(basePackages = {"com.ryxen.repository"})
public   class CategoryRepositoryTest {

	@Autowired
	public CategoryRepository cateRe;
	
	@Test
	@Disabled
	public void testFindById() {
		CategoryEntity cateEn=cateRe.findById(1);
		//kinh-di
		assertThat(cateEn.getCode()).isEqualTo("kinh-di1");
	}
	
	//@Rollback(value = false)
	@Test
	@Rollback(value = false)
	public void testCreateCaategory() {
		CategoryEntity cate=new CategoryEntity();
		cate.setName("test category");
		cate.setCode("test-category");
		CategoryEntity cateEn=cateRe.saveOrUpdate(cate);
		assertNotNull(cateEn);
	}
	//@Test
	//@Rollback(value = false)
	@Test
	@Rollback(value = false)
	public void testUpdateCategory() {
		CategoryEntity cateEn=cateRe.findById(16);
		cateEn.setName("test12");
		CategoryEntity cateEn1=cateRe.saveOrUpdate(cateEn);
		assertNotNull(cateEn1);
	}
	@Test	
	public void testDeleteCategoryById() {
		Integer id=50;
		boolean extistId=cateRe.findById(id) != null ?true:false;
		System.out.println(extistId);
		cateRe.deleteById(id);
		assertTrue(extistId);
		assertFalse(extistId,"khong ton tai id :"+id);
	}
	@Test
	public void testCategoryList() {
		List<CategoryEntity>list=cateRe.findAll();
		//so sanh gia tri length cua list voi 0. Neu khong bang nhau thi dung,bang nhau thi sai
		assertEquals(list.size(), 0);
	}
	
}
