package demo.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.CustomerAccount;
import demo.entity.Product;
import demo.repository.ProductRepository;
import demo.service.ShoppingCartServices;

@RestController
public class ShoppingCartRestController {
	@Autowired
	private ShoppingCartServices cartService;
	
	@Autowired 
	private ProductRepository productRepo;
	
	@PostMapping("/cart/add/{pid}/{qty}")
	public String addProductToCart(@PathVariable("pid") Long productId,  
			@PathVariable("qty") Integer productQuantity, 
			@AuthenticationPrincipal CustomerAccount customer) {
		if(customer==null) {
			return "You must login to add this product to the shopping cart.";
		}
		Optional<Product> product = productRepo.findById(productId);
		Integer addedQuantity = cartService.addProduct(customer, product.get(), productQuantity);
		return addedQuantity + " item(s) of this product were added to your shopping cart";
	}
	@PostMapping("/cart/update/{pid}/{qty}")
	public String updateQuantity(@PathVariable("pid") Long productId,  
			@PathVariable("qty") Integer productQuantity, 
			@AuthenticationPrincipal CustomerAccount customer) {
		if(customer==null) {
			return "You must login to change the quantity of this product in your shopping cart.";
		}
		Optional<Product> product = productRepo.findById(productId);
		cartService.updateQuantity(customer, product.get(), productQuantity);
		Double subtotal = product.get().getUnitPrice() * productQuantity;
		return String.valueOf(subtotal);
	}
	@PostMapping("/cart/delete/{pid}")
	public String deleteCartItem(@PathVariable("pid") Long productId,   
			@AuthenticationPrincipal CustomerAccount customer) {
		if(customer==null) {
			return "You must login to delete this product from your shopping cart.";
		}
		Optional<Product> product = productRepo.findById(productId);
		cartService.deleteCartItem(customer, product.get());
		return "This product has been removed from your shopping cart";
	}
	

}
