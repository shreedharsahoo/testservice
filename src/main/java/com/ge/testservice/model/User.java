package com.ge.testservice.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author shreedhar sahoo
 *
 */
@Document(collection="user")
public class User {
    //private static final long serialVersionUID = -723583058586873479L;

    @NotNull
    private String userId;
    
    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String username;

    @NotNull
    private String createdTimestamp;
    
    private String modifiedTimestamp;
    
    @NotNull
    private String status;

    @NotNull
    private Boolean isAdmin;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(@NotNull String userId, @NotNull String password, @NotNull String name, @NotNull String username,
			@NotNull String createdTimestamp, String modifiedTimestamp, @NotNull String status, @NotNull Boolean isAdmin) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.username = username;
		this.createdTimestamp = createdTimestamp;
		this.modifiedTimestamp = modifiedTimestamp;
		this.status = status;
		this.isAdmin = isAdmin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(String createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public String getModifiedTimestamp() {
		return modifiedTimestamp;
	}

	public void setModifiedTimestamp(String modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

    
}
