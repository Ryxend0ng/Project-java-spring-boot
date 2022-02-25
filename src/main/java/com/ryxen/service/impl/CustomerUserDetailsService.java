package com.ryxen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ryxen.entity.UserEntity;
import com.ryxen.repository.UserRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{
	@Autowired
	private UserService userSer;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity user= userSer.loadByUserName(username);
		return  user;
	}

}
