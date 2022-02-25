package com.ryxen;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Console;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ryxen.converter.CategoryConverter;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.entity.CategoryEntity;
import com.ryxen.repository.CategoryRepository;
import com.ryxen.service.ICategoryService;
import com.ryxen.service.impl.CategoryService;



@SpringBootTest
public class CategoryServiceTest {
	
	@MockBean
	private CategoryRepository cateRe;
	@Autowired
	private ICategoryService todoService;
	
	@Test
	public void testfindById() {
		CategoryEntity caEn=new CategoryEntity();
		caEn.setId(19);
		caEn.setName("kinh di");
		caEn.setCode("kinh-di");
		Mockito.when(cateRe.findById(1)).thenReturn(caEn);
		CategoryDTO caDto=todoService.findById(1);		
		assertEquals(caDto.getId(), 2);
	}
	

}
