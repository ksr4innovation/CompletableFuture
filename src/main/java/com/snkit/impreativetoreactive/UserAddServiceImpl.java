package com.snkit.impreativetoreactive;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="userAddService")
@Transactional
public class UserAddServiceImpl {

	@Autowired
	UserServiceImpl userService;
	
	public void getUserAdd() {

		CompletableFuture<List<UserVO>> userAddList = userService.getUserAdd();
		System.out.println("  From after first  async calls ");
		CompletableFuture<List<UserVO>> addUserList = 	userService.getAddUser();
		
		System.out.println("  From after async calls ");
		
		
		System.out.println("   after join async calls ");
		
		CompletableFuture.allOf(userAddList,addUserList).join();
		
		System.out.println("   CompletableFuture.allOf(userAddList,addUserList).join();  after join async calls ");
		try {
			userAddList.get();
			System.out.println("   userAddList.get()  "+userAddList.get().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addUserList.get();
			System.out.println("   addUserList.get();  "+addUserList.get().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
