package com.ryxen.security;

import java.util.Base64;
import java.util.Date;
import java.util.stream.Collector;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ryxen.config.BlidingProperties;
import com.ryxen.entity.UserEntity;
import com.ryxen.exception.CustomException;
import com.ryxen.service.impl.CustomerUserDetailsService;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtTokenProvider {
	@Autowired
	private BlidingProperties blinding;

	private String jwtSecret="bezKoderSecretKey";
	
	
	private long jwtExpirationMs=864000000L;
	
	@Autowired
	private CustomerUserDetailsService customer;
//	@PostConstruct
//	  protected void init() {
//		jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
//		
//	  }
	
	
	public String createJwtToken(Authentication auth) {
		UserEntity user= (UserEntity) auth.getPrincipal();
		System.out.println("username:"+user.getUsername());
		System.out.println("password:"+user.getPassword());
		Date now = new Date();
	    
		Date validity = new Date(now.getTime() + jwtExpirationMs);
		
		String jwt= Jwts.builder()
				.setSubject(user.getUsername())
				.setIssuedAt(now)
				.setExpiration(validity)
				
				.signWith(SignatureAlgorithm.HS256, jwtSecret)
			    .compact();
		return jwt;
	}
	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	 public Authentication getAuthentication(String token) {
		    UserDetails userDetails = customer.loadUserByUsername(getUsername(token));
		    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
	
	 public boolean validateToken(String token) {
		    try {
		      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		      return true;
		    } catch (JwtException | IllegalArgumentException e) {
		      throw new CustomException("Expired or invalid JWT token", HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	 public String resolveToken(HttpServletRequest req) {
		    String bearerToken = req.getHeader("Authorization");
		    System.out.println(blinding.getAuth().getTokenExpirationMsec());
		    System.out.println("bearn:"+bearerToken);
		    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
		      return bearerToken.substring(7);
		    }
		    return null;
		  }
}
