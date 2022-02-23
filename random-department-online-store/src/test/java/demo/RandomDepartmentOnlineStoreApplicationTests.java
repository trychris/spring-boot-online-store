package demo;

//https://spring.io/guides/gs/testing-web/
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import demo.web.BrowseShopController;
import demo.web.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
//The @SpringBootTest annotation tells Spring Boot to look for a main 
//configuration class (one with @SpringBootApplication, for instance) and 
//use that to start a Spring application context.
class RandomDepartmentOnlineStoreApplicationTests {
	@Autowired
	private HomeController homeController;
	@Autowired
	private BrowseShopController shopController;

	@Test
//	Test that the context is creating all controllers
	void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
		assertThat(shopController).isNotNull();
	}
}
