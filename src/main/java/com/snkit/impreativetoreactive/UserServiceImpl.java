package com.snkit.impreativetoreactive;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="userService")
@Transactional
public class UserServiceImpl {

	@Autowired
	UserRepository userRepository;
	@Async
	public CompletableFuture<List<UserVO>> getUserAdd() {

		List<UserEntity> userEntityList = userRepository.getAllUser();
		List<UserVO> userList = new ArrayList<UserVO>();
		try {
			Thread.sleep(7000);
			
			System.out.println("getUserAdd  ===== ");
			
			userEntityList.forEach(user -> {
				
				UserVO u = new UserVO();
				u.setId(user.getId());
				u.setName(user.getEmail());
				userList.add(u);
			});
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return CompletableFuture.completedFuture(userList);
	}
	@Async
	public CompletableFuture<List<UserVO>> getAddUser() {

		List<UserEntity> userEntityList = userRepository.getAllUser();
		List<UserVO> userList = new ArrayList<UserVO>();
		try {
			Thread.sleep(3000);
			
			System.out.println("getAddUser  ===== ");
			
			userEntityList.forEach(user -> {
				
				UserVO u = new UserVO();
				u.setId(user.getId());
				u.setName(user.getEmail());
				userList.add(u);
			});
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return CompletableFuture.completedFuture(userList);
	}
	
	
	
}
