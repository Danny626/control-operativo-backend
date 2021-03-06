package com.albo.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.albo.controlop.repository", 
		entityManagerFactoryRef = "controlopEntityManager", 
		transactionManagerRef = "controlopTransactionManager")
public class ControlOpDatabaseConfig {

	@Value("${spring.datasource.control-operativo.hibernate-hbm2ddl-auto}")
	private String ddlMode;

	@Primary
	@Bean
	public PlatformTransactionManager controlopTransactionManager() {
		return new JpaTransactionManager(controlopEntityManager().getObject());
	}

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean controlopEntityManager() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", ddlMode);
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
		properties.put("hibernate.schema_update.unique_constraint_strategy", "RECREATE_QUIETLY");

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(controlopDataSource());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setPackagesToScan("com.albo.controlop.model");
		factoryBean.setJpaPropertyMap(properties);

		return factoryBean;
	}

	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.control-operativo")
	public DataSource controlopDataSource() {
		return DataSourceBuilder.create().build();
	}
	
}
