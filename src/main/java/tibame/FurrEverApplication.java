package tibame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FurrEverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FurrEverApplication.class, args);
	}

}
