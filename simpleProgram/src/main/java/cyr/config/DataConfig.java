package cyr.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

@org.springframework.context.annotation.Configuration

public class DataConfig {
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		ds.setUsername("user");
		ds.setPassword("1234");
		ds.setUrl("jdbc:derby://localhost:1527/sample;create=true");
		ds.setInitialSize(10);
		return ds;
	}
	
	@Bean
	public Configuration configuration() {
		Configuration configuration = new Configuration();
		configuration.configure();
		return configuration;
	}
	
	@Bean
	public StandardServiceRegistry serviceRegistry(Configuration configuration) {
		return new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	}
	
	@Bean(destroyMethod="close")
	public SessionFactory sessionFactory(Configuration configuration,StandardServiceRegistry serviceRegistry) {
		//return configuration.buildSessionFactory(serviceRegistry);
		return configuration.buildSessionFactory();
	}
	
}
