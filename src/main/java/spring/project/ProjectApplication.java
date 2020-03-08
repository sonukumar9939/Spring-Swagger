package spring.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProjectApplication.class, args);

		/*
		 * Display list of all the beans which are created by spring auto configuration
		 * project
		 */
		for (String bean : context.getBeanDefinitionNames()) {
			// System.out.println("Beans" + bean);
		}
	}

}
