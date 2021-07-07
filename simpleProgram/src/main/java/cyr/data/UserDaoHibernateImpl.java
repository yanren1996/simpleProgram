package cyr.data;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cyr.User;

@Repository
public class UserDaoHibernateImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	public UserDaoHibernateImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User findUser(String account) {
		Session session = sessionFactory.openSession();
		User user= session.get(User.class, account);
		Hibernate.initialize(user);
		session.close();
		return user;
	}

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List userList(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("from User where mail=?");
		query.setParameter(0, "easy10441@gmail.com");
		List users=query.list();
		
		session.getTransaction().commit();
		session.close();
		return users;
	}
	
	@Override
	public void update(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
	}
}
