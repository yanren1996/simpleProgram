package cyr.data;

import java.util.List;

import cyr.User;

public interface UserDao {
	public User findUser(String account);
	public void addUser(User user);
	public List userList();
	public void update(User user);
}
