package demo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.entity.CartItem;
import demo.entity.CustomerAccount;
import demo.repository.CartItemRepository;
import demo.service.ShoppingCartServices;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
	
	@ModelAttribute("currentUser")
	public CustomerAccount getCurrentAccount(Authentication authentication) {
		return (authentication == null) ? null:(CustomerAccount) authentication.getPrincipal();
	}
	
	@Autowired
	private ShoppingCartServices shoppingCartServices;
	

	@GetMapping
	public String showShoppingCart(Model model, @AuthenticationPrincipal CustomerAccount customer) {
		if(customer==null) {
			return "redirect:/login";
		}
		List<CartItem> cartItems = shoppingCartServices.listCartItems(customer);
		model.addAttribute("customerItems", cartItems);
		return "cart";
	}

}
