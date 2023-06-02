package tw.niq.example.config.scm;

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

import tw.niq.example.entity.scm.DeliveryInspectionReport;
import tw.niq.example.repository.scm.ActionLogRepository;
import tw.niq.example.repository.scm.DeliveryInspectionReportRepository;

@Configuration
@EnableJpaRepositories(
		basePackageClasses = {
				DeliveryInspectionReportRepository.class, 
				ActionLogRepository.class
		}, 
		entityManagerFactoryRef = "scmEntityManagerFactory", 
		transactionManagerRef = "scmTransactionManager")
@EnableTransactionManagement
public class ScmConfig {
	
	@Bean("scmDataSource")
	@ConfigurationProperties("tw.niq.example.datasource.scm")
	public DataSource scmDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean("scmEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean scmEntityManagerFactory(
			@Qualifier("scmDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(dataSource)
				.packages(
						DeliveryInspectionReport.class, 
						ActionLogRepository.class)
				.persistenceUnit("scmDataSource")
				.build();
	}

	@Bean("scmTransactionManager")
	public PlatformTransactionManager scmTransactionManager(
			@Qualifier("scmEntityManagerFactory") LocalContainerEntityManagerFactoryBean scmEntityManagerFactory) {
		return new JpaTransactionManager(scmEntityManagerFactory.getObject());
	}
	
}
