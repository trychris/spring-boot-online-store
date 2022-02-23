package demo.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.repository.ProductCategoryRepository;
import demo.repository.ProductRepository;
import demo.entity.ProductCategory;
import demo.entity.ProductCategory.Category;

@Controller
@RequestMapping("/shop")
public class BrowseShopController{
	@Autowired
	private ProductCategoryRepository productCategoryRepo;
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping
	public String getCategories(Model model) {
		List<ProductCategory> categories = (List<ProductCategory>) productCategoryRepo.findAll();
		model.addAttribute("categories", categories);
		return "category";
	}
	@GetMapping("/{categoryName}")
	public String getProductsByCategory(@PathVariable Category categoryName, Model model) {	
		model.addAttribute("products", productRepo.findProductsByCategory(categoryName));
		return "products";
	}
	@GetMapping("/{categoryName}/{id}")
	public String getProductsBId(@PathVariable Long id, Model model) {	
		model.addAttribute("product", productRepo.findById(id).get());
//		System.out.println(model.getAttribute("product"));
		return "single-product";
	}
	
	
}

