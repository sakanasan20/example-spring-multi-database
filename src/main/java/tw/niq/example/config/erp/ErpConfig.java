package tw.niq.example.config.erp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tw.niq.example.entity.erp.TcSckFile;
import tw.niq.example.repository.erp.TcSckFileRepository;

@Configuration
@EnableJpaRepositories(
		basePackageClasses = TcSckFileRepository.class, 
		entityManagerFactoryRef = "erpEntityManagerFactory", 
		transactionManagerRef = "erpTransactionManager")
@EnableTransactionManagement
public class ErpConfig {
	
	@Bean("erpDataSource")
	@ConfigurationProperties("tw.niq.example.datasource.erp")
	public DataSource erpDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean("erpEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean erpEntityManagerFactory(
			@Qualifier("erpDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource).packages(TcSckFile.class).persistenceUnit("erpDataSource").build();
	}

	@Bean("erpTransactionManager")
	public PlatformTransactionManager erpTransactionManager(
			@Qualifier("erpEntityManagerFactory") LocalContainerEntityManagerFactoryBean erpEntityManagerFactory) {
		return new JpaTransactionManager(erpEntityManagerFactory.getObject());
	}
	
}
