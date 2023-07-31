package springapplication.crudoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class CrudoperationsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudoperationsApplication.class, args);
/*		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "1234"); // the application is successfully connecting to the database
			System.out.println("Connected to the database.");
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error connecting to the database: " + e.getMessage());
		}*/
	}
}
