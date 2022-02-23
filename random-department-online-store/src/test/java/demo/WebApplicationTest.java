package demo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import demo.entity.ProductCategory;

@SpringBootTest
@AutoConfigureMockMvc
public class WebApplicationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnCorrectView() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("index"))
				.andExpect(content().string(containsString("Home")));
	}
	@Test
	public void shouldReturnCorrectView2() throws Exception {
		this.mockMvc.perform(get("/shop")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("category"))
				.andExpect(content().string(containsString("Home")));
	}
	@Test
	public void shouldContainModelAttributes() throws Exception {
		this.mockMvc.perform(get("/shop")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("categories"))
				.andExpect(model().attribute("categories", everyItem(instanceOf(ProductCategory.class))));
	}
}

