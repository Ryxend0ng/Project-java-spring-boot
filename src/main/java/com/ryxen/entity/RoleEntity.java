package com.ryxen.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;



@Entity
@Table(name = "tbl_role")
public class RoleEntity extends BaseEntity implements GrantedAuthority{
	@Column(name = "name",nullable = false,length = 255)
	private String name;
	
	@Column(name = "code",nullable = false,length = 255)
	private String code;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_user_role", 
				   joinColumns = @JoinColumn(name = "role_id"), 
				   inverseJoinColumns = @JoinColumn(name = "user_id"))	
	private List<UserEntity> users=new ArrayList<UserEntity>();
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	
}
