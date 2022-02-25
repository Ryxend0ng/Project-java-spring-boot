package com.ryxen.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.ryxen.dto.AuthProvider;




@Entity
@Table(name = "tbl_user")
public class UserEntity extends BaseEntity implements OAuth2User,UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "username",nullable = false,length = 255)
	private String userName;
	
	@Column(name = "password",nullable = false,length = 255)
	private String password;
	
	@Column(name = "email",nullable = false,length = 45)
	private String email;
	
	@Column(name = "provider" ,nullable = false, length = 45 )
	@Enumerated(EnumType.STRING)
    private AuthProvider provider;

	@Column(name = "provider_id" ,nullable = false, length = 45 )
    private String providerId;
    
	@Column(name = "image_url" ,nullable = false, length = 45 )
    private String imageUrl;
    
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public AuthProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "users")
	private List<RoleEntity> roles=new ArrayList<RoleEntity>();
	
	public void addUserAndRoleIntoTblUseRole(RoleEntity role) {
		roles.add(role);		
		role.getUsers().add(this);
	}
	/*Trong annotation @JoinTable mà mình định nghĩa trong entity Developer, ở đây chúng ta có 3 thuộc tính chúng ta cần phải khai báo:

	name: một là tên của joinTable (là bảng developer_project đó các bạn),
	joinColumns: hai là tên column trong bảng joinTable mà bảng developer sẽ foreign key tới,
	inverseJoinColumns: ba là tên column trong bảng joinTable mà bảng project sẽ foreign key tới.*/
//
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
	private List<CommentEntity> comments=new ArrayList<CommentEntity>();

	

	/**
	 * them  1 comment vao danh sach @OneToMany
	 * @param product
	 */
	public void addRelationComment(CommentEntity comment) {
		comments.add(comment);
		comment.setUser(this);
	}

	/**
	 * xoa 1 comment khoi danh sach @OneToMany
	 * @param product
	 */
	public void deleteRelationComment(CommentEntity comment) {
		comments.remove(comment);
		comment.setUser(null);
	}
	
	
	



	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getUserName();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return getAttributes();
	}
	
}
