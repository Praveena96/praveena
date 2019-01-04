package com.ecomm.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.model.Cart;
import com.ecomm.model.Category;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;
import com.ecomm.model.UserDetail;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm")

public class DBConfig {
	@Bean(name="dataSource")
public  DataSource getH2DataSource()
{
	DriverManagerDataSource datasource=new DriverManagerDataSource();
	datasource.setDriverClassName("org.h2.Driver");
	datasource.setUrl("jdbc:h2:tcp://localhost/~/pradee");
	datasource.setUsername("pravee");
	datasource.setPassword("pravee");
	System.out.println("datasouce obj created");
	return datasource;
}
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory()
{
	Properties hibernateProp=new Properties();
	hibernateProp.put("hibernate.hbm2ddl.auto","update");
	hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
	factory.addProperties(hibernateProp);
	factory.addAnnotatedClass(Category.class);
	factory.addAnnotatedClass(Product.class);
	factory.addAnnotatedClass(UserDetail.class);
	factory.addAnnotatedClass(Supplier.class);
	factory.addAnnotatedClass(Cart.class);
	factory.addAnnotatedClass(OrderDetail.class);
	
	
	
	System.out.println("sessionfactory obj created");
	return factory.buildSessionFactory();
}

@Bean(name="TransactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	System.out.println("Transaction Manager Object Created");
	return new HibernateTransactionManager(sessionFactory);
	
}

}
