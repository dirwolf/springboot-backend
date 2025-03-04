package net.javaguides.springboot;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

//	acquire employee repo
	@Autowired
	private EmployeeRepository employerepo;
	@Override
	public void run(String... args) throws Exception {
		Employee emp1 = new Employee();
		emp1.setFirstName("Lanaaaaaaaa");
		emp1.setLastName("Rhodegdgs");
		emp1.setEmailId("rhodedgdgs@gmail.com");

		employerepo.save(emp1);
	}
}
