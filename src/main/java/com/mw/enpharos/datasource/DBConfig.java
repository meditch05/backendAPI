package com.mw.enpharos.datasource;

import com.zaxxer.hikari.HikariDataSource;
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

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.mw.enpharos.repository", // TODO Repository 패키지 지정
        transactionManagerRef = "trkp_transactionManager",
        entityManagerFactoryRef = "trkp_entityManagerFactory"
)
public class DBConfig {
	
	/* ====================================================
	 * application.properties 설정
	 * ====================================================
		spring.datasource.mariadb.jdbc-url=jdbc:mariadb://127.0.0.1:3306/test
		spring.datasource.mariadb.driver-class-name=org.mariadb.jdbc.Driver
		spring.datasource.mariadb.username=root
		spring.datasource.mariadb.password=alskfl12~!
		spring.jpa.open-in-view=false
		spring.jpa.generate-ddl=true
		spring.jpa.show-sql=true
		spring.jpa.hibernate.ddl-auto=update
	 */
	
    @Primary
    @Bean(name = "trkp_dataSource")
    @ConfigurationProperties("spring.datasource") // application.properties에서 설정한 DataSource명
    public DataSource mariaDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "trkp_entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("trkp_dataSource") DataSource dataSource) {
        Map<String, String> map = new HashMap<>();
        map.put("hibernate.ejb.naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringNamingStrategy");
        map.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        return builder.dataSource(dataSource)
                .packages("com.mw.enpharos.entity") // TODO Model 패키지 지정
                .properties(map)
                .build();
    }

    @Primary
    @Bean(name = "trkp_transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("trkp_entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}