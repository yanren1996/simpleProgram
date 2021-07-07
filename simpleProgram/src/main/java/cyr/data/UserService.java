package cyr.data;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import cyr.User;

@Service
public class UserService {
	
	public UserDao dao;
	
	public UserService(UserDao dao) {
		this.dao=dao;
	}
	
	public boolean hasThisAccount(String account) {
		if(dao.findUser(account) != null) {
			return true;
		}
		return false;
	}
	
	public boolean truePassword(String account,String password) {
		User user=dao.findUser(account);
		if(user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	
	public void addUser(User user) {
		dao.addUser(user);
	}
	
	public User findById(String account) {
		return dao.findUser(account);
	}
	
	public void updateUser(User user) {
		dao.update(user);
	}
	
	public void allUser(){
		//List<User> users=dao.userList();
		Iterator users=dao.userList().iterator();
		while(users.hasNext()) {
			User user=(User)users.next();
			System.out.println(user.getAccount());
		}
	}
}
