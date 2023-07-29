package springapplication.crudoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CrudoperationsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudoperationsApplication.class, args);
	}
}
