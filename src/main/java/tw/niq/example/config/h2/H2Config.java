package tw.niq.example.config.h2;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
		basePackageClasses = {
				
		}, 
		entityManagerFactoryRef = "h2EntityManagerFactory", 
		transactionManagerRef = "h2TransactionManager")
@EnableTransactionManagement
public class H2Config {
	
	@Bean("h2DataSource")
	@Primary
	@ConfigurationProperties("tw.niq.example.datasource.h2")
	public DataSource h2DataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean("h2EntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(
			@Qualifier("h2DataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(dataSource)
				.packages("")
				.persistenceUnit("h2DataSource")
				.build();
	}

	@Bean("h2TransactionManager")
	@Primary
	public PlatformTransactionManager h2TransactionManager(
			@Qualifier("h2EntityManagerFactory") LocalContainerEntityManagerFactoryBean h2EntityManagerFactory) {
		return new JpaTransactionManager(h2EntityManagerFactory.getObject());
	}
	
}
