package demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import demo.repository.ProductCategoryRepository;
import demo.web.BrowseShopController;
import demo.web.HomeController;

@WebMvcTest({HomeController.class, BrowseShopController.class})
public class WebLayerOnlyTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductCategoryRepository productCategoryRepo;

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
}

