package org.arpit.java2blog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import(HibernateConfiguration.class)
@SpringBootApplication(exclude = {JpaRepositoriesAutoConfiguration.class})
public class SpringBootHibernateApplication {

	public static void main(String[] args) 
	{

		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}

}