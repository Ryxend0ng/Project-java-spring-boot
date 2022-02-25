package com.ryxen;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
import com.ryxen.controller.user.TestController;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.oauth.CustomOAuth2UserService;
import com.ryxen.oauth.OAuth2AuthenticationSuccessHandler;
import com.ryxen.security.JwtTokenProvider;
import com.ryxen.service.ICategoryService;
import com.ryxen.service.impl.CategoryService;
import com.ryxen.service.impl.CustomerUserDetailsService;

@WebMvcTest(TestController.class)
public class CategoryControllerTest {
	@MockBean
	private ICategoryService caService;
	@MockBean
	private CustomerUserDetailsService cusRe;
	@MockBean
	private CustomOAuth2UserService cusOau;
	@MockBean
	private OAuth2AuthenticationSuccessHandler oauSuces;
	@MockBean
	PasswordEncoder passwordEncoder;
	@MockBean
	private JwtTokenProvider jwt;
	@MockBean
	private ClientRegistrationRepository client;
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void testListSuper() throws Exception {
		List<CategoryDTO> caDto=new ArrayList<CategoryDTO>();
		for(int i=0;i<5;i++) {
			CategoryDTO caDto1=new CategoryDTO();
			caDto1.setId(i);
			caDto1.setName(i+"hello");
		}
		Mockito.when(caService.findAll()).thenReturn(caDto);
		System.out.println("find all"+caService.findAll());
		mockMvc.perform(
				get("/api/list/category"))
				.andDo(print())
				.andExpect(status().isOk())	
				.andExpect(content().string("alo"))
				;
	}
}
