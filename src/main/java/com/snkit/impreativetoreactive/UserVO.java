package com.snkit.impreativetoreactive;

public class UserVO {
	
	public UserVO(){
		
	}
	
	
	


	private Long id;
	
	private String name;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + "]";
	}

	
	
	
	

}
