package com.snkit.impreativetoreactive;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;



@SqlResultSetMappings(
		value= {				
				@SqlResultSetMapping(name="VOUserGropuByNameMapping",classes=@ConstructorResult(targetClass=UserVO.class,
						columns= {
						@ColumnResult(name="countname",type=Long.class),
						@ColumnResult(name="name",type=String.class)
						
				})),
				
				@SqlResultSetMapping(name="getUserGroupByNameEntityMapping", entities=@EntityResult(entityClass=UserEntity.class,
				fields= {
						@FieldResult(column="countid",name="id"),
						@FieldResult(column="groupname",name="name"),
						@FieldResult(column="email",name="email")
				}))
			
		})
@NamedNativeQueries(
		value=   {
				@NamedNativeQuery(name="native.getUserGroupByName",query="SELECT count(*) as countname,name FROM microservice.user group by name ",
						resultSetMapping="VOUserGropuByNameMapping"),
				
				@NamedNativeQuery(name="native.getUserGroupByNameEntityMapping",query="SELECT id as countid, name as groupname ,email  FROM microservice.user group by name ",
				resultSetMapping="getUserGroupByNameEntityMapping")
				
		        }
			
		)


@Entity
@Table(schema="microservice", name="user")
public class UserEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name="email",nullable=true)
	private String email;
	
	
	@Column(name="name")
	private String name;
	
	

	
	@OneToMany(mappedBy="userEntity",cascade=CascadeType.ALL)	
	private List<UserAddressEntity> userAddressEntityList = new ArrayList<UserAddressEntity>();
	
	public UserEntity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", email=" + email + ", name=" + name + "]";
	}

	public List<UserAddressEntity> getUserAddressEntityList() {
		return userAddressEntityList;
	}

	public void setUserAddressEntityList(List<UserAddressEntity> userAddressEntityList) {
		this.userAddressEntityList = userAddressEntityList;
	}

	
}
