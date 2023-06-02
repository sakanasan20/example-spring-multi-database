package tw.niq.example.config.mes;

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

import tw.niq.example.entity.mes.TempTcItb;
import tw.niq.example.repository.mes.TempTcItbRepository;

@Configuration
@EnableJpaRepositories(
		basePackageClasses = TempTcItbRepository.class, 
		entityManagerFactoryRef = "mesEntityManagerFactory", 
		transactionManagerRef = "mesTransactionManager")
@EnableTransactionManagement
public class MesConfig {
	
	@Bean("mesDataSource")
	@ConfigurationProperties("tw.niq.example.datasource.mes")
	public DataSource mesDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean("mesEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean mesEntityManagerFactory(
			@Qualifier("mesDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource).packages(TempTcItb.class).persistenceUnit("mesDataSource").build();
	}

	@Bean("mesTransactionManager")
	public PlatformTransactionManager mesTransactionManager(
			@Qualifier("mesEntityManagerFactory") LocalContainerEntityManagerFactoryBean mesEntityManagerFactory) {
		return new JpaTransactionManager(mesEntityManagerFactory.getObject());
	}
	
}
