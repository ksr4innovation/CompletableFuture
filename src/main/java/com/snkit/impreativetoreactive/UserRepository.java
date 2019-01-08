package com.snkit.impreativetoreactive;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>,JpaSpecificationExecutor<UserEntity>{
	
	public List<UserEntity> findByEmail(String email);
	
	public List<UserEntity> findByName(String name);
	
	public List<UserEntity> findByEmailAndName(String email,String name);
	
	
	
	@Query("select ue from UserEntity ue where ue.email=:inputEmail ")
	public List<UserEntity> getEmployeesByEmail(@Param("inputEmail") String inputEmail);
	
	
	@Query("select ue from UserEntity ue where ue.email=?1 and ue.name =?2 ")
	public List<UserEntity> getEmployeesByEmailName( String inputEmail,String name);
	
	
	@Query("select distinct(ue) from UserEntity ue inner join ue.userAddressEntityList ud where ue.email=:inputEmail and ud.status='Active' ")
	public List<UserEntity> getEmployeesByEmailNplusOneProblem(@Param("inputEmail") String inputEmail);
	
	@Query("select distinct(ue) from UserEntity ue  join fetch ue.userAddressEntityList ud where ue.email=:inputEmail and ud.status='Active' ")
	public List<UserEntity> getEmployeesByEmailJoinFetch(@Param("inputEmail") String inputEmail);
	
	@Query("select ue from UserEntity ue ")
	public List<UserEntity> getAllUser();
	
	@Query("select ue from UserEntity ue ")
	public List<UserEntity> getAllUsersAll();
	



}
