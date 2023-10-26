package wrt.group.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class YsmSusApplication {
	public static void main(String[] args) {
		SpringApplication.run(YsmSusApplication.class, args);
	}

}
