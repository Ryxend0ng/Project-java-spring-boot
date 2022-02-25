package com.ryxen.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ryxen.entity.UserEntity;
import com.ryxen.oauth.CustomOAuth2UserService;
import com.ryxen.oauth.OAuth2AuthenticationSuccessHandler;
import com.ryxen.security.JwtTokenFilterConfigurer;
import com.ryxen.security.JwtTokenProvider;
import com.ryxen.service.impl.CustomerUserDetailsService;
import com.ryxen.utils.HttpCookieOAuth2AuthorizationRequestRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final PasswordEncoder  passwordEncoder;
	private final CustomerUserDetailsService user;
	
	@Autowired
    private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;
	
	@Autowired
	private CustomOAuth2UserService customOAuth2UserService;
	
	@Autowired
	private OAuth2AuthenticationSuccessHandler oauthSucess;
	@Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder, CustomerUserDetailsService user) {
        // TODO Auto-generated constructor stub
        this.passwordEncoder = passwordEncoder;
		this.user = user;
       
    }
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager bean
        return super.authenticationManagerBean();
    }
	@Bean
    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }
	@Autowired
	 private JwtTokenProvider jwtTokenProvider;
	
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.cors()
		.and()
		
		.csrf().disable()
		.formLogin()
        .disable()
        .httpBasic()
        .disable()
		.authorizeRequests()
		.antMatchers("/home","/manager/**","/template/**","/upload/**","/oauth/**","/auth/**").permitAll()
		.antMatchers("/admin/**").hasAuthority("ADMIN")
//		.and()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.oauth2Login()
			.loginPage("/login")
			.authorizationEndpoint()
            
            .authorizationRequestRepository(cookieAuthorizationRequestRepository())
            .and()
        .redirectionEndpoint()
            .baseUri("/oauth2/callback/*")
            .and()
			.userInfoEndpoint().userService(customOAuth2UserService)
			.and()
			.successHandler(oauthSucess)
		.and()
//		.formLogin()
//		.loginPage("/login")
//		.usernameParameter("username")
//		.passwordParameter("password")
//		.loginProcessingUrl("/perfom_login")
//		.defaultSuccessUrl("/handle-sucess")
//		.failureUrl("/login?login_error=true")
//		.permitAll()
//		.and()
//		.rememberMe().tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
//		.key("remember").rememberMeParameter("remember-me")// default 2 weeks
//		.and()
//		.exceptionHandling().accessDeniedPage("/exception-handle")
//		.and()
		.apply(new JwtTokenFilterConfigurer(jwtTokenProvider))
		
//		.and()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		.and()
		
		.logout()
		
		.clearAuthentication(true)
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID", "remember-me")
		.logoutSuccessUrl("/login")
		.permitAll();
	}
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(daoAuthenticationProvider());
	    }

	    @Bean
	    public DaoAuthenticationProvider daoAuthenticationProvider() {
	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setPasswordEncoder(passwordEncoder);
	        provider.setUserDetailsService(user);
	        
	        return provider;
	    }
	    public static void main(String[] args) {
			System.out.println( new BCryptPasswordEncoder(10).encode("123456"));
		
		}
}
